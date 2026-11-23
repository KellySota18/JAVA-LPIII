package Ejercicio3;
import javax.swing.SwingUtilities;

public class MainEjercicio3 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaReproductor ventana = new VentanaReproductor();

            ventana.setVisible(true);

        });
    }
}
