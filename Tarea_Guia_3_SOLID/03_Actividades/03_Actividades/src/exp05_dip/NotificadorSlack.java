package exp05_dip;

public class NotificadorSlack implements ICanalNotificacion {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("[SLACK]   Canal " + destinatario + " | " + mensaje);
    }
}
