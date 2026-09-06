package exp02_ocp;

import java.time.LocalDateTime;

/** Demostración de la Experiencia 2 (OCP). */
public class MainOCP {

    public static void main(String[] args) {
        System.out.println("===== EXPERIENCIA 2: OCP =====");

        ControladorReservas controlador = new ControladorReservas();
        LocalDateTime checkIn = LocalDateTime.now().plusDays(5);

        Reserva r1 = controlador.crearReserva("C-001", checkIn, 480.0, new PoliticaCancelacionFlexible());
        Reserva r2 = controlador.crearReserva("C-002", checkIn, 960.0, new PoliticaCancelacionModerada());
        Reserva r3 = controlador.crearReserva("C-003", checkIn, 320.0, new PoliticaCancelacionEstricta());
        Reserva r4 = controlador.crearReserva("C-004", checkIn, 1500.0, new PoliticaCancelacionCorporativa());

        controlador.procesarCancelacion(r1.getIdReserva());
        controlador.procesarCancelacion(r2.getIdReserva());
        controlador.procesarCancelacion(r3.getIdReserva());
        controlador.procesarCancelacion(r4.getIdReserva());
    }
}
