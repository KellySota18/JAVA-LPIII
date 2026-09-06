package exp05_dip;

import java.util.ArrayList;
import java.util.List;

/**
 * Doble de prueba: gracias al DIP se puede verificar NotificadorReserva
 * sin enviar nada al exterior.
 */
public class CanalPrueba implements ICanalNotificacion {

    private final List<String> enviados = new ArrayList<>();

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        enviados.add(destinatario + ": " + mensaje);
    }

    public List<String> getEnviados() { return enviados; }
}
