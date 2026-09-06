package Notificaciones;

public class EnviadorCorreo implements ICanalNotificacion {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("   [E-MAIL] " + destinatario + " | " + mensaje);
    }
}
