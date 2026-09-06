package exp01_srp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ControladorReservas {

    private final List<Habitacion> habitaciones = new ArrayList<>();

    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void crearReserva(String idCliente, String numHabitacion,
                             LocalDate fInicio, LocalDate fFin) {

        Habitacion habitacion = buscarHabitacion(numHabitacion);
        GestorDisponibilidadHabitacion gestor = habitacion.getGestorDisponibilidad();

        if (gestor.verificarDisponibilidad(fInicio, fFin)) {
            gestor.marcarComoReservada(fInicio, fFin);
            System.out.println("Reserva confirmada para el cliente " + idCliente
                    + " en la habitación " + numHabitacion);
        } else {
            System.out.println("La habitación " + numHabitacion
                    + " no está disponible del " + fInicio + " al " + fFin);
        }
    }

    public void cancelarReserva(String numHabitacion, LocalDate fInicio, LocalDate fFin) {
        buscarHabitacion(numHabitacion).getGestorDisponibilidad()
                .marcarComoDisponible(fInicio, fFin);
        System.out.println("Habitación " + numHabitacion + " liberada.");
    }

    private Habitacion buscarHabitacion(String numero) {
        return habitaciones.stream()
                .filter(h -> h.getNumero().equals(numero))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Habitación no encontrada"));
    }
}
