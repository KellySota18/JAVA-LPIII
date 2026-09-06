package exp05_dip;

/** Demostración de la Experiencia 5 (DIP). */
public class MainDIP {

    public static void main(String[] args) {
        System.out.println("===== EXPERIENCIA 5: DIP =====");

        ControladorReservas controlador = new ControladorReservas();
        Reserva reserva = new Reserva("R-1024", "henrik@correo.com");

        controlador.confirmarReserva(reserva, new EnviadorCorreo());
        controlador.confirmarReserva(new Reserva("R-1025", "959123456"), new EnviadorSMS());
        controlador.confirmarReserva(new Reserva("R-1026", "#reservas"), new NotificadorSlack());

        controlador.cancelarReserva(reserva, 240.0, new EnviadorCorreo());

        // Prueba sin infraestructura real
        CanalPrueba canalPrueba = new CanalPrueba();
        new NotificadorReserva(canalPrueba).notificarConfirmacion(reserva);
        System.out.println("Mensajes capturados en la prueba: " + canalPrueba.getEnviados());
    }
}
