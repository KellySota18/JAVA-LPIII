

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutFrame extends JFrame {

    // Nombre de la integrante
    private static final String INTEGRANTES = "Kelly Del Carpio Sota";

    private final JButton[] botones;

    public GridLayoutFrame() {

        super("GridLayout - " + INTEGRANTES);

        botones = new JButton[6];

        setLayout(new GridLayout(2, 3)); // 2 filas, 3 columnas

        for (int i = 0; i < botones.length; i++) {

            botones[i] = new JButton("Boton " + (i + 1));

            add(botones[i]);

        }
    }
}
