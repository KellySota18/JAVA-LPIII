package practicaswing;
import javax.swing.*;
import java.awt.*;
public class GraficoLineas extends JPanel {
    private String[] nombres = {
        "Lunes", "Martes", "Miércoles", "Jueves",
        "Viernes", "Sábado", "Domingo"
    };
    private double[] valores = {
        18, 20, 22, 19, 24, 26, 23
    };
    private final Color AZUL = new Color(84, 121, 201);
    private final Color NARANJA = new Color(235, 145, 65);
    private final Color OSCURO = new Color(38, 50, 72);

    public GraficoLineas() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(750, 430));
    }

    public void actualizarDatos(
            String[] nombres, double[] valores) {

        if (nombres == null || valores == null
                || nombres.length < 2
                || nombres.length != valores.length) {

            throw new IllegalArgumentException(
                    "Se necesitan al menos dos datos.");
        }

        for (double valor : valores) {
            if (!Double.isFinite(valor)) {
                throw new IllegalArgumentException(
                        "Los valores deben ser numéricos.");
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
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth();
        int alto = getHeight();

        int izquierda = 70;
        int derecha = 35;
        int superior = 65;
        int inferior = 65;

        int anchoGrafico = ancho - izquierda - derecha;
        int altoGrafico = alto - superior - inferior;

        if (anchoGrafico <= 0 || altoGrafico <= 0) {
            g2.dispose();
            return;
        }

        // TITULO

        g2.setColor(OSCURO);
        g2.setFont(new Font("Segoe UI", Font.BOLD, 18));

        g2.drawString("Gráfico de líneas", 25, 30);

        // CALCULAR ESCALA

        double minimo = valores[0];
        double maximo = valores[0];

        for (double valor : valores) {
            minimo = Math.min(minimo, valor);
            maximo = Math.max(maximo, valor);
        }

        double margen = Math.max((maximo - minimo) * 0.2, 5);

        double limiteInferior = minimo - margen;
        double limiteSuperior = maximo + margen;

        double rango = limiteSuperior - limiteInferior;

        // GRILLA

        for (int i = 0; i <= 5; i++) {

            int y = superior + i * altoGrafico / 5;

            double valor = limiteSuperior - rango * i / 5;

            g2.setColor(new Color(225, 230, 238));

            g2.drawLine(
                    izquierda,
                    y,
                    ancho - derecha,
                    y);

            g2.setColor(OSCURO);
            g2.setFont(new Font("Segoe UI", Font.PLAIN, 10));

            g2.drawString(
                    String.format("%.1f", valor),
                    15,
                    y + 4);
        }

        // EJES

        g2.setColor(Color.GRAY);

        g2.drawLine(
                izquierda,
                superior,
                izquierda,
                superior + altoGrafico);

        g2.drawLine(
                izquierda,
                superior + altoGrafico,
                ancho - derecha,
                superior + altoGrafico);

        // COORDENADAS

        int cantidad = valores.length;

        int[] puntosX = new int[cantidad];
        int[] puntosY = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {

            puntosX[i] = izquierda
                    + i * anchoGrafico / (cantidad - 1);

            puntosY[i] = superior + (int) (
                    (limiteSuperior - valores[i])
                    / rango * altoGrafico);
        }

        // CONECTAR LOS PUNTOS

        g2.setColor(AZUL);
        g2.setStroke(new BasicStroke(
                3,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        for (int i = 0; i < cantidad - 1; i++) {

            g2.drawLine(
                    puntosX[i],
                    puntosY[i],
                    puntosX[i + 1],
                    puntosY[i + 1]);
        }

        // DIBUJAR PUNTOS Y ETIQUETAS

        for (int i = 0; i < cantidad; i++) {

            int x = puntosX[i];
            int y = puntosY[i];

            g2.setColor(Color.WHITE);
            g2.fillOval(x - 8, y - 8, 16, 16);

            g2.setColor(NARANJA);
            g2.fillOval(x - 5, y - 5, 10, 10);

            g2.setColor(OSCURO);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 11));

            String valor = String.format("%.1f", valores[i]);

            int anchoTexto = g2.getFontMetrics()
                    .stringWidth(valor);

            int textoY = y - 14;

            if (textoY < superior + 12) {
                textoY = y + 23;
            }

            g2.drawString(
                    valor,
                    x - anchoTexto / 2,
                    textoY);

            // NOMBRE DEL DIA

            g2.setFont(new Font("Segoe UI", Font.PLAIN, 10));

            int anchoNombre = g2.getFontMetrics()
                    .stringWidth(nombres[i]);

            g2.drawString(
                    nombres[i],
                    x - anchoNombre / 2,
                    superior + altoGrafico + 22);
        }

        g2.dispose();
    }
}
