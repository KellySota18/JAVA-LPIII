import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutFrame extends JFrame {

    // TODO: reemplazar por los nombres reales de los integrantes del grupo
    private static final String INTEGRANTES = "Kelly Del Carpio Sota";

    public BorderLayoutFrame() {
        super("BorderLayout - " + INTEGRANTES);
        setLayout(new BorderLayout());

        add(new JButton("NORTH"), BorderLayout.NORTH);
        add(new JButton("SOUTH"), BorderLayout.SOUTH);
        add(new JButton("EAST"), BorderLayout.EAST);
        add(new JButton("WEST"), BorderLayout.WEST);
        add(new JButton("CENTER"), BorderLayout.CENTER);
    }
}

