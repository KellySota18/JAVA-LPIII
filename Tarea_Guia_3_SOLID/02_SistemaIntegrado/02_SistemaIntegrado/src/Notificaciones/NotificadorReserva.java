package Notificaciones;

/**
 * Módulo de alto nivel: recibe el canal por constructor en lugar de crearlo.
 * Cambiar de correo a SMS no obliga a tocar esta clase.
 */
public class NotificadorReserva {

    private final ICanalNotificacion canal;

    public NotificadorReserva(ICanalNotificacion canal) {
        this.canal = canal;
    }

    public void notificarConfirmacion(String destinatario, String idReserva) {
        canal.enviarNotificacion(destinatario,
                "Su reserva " + idReserva + " ha sido confirmada.");
    }

    public void notificarCancelacion(String destinatario, String idReserva, double penalizacion) {
        canal.enviarNotificacion(destinatario,
                String.format("Reserva %s cancelada. Penalización: S/ %.2f", idReserva, penalizacion));
    }
}
