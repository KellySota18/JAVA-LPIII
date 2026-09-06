package Reservas;

import Clientes.Cliente;
import Habitaciones.Habitacion;
import Notificaciones.ICanalNotificacion;
import Notificaciones.NotificadorReserva;
import Promociones.CalculadoraTarifa;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Coordina el proceso de reserva. Depende de abstracciones y de servicios
 * inyectados por constructor, no de implementaciones concretas.
 */
public class ControladorReservas {

    private final GestorDisponibilidad gestorDisponibilidad;
    private final CalculadoraTarifa calculadoraTarifa;
    private final ICanalNotificacion canal;
    private int contador = 1000;

    public ControladorReservas(GestorDisponibilidad gestorDisponibilidad,
                               CalculadoraTarifa calculadoraTarifa,
                               ICanalNotificacion canal) {
        this.gestorDisponibilidad = gestorDisponibilidad;
        this.calculadoraTarifa = calculadoraTarifa;
        this.canal = canal;
    }

    public Reserva crearReserva(Cliente cliente, Habitacion habitacion,
                                LocalDate fInicio, LocalDate fFin,
                                PoliticaCancelacion politica) {

        if (!gestorDisponibilidad.verificarDisponibilidad(habitacion, fInicio, fFin)) {
            System.out.println("La habitación " + habitacion.getNumero()
                    + " no está disponible del " + fInicio + " al " + fFin);
            return null;
        }

        Reserva reserva = new Reserva("R-" + (++contador), cliente, habitacion,
                fInicio, fFin, politica);
        reserva.setImporteTotal(calculadoraTarifa.calcularImporte(reserva));
        gestorDisponibilidad.registrar(reserva);

        System.out.println("Reserva " + reserva.getIdReserva() + " creada ("
                + politica.getNombre() + "): " + reserva);
        new NotificadorReserva(canal).notificarConfirmacion(
                cliente.getCorreo(), reserva.getIdReserva());
        return reserva;
    }

    public void procesarCancelacion(String idReserva) {
        Reserva reserva = buscarReserva(idReserva);
        if (reserva == null) {
            System.out.println("No existe la reserva " + idReserva);
            return;
        }
        PoliticaCancelacion politica = reserva.getPoliticaCancelacion();
        if (!politica.puedeCancelar(reserva)) {
            System.out.println("La política " + politica.getNombre()
                    + " no permite cancelar la reserva " + idReserva);
            return;
        }
        double penalizacion = reserva.getImporteTotal() * politica.calcularPenalizacion(reserva);
        reserva.anular();
        System.out.printf("Reserva %s cancelada (%s). Penalización: S/ %.2f%n",
                idReserva, politica.getNombre(), penalizacion);
        new NotificadorReserva(canal).notificarCancelacion(
                reserva.getCliente().getCorreo(), idReserva, penalizacion);
    }

    public List<Reserva> historialDeCliente(Cliente cliente) {
        List<Reserva> historial = new ArrayList<>();
        for (Reserva reserva : gestorDisponibilidad.getReservas()) {
            if (reserva.getCliente().getIdCliente().equals(cliente.getIdCliente())) {
                historial.add(reserva);
            }
        }
        return historial;
    }

    public List<Reserva> getReservas() {
        return gestorDisponibilidad.getReservas();
    }

    private Reserva buscarReserva(String idReserva) {
        for (Reserva reserva : gestorDisponibilidad.getReservas()) {
            if (reserva.getIdReserva().equals(idReserva)) {
                return reserva;
            }
        }
        return null;
    }
}
