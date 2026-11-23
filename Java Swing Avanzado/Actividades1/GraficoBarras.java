package practicaswing;

import javax.swing.*;
import java.awt.*;

public class GraficoBarras extends JPanel {

    private String[] nombres = {
        "Java", "Python", "C++", "JavaScript", "SQL"
    };

    private double[] valores = {
        80, 65, 45, 90, 70
    };

    private final Color AZUL = new Color(84, 121, 201);
    private final Color OSCURO = new Color(38, 50, 72);

    public GraficoBarras() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(750, 430));
    }

    public void actualizarDatos(
            String[] nombres, double[] valores) {

        if (nombres == null || valores == null || nombres.length == 0 || nombres.length != valores.length) {

            throw new IllegalArgumentException( "Los datos del gráfico no son válidos.");
        }

        for (double valor : valores) {
            if (!Double.isFinite(valor) || valor < 0) {
                throw new IllegalArgumentException("Los valores deben ser positivos.");
            }
        }

        this.nombres = nombres.clone();
        this.valores = valores.clone();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        int margenIzquierdo = 65;
        int margenDerecho = 30;
        int margenSuperior = 65;
        int margenInferior = 65;

        int anchoGrafico = ancho - margenIzquierdo - margenDerecho;
        int altoGrafico = alto - margenSuperior - margenInferior;

        if (anchoGrafico <= 0 || altoGrafico <= 0) {
            g2.dispose();
            return;
        }

        // TITULO

        g2.setColor(OSCURO);
        g2.setFont(new Font("Segoe UI", Font.BOLD, 18));

        g2.drawString("Gráfico de barras", 25, 30);

        double maximo = 0;

        for (double valor : valores) {
            maximo = Math.max(maximo, valor);
        }

        double escala = maximo == 0 ? 1 : maximo * 1.2;

        int cantidad = valores.length;

        double espacio = (double) anchoGrafico / cantidad;

        int anchoBarra = (int) (espacio * 0.55);

        // EJES

        g2.setColor(Color.GRAY);

        g2.drawLine(margenIzquierdo,margenSuperior, margenIzquierdo, margenSuperior + altoGrafico);

        g2.drawLine(margenIzquierdo, margenSuperior + altoGrafico, ancho - margenDerecho,margenSuperior + altoGrafico);

        // LINEAS DE REFERENCIA

        for (int i = 0; i <= 5; i++) {

            int y = margenSuperior + i * altoGrafico / 5;

            g2.setColor(new Color(225, 230, 238));

            g2.drawLine(margenIzquierdo, y, ancho - margenDerecho, y);
        }

        // BARRAS

        for (int i = 0; i < cantidad; i++) {

            int x = margenIzquierdo + (int) (i * espacio) + (int) ((espacio - anchoBarra) / 2);

            int altura = (int) (valores[i] / escala * altoGrafico);

            int y = margenSuperior + altoGrafico - altura;

            g2.setColor(AZUL);

            g2.fillRoundRect(x, y,anchoBarra, altura,10,10);

            // VALOR

            g2.setColor(OSCURO);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 12));

            String valorTexto = String.format("%.1f", valores[i]);

            FontMetrics fm = g2.getFontMetrics();

            g2.drawString(
                    valorTexto,
                    x + (anchoBarra - fm.stringWidth(valorTexto)) / 2,
                    y - 8);

            // NOMBRE

            g2.setFont(new Font("Segoe UI", Font.PLAIN, 11));

            String nombre = nombres[i];

            int textoX = x + (anchoBarra - g2.getFontMetrics().stringWidth(nombre)) / 2;

            g2.drawString(nombre, textoX, margenSuperior + altoGrafico + 22);
        }

        g2.dispose();
    }
}

