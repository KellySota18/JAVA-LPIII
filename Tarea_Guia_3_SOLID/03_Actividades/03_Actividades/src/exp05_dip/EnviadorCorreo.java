package exp05_dip;

public class EnviadorCorreo implements ICanalNotificacion {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("[E-MAIL]  Para: " + destinatario + " | " + mensaje);
    }
}
