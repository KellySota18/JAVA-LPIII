package exp05_dip;

public class ControladorReservas {

    public void confirmarReserva(Reserva reserva, ICanalNotificacion canal) {
        new NotificadorReserva(canal).notificarConfirmacion(reserva);
    }

    public void cancelarReserva(Reserva reserva, double penalizacion, ICanalNotificacion canal) {
        new NotificadorReserva(canal).notificarCancelacion(reserva, penalizacion);
    }
}
