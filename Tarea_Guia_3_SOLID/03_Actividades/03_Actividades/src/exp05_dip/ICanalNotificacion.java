package exp05_dip;

/**
 * Abstracción de la que dependen tanto el módulo de alto nivel
 * (NotificadorReserva) como los de bajo nivel (canales concretos).
 */
public interface ICanalNotificacion {
    void enviarNotificacion(String destinatario, String mensaje);
}
