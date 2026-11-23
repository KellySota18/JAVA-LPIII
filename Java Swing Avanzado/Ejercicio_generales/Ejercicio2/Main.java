package Ejercicio2;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        // Ejecutar la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            try {
                // Utilizar el estilo visual del sistema operativo
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            } catch (Exception e) {
                System.err.println("No se pudo establecer el estilo visual.");
            }

            // Crear la ventana principal
            JFrame ventana = new JFrame(
                "Registro de Temperaturas Semanales"
            );

            // Agregar el panel de temperaturas
            ventana.setContentPane(new GraficosPanel());

            // Configurar dimensiones
            ventana.setSize(1050, 650);

            // Centrar la ventana
            ventana.setLocationRelativeTo(null);

            // Cerrar la aplicación al salir
            ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
            );

            // Mostrar la ventana
            ventana.setVisible(true);
        });
    }
}

