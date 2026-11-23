package practicaswing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GraficosPanel extends JPanel {

    private GraficoBarras graficoBarras;
    private GraficoLineas graficoLineas;
    private GraficoCircular graficoCircular;

    public GraficosPanel() {

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(242, 245, 250));

        setBorder(new EmptyBorder(20, 25, 20, 25));

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JLabel titulo = new JLabel("GRÁFICOS SIMPLES Y AVANZADOS");

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 21));
        titulo.setForeground(new Color(38, 50, 72));

        JTabbedPane pestañas = new JTabbedPane();

        pestañas.setFont(
                new Font("Segoe UI", Font.BOLD, 13));

        // CREAR GRAFICOS
        graficoBarras = new GraficoBarras();
        graficoLineas = new GraficoLineas();
        graficoCircular = new GraficoCircular();
        
        // GRAFICO DE BARRAS
        JPanel panelBarras = new JPanel(new BorderLayout());
        panelBarras.setBackground(Color.WHITE);
        panelBarras.add(graficoBarras, BorderLayout.CENTER);
        JButton btnActualizarBarras = new JButton("Actualizar datos");
        btnActualizarBarras.addActionListener(e -> {
            String[] nombres = {
                "Java", "Python", "C++", "JavaScript", "SQL"
            };
            double[] valores = {
                85, 72, 50, 95, 65
            };

            graficoBarras.actualizarDatos(nombres, valores);
        });

        JPanel controlBarras = crearPanelControl();
        controlBarras.add(btnActualizarBarras);
        panelBarras.add(controlBarras, BorderLayout.SOUTH);
        // GRAFICO DE LINEAS
        JPanel panelLineas = new JPanel(new BorderLayout());

        panelLineas.setBackground(Color.WHITE);
        panelLineas.add(graficoLineas, BorderLayout.CENTER);
        JButton btnActualizarLineas = new JButton("Actualizar datos");

        btnActualizarLineas.addActionListener(e -> {
            String[] nombres = {
                "Lunes", "Martes", "Miércoles", "Jueves",
                "Viernes", "Sábado", "Domingo"
            };
            double[] valores = {
                19, 21, 24, 22, 26, 28, 25
            };
            graficoLineas.actualizarDatos(nombres, valores);
        });
        JPanel controlLineas = crearPanelControl();
        controlLineas.add(btnActualizarLineas);
        panelLineas.add(controlLineas, BorderLayout.SOUTH);
        // GRAFICO CIRCULAR
        JPanel panelCircular = new JPanel(new BorderLayout());

        panelCircular.setBackground(Color.WHITE);

        panelCircular.add(graficoCircular, BorderLayout.CENTER);

        JButton btnActualizarCircular =
                new JButton("Actualizar datos");

        btnActualizarCircular.addActionListener(e -> {

            String[] nombres = {
                "Java", "Python", "SQL", "Otros"
            };

            double[] valores = {
                35, 30, 25, 10
            };

            graficoCircular.actualizarDatos(nombres, valores);
        });

        JPanel controlCircular = crearPanelControl();

        controlCircular.add(btnActualizarCircular);

        panelCircular.add(controlCircular, BorderLayout.SOUTH);

        // AGREGAR PESTAÑAS
        pestañas.addTab("Gráfico de barras", panelBarras);
        pestañas.addTab("Gráfico de líneas", panelLineas);
        pestañas.addTab("Gráfico circular", panelCircular);
        add(titulo, BorderLayout.NORTH);
        add(pestañas, BorderLayout.CENTER);
    }

    private JPanel crearPanelControl() {

        JPanel panel = new JPanel(
                new FlowLayout(FlowLayout.RIGHT));

        panel.setBackground(Color.WHITE);

        return panel;
    }
}
