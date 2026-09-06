package exp02_ocp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ControladorReservas {

    private final Map<String, Reserva> reservas = new HashMap<>();
    private int contador = 1000;

    public Reserva crearReserva(String idCliente, LocalDateTime fInicio,
                                double importe, PoliticaCancelacion politica) {
        Reserva reserva = new Reserva("R-" + (++contador), fInicio, importe, politica);
        reservas.put(reserva.getIdReserva(), reserva);
        System.out.println("Reserva " + reserva.getIdReserva() + " creada para " + idCliente
                + " con política " + politica.getNombre());
        return reserva;
    }

    public void procesarCancelacion(String idReserva) {
        Reserva reserva = reservas.get(idReserva);
        if (reserva == null) {
            System.out.println("No existe la reserva " + idReserva);
            return;
        }
        if (reserva.solicitarCancelacion()) {
            reservas.remove(idReserva);
        }
    }
}
