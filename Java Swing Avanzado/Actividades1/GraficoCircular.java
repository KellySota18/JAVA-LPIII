package practicaswing;
import javax.swing.*;
import java.awt.*;
public class GraficoCircular extends JPanel {

    private String[] nombres = {
        "Java", "Python", "SQL", "Otros"
    };

    private double[] valores = {
        40, 30, 20, 10
    };

    private final Color[] colores = {
        new Color(84, 121, 201),
        new Color(65, 170, 130),
        new Color(231, 145, 65),
        new Color(160, 115, 190)
    };

    private final Color OSCURO = new Color(38, 50, 72);

    public GraficoCircular() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(750, 430));
    }

    public void actualizarDatos(
            String[] nombres, double[] valores) {

        if (nombres == null || valores == null
                || nombres.length == 0
                || nombres.length != valores.length) {

            throw new IllegalArgumentException(
                    "Los datos no son válidos.");
        }

        double suma = 0;

        for (double valor : valores) {

            if (!Double.isFinite(valor) || valor < 0) {
                throw new IllegalArgumentException(
                        "Los valores deben ser positivos.");
            }

            suma += valor;
        }

        if (suma <= 0) {
            throw new IllegalArgumentException(
                    "La suma debe ser mayor que cero.");
        }

        this.nombres = nombres.clone();
        this.valores = valores.clone();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        g2.setColor(OSCURO);
        g2.setFont(new Font("Segoe UI", Font.BOLD, 18));

        g2.drawString("Gráfico circular", 25, 30);

        double suma = 0;

        for (double valor : valores) {
            suma += valor;
        }

        if (suma <= 0) {
            g2.dispose();
            return;
        }

        int diametro = Math.max(
                100,
                Math.min(280, Math.min(ancho / 2, alto - 100)));

        int x = 35;
        int y = (alto - diametro) / 2;

        double inicio = 90;

        // DIBUJAR SECTORES

        for (int i = 0; i < valores.length; i++) {

            double angulo = valores[i] * 360.0 / suma;

            g2.setColor(colores[i % colores.length]);

            g2.fillArc(
                    x,
                    y,
                    diametro,
                    diametro,
                    (int) Math.round(inicio),
                    (int) Math.round(angulo));

            inicio += angulo;
        }

        // LEYENDA

        int leyendaX = x + diametro + 35;
        int leyendaY = y + 25;

        for (int i = 0; i < nombres.length; i++) {

            int posicionY = leyendaY + i * 35;

            g2.setColor(colores[i % colores.length]);

            g2.fillRoundRect(
                    leyendaX,
                    posicionY,
                    17,
                    17,
                    5,
                    5);

            double porcentaje = valores[i] * 100.0 / suma;

            g2.setColor(OSCURO);

            g2.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            g2.drawString(
                    String.format(
                            "%s - %.1f%%",
                            nombres[i],
                            porcentaje),
                    leyendaX + 27,
                    posicionY + 14);
        }

        g2.dispose();
    }
}
