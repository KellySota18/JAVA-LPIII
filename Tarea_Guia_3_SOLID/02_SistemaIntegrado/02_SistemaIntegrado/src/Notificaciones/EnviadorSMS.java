package Notificaciones;

public class EnviadorSMS implements ICanalNotificacion {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("   [SMS] " + destinatario + " | " + mensaje);
    }
}
