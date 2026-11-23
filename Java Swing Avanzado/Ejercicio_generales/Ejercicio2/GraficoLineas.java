package Ejercicio2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
public class GraficoLineas extends JPanel {
    // Días de la semana
    private final String[] dias = {
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo"
    };
    // Arreglo que almacena las temperaturas
    private double[] temperaturas;
    // Indica si existen datos para mostrar
    private boolean datosDisponibles;
    // Constructor
    public GraficoLineas() {
        temperaturas = new double[7];
        datosDisponibles = false;

        setBackground(Color.WHITE);

        setBorder(
            BorderFactory.createLineBorder(
                new Color(210, 215, 220)
            )
        );
    }

    // Recibir las temperaturas desde la interfaz
    public void actualizarDatos(double[] nuevasTemperaturas) {

        if (nuevasTemperaturas == null
                || nuevasTemperaturas.length != 7) {

            throw new IllegalArgumentException(
                "Se necesitan exactamente siete temperaturas."
            );
        }

        // Copiar las temperaturas recibidas
        temperaturas = nuevasTemperaturas.clone();

        datosDisponibles = true;

        // Solicitar que Swing vuelva a dibujar el panel
        repaint();
    }

    // Dibujar el gráfico
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        try {

            // Mejorar la calidad del dibujo
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            int ancho = getWidth();
            int alto = getHeight();

            // Título del gráfico
            g2.setColor(new Color(35, 65, 100));

            g2.setFont(
                new Font("Arial", Font.BOLD, 19)
            );

            String titulo = "TEMPERATURA SEMANAL";

            int anchoTitulo = g2.getFontMetrics()
                                 .stringWidth(titulo);

            g2.drawString(
                titulo,
                (ancho - anchoTitulo) / 2,
                35
            );

            // Verificar si existen temperaturas
            if (!datosDisponibles) {

                g2.setColor(Color.GRAY);

                g2.setFont(
                    new Font("Arial", Font.PLAIN, 14)
                );

                String mensaje =
                    "Ingrese las siete temperaturas y presione Mostrar Grafico";

                int anchoMensaje = g2.getFontMetrics()
                                     .stringWidth(mensaje);

                g2.drawString(
                    mensaje,
                    (ancho - anchoMensaje) / 2,
                    alto / 2
                );

                return;
            }

            dibujarGrafico(g2, ancho, alto);

        } finally {

            g2.dispose();
        }
    }

    // Método encargado de dibujar todos los elementos del gráfico
    private void dibujarGrafico(Graphics2D g2,
                                int ancho,
                                int alto) {

        // Márgenes del gráfico
        int margenIzquierdo = 75;
        int margenDerecho = 35;
        int margenSuperior = 75;
        int margenInferior = 75;

        int anchoGrafico =
            ancho - margenIzquierdo - margenDerecho;

        int altoGrafico =
            alto - margenSuperior - margenInferior;

        // Evitar dibujar si el panel es demasiado pequeño
        if (anchoGrafico <= 0 || altoGrafico <= 0) {
            return;
        }

        // Obtener temperatura mínima y máxima
        double minimo = temperaturas[0];
        double maximo = temperaturas[0];

        for (double temperatura : temperaturas) {

            if (temperatura < minimo) {
                minimo = temperatura;
            }

            if (temperatura > maximo) {
                maximo = temperatura;
            }
        }

        // Calcular el rango vertical
        double rango = maximo - minimo;

        // Agregar margen cuando todas las temperaturas son iguales
        if (rango == 0) {
            rango = Math.max(2.0, Math.abs(maximo) * 0.2);
        }

        double margen = rango * 0.20;

        double limiteInferior = minimo - margen;
        double limiteSuperior = maximo + margen;

        double rangoVertical =
            limiteSuperior - limiteInferior;

        // Dibujar líneas horizontales de referencia
        g2.setColor(new Color(225, 230, 235));

        g2.setStroke(
            new BasicStroke(1)
        );

        int divisiones = 5;

        for (int i = 0; i <= divisiones; i++) {

            int y = margenSuperior
                    + (altoGrafico * i / divisiones);

            g2.drawLine(
                margenIzquierdo,
                y,
                margenIzquierdo + anchoGrafico,
                y
            );

            // Mostrar valores del eje vertical
            double valor =
                limiteSuperior
                - (rangoVertical * i / divisiones);

            String texto = String.format(
                java.util.Locale.US,
                "%.1f",
                valor
            );

            g2.setColor(new Color(80, 80, 80));

            g2.setFont(
                new Font("Arial", Font.PLAIN, 11)
            );

            int anchoTexto = g2.getFontMetrics()
                               .stringWidth(texto);

            g2.drawString(
                texto,
                margenIzquierdo - anchoTexto - 10,
                y + 4
            );

            g2.setColor(new Color(225, 230, 235));
        }

        // Dibujar los ejes
        g2.setColor(Color.BLACK);

        g2.setStroke(
            new BasicStroke(2)
        );

        // Eje vertical
        g2.drawLine(
            margenIzquierdo,
            margenSuperior,
            margenIzquierdo,
            margenSuperior + altoGrafico
        );

        // Eje horizontal
        g2.drawLine(
            margenIzquierdo,
            margenSuperior + altoGrafico,
            margenIzquierdo + anchoGrafico,
            margenSuperior + altoGrafico
        );

        // Dibujar etiquetas de los días
        g2.setFont(
            new Font("Arial", Font.PLAIN, 11)
        );

        int[] posicionesX = new int[7];
        int[] posicionesY = new int[7];

        for (int i = 0; i < 7; i++) {

            int x = margenIzquierdo
                    + (i * anchoGrafico / 6);

            double proporcion =
                (limiteSuperior - temperaturas[i])
                / rangoVertical;

            int y = margenSuperior
                    + (int) (proporcion * altoGrafico);

            posicionesX[i] = x;
            posicionesY[i] = y;

            // Nombre del día
            g2.setColor(new Color(50, 50, 50));
            String dia = dias[i];
            int anchoDia = g2.getFontMetrics() .stringWidth(dia);
            g2.drawString( dia, x - anchoDia / 2, margenSuperior + altoGrafico + 25);
        }
        // Dibujar las líneas que conectan los puntos
        g2.setColor(new Color(35, 110, 190));

        g2.setStroke(
            new BasicStroke(
                3,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND
            )
        );

        for (int i = 0; i < 6; i++) {

            g2.drawLine(
                posicionesX[i],
                posicionesY[i],
                posicionesX[i + 1],
                posicionesY[i + 1]
            );
        }

        // Dibujar los puntos y sus temperaturas
        for (int i = 0; i < 7; i++) {

            int x = posicionesX[i];
            int y = posicionesY[i];

            // Punto del gráfico
            g2.setColor(new Color(220, 70, 60));

            g2.fillOval(
                x - 6,
                y - 6,
                12,
                12
            );

            // Borde blanco del punto
            g2.setColor(Color.WHITE);

            g2.drawOval(
                x - 6,
                y - 6,
                12,
                12
            );

            // Valor de la temperatura
            g2.setColor(new Color(35, 65, 100));
            g2.setFont(new Font("Arial", Font.BOLD, 12) );

            String texto = String.format(
                java.util.Locale.US,
                "%.1f °C",
                temperaturas[i]
            );

            int anchoTexto = g2.getFontMetrics()
                               .stringWidth(texto);

            g2.drawString(
                texto,
                x - anchoTexto / 2,
                y - 12
            );
        }

        // Título del eje vertical
        g2.setFont(
            new Font("Arial", Font.BOLD, 12)
        );

        g2.setColor(Color.BLACK);

        g2.drawString(
            "Temperatura (°C)",
            10,
            margenSuperior - 15
        );
    }
}
