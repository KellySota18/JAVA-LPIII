package practicaswing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class VentanaPrincipal extends JFrame {
    private BindingDatosPanel bindingDatosPanel;
    private GraficosPanel graficosPanel;
    private MultimediaPanel multimediaPanel;
    private final Color OSCURO = new Color(38, 50, 72);
    public VentanaPrincipal() {
        configurarVentana();
        inicializarComponentes();
    }
    private void configurarVentana() {
        setTitle("Práctica de Programación - Java Swing");
        setSize(1150, 780);
        setMinimumSize(new Dimension(900, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int opcion = JOptionPane.showConfirmDialog(
                        VentanaPrincipal.this,
                        "¿Desea salir de la aplicación?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (opcion == JOptionPane.YES_OPTION) {

                    multimediaPanel.detener();

                    dispose();

                    System.exit(0);
                }
            }
        });
    }

    private void inicializarComponentes() {
        // ENCABEZADO
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(OSCURO);
        encabezado.setBorder(new EmptyBorder(20, 25, 20, 25));
        JLabel titulo = new JLabel("APLICACIONES CON JAVA SWING");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        JLabel subtitulo = new JLabel("Binding de datos | Gráficos | Multimedia");
        subtitulo.setForeground(new Color(210, 220, 240));
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JPanel textos = new JPanel(new GridLayout(2, 1, 0, 6));
        textos.setOpaque(false);
        textos.add(titulo);
        textos.add(subtitulo);
        encabezado.add(textos, BorderLayout.CENTER);
        add(encabezado, BorderLayout.NORTH);

        // CREAR MODULOS
        bindingDatosPanel = new BindingDatosPanel();
        graficosPanel = new GraficosPanel();
        multimediaPanel = new MultimediaPanel();

        // PESTAÑAS
        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setFont(new Font("Segoe UI", Font.BOLD, 14));

        pestañas.addTab(
                "Binding de datos",
                bindingDatosPanel);

        pestañas.addTab(
                "Gráficos",
                graficosPanel);

        pestañas.addTab(
                "Multimedia",
                multimediaPanel);

        pestañas.setTabPlacement(
                JTabbedPane.TOP);

        pestañas.setFocusable(false);

        add(pestañas, BorderLayout.CENTER);

        // PIE DE PAGINA
        JPanel pie = new JPanel(new BorderLayout());
        pie.setBackground(Color.WHITE);
        pie.setBorder(new EmptyBorder(12, 15, 12, 15));
        JLabel textoPie = new JLabel("Práctica académica - Programación con Java Swing");
        textoPie.setHorizontalAlignment(SwingConstants.CENTER);
        textoPie.setFont( new Font("Segoe UI", Font.PLAIN, 12));
        textoPie.setForeground(OSCURO);
        pie.add(textoPie, BorderLayout.CENTER);
        add(pie, BorderLayout.SOUTH);
    }
}
