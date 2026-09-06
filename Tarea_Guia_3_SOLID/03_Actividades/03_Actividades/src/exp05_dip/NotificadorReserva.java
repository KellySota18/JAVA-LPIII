package exp05_dip;

/** Módulo de alto nivel: ya no crea su colaborador, lo recibe inyectado. */
public class NotificadorReserva {

    private final ICanalNotificacion canal;

    public NotificadorReserva(ICanalNotificacion canal) {
        this.canal = canal;
    }

    public void notificarConfirmacion(Reserva reserva) {
        canal.enviarNotificacion(reserva.getContactoCliente(),
                "Su reserva " + reserva.getIdReserva() + " ha sido confirmada.");
    }

    public void notificarCancelacion(Reserva reserva, double penalizacion) {
        canal.enviarNotificacion(reserva.getContactoCliente(),
                String.format("Reserva %s cancelada. Penalización: S/ %.2f",
                        reserva.getIdReserva(), penalizacion));
    }
}
