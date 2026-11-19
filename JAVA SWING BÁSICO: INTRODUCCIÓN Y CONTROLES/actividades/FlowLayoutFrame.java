import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FlowLayoutFrame extends JFrame {

    // TODO: reemplazar por los nombres reales de los integrantes del grupo
    private static final String INTEGRANTES = "Kelly Del Carpio Sota";

    public FlowLayoutFrame() {
        super("FlowLayout - " + INTEGRANTES);
        setLayout(new FlowLayout()); // establece el esquema del marco

        add(new JLabel("Componente 1"));
        add(new JButton("Componente 2"));
        add(new JLabel("Componente 3"));
        add(new JButton("Componente 4"));
        add(new JLabel("Componente 5"));
        add(new JButton("Componente 6"));
    }
}
