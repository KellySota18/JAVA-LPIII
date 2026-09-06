package Notificaciones;

/**
 * Abstracción de la que dependen tanto el módulo de alto nivel
 * (NotificadorReserva) como los canales concretos (Inversión de Dependencias).
 */
public interface ICanalNotificacion {

    void enviarNotificacion(String destinatario, String mensaje);
}
