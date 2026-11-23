package Ejercicio4;
import javax.swing.SwingUtilities;

public class MainEjercicio4 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                VentanaReproductor ventana =
                        new VentanaReproductor();

                ventana.setVisible(true);
            }
        });
    }
}
