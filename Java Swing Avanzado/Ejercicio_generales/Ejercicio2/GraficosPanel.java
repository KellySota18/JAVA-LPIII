package Ejercicio2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GraficosPanel extends JPanel {

    // Arreglo con los nombres de los días
    private final String[] dias = {
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo"
    };

    // Siete campos de texto
    private JTextField[] camposTemperatura;

    // Botón para mostrar el gráfico
    private JButton btnMostrarGrafico;

    // Panel personalizado para dibujar las líneas
    private GraficoLineas graficoLineas;

    // Etiqueta para mostrar mensajes
    private JLabel lblEstado;

    // Constructor
    public GraficosPanel() {

        configurarPanel();

        inicializarComponentes();

        configurarEventos();
    }

    // Configurar el panel principal
    private void configurarPanel() {

        setLayout(new BorderLayout(15, 15));

        setBackground(
            new Color(245, 247, 250)
        );

        setBorder(
            BorderFactory.createEmptyBorder(
                15, 20, 15, 20
            )
        );
    }

    // Crear todos los componentes
    private void inicializarComponentes() {

        // Panel superior
        JPanel panelSuperior = new JPanel(
            new BorderLayout(10, 10)
        );

        panelSuperior.setBackground(
            new Color(245, 247, 250)
        );

        // Título
        JLabel lblTitulo = new JLabel(
            "REGISTRO DE TEMPERATURAS SEMANALES",
            SwingConstants.CENTER
        );

        lblTitulo.setFont(
            new Font("Arial", Font.BOLD, 21)
        );

        lblTitulo.setForeground(
            new Color(35, 65, 100)
        );

        panelSuperior.add(
            lblTitulo,
            BorderLayout.NORTH
        );

        // Panel de los campos de temperatura
        JPanel panelFormulario = new JPanel(
            new GridLayout(2, 7, 8, 8)
        );

        panelFormulario.setBackground(Color.WHITE);

        panelFormulario.setBorder(
            BorderFactory.createTitledBorder(
                "Ingrese la temperatura de cada día (°C)"
            )
        );

        // Inicializar arreglo de campos
        camposTemperatura = new JTextField[7];

        // Crear los siete campos
        for (int i = 0; i < 7; i++) {

            JLabel lblDia = new JLabel(
                dias[i],
                SwingConstants.CENTER
            );

            lblDia.setFont(
                new Font("Arial", Font.BOLD, 12)
            );

            panelFormulario.add(lblDia);

            camposTemperatura[i] = new JTextField();

            camposTemperatura[i].setHorizontalAlignment(
                SwingConstants.CENTER
            );

            camposTemperatura[i].setFont(
                new Font("Arial", Font.PLAIN, 13)
            );

            camposTemperatura[i].setToolTipText(
                "Temperatura del día " + dias[i] + " en °C"
            );

            panelFormulario.add(
                camposTemperatura[i]
            );
        }

        panelSuperior.add(
            panelFormulario,
            BorderLayout.CENTER
        );

        // Botón para mostrar el gráfico
        btnMostrarGrafico = new JButton(
            "Mostrar Gráfico"
        );

        btnMostrarGrafico.setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        btnMostrarGrafico.setBackground(
            new Color(35, 110, 190)
        );

        btnMostrarGrafico.setForeground(
            Color.WHITE
        );

        btnMostrarGrafico.setFocusPainted(false);

        panelSuperior.add(btnMostrarGrafico,BorderLayout.SOUTH);

        add( panelSuperior, BorderLayout.NORTH);

        // Crear el gráfico
        graficoLineas = new GraficoLineas();

        add( graficoLineas, BorderLayout.CENTER );

        // Etiqueta de estado
        lblEstado = new JLabel( "Ingrese las temperaturas de lunes a domingo.", SwingConstants.CENTER);

        lblEstado.setFont( new Font("Arial", Font.PLAIN, 12) );

        lblEstado.setForeground(  new Color(70, 70, 70));

        add(lblEstado,BorderLayout.SOUTH );
    }

    // Configurar el evento del botón
    private void configurarEventos() {

        btnMostrarGrafico.addActionListener(
            e -> mostrarGrafico()
        );
    }

    // Leer, validar y enviar las temperaturas al gráfico
    private void mostrarGrafico() {

        // Arreglo que almacenará las siete temperaturas
        double[] temperaturas = new double[7];

        try {

            // Recorrer los siete campos
            for (int i = 0; i < 7; i++) {

                // Obtener el texto ingresado
                String texto = camposTemperatura[i]
                               .getText()
                               .trim();

                // Validar que no esté vacío
                if (texto.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Debe ingresar la temperatura del día "
                        + dias[i] + ".",
                        "Campo obligatorio",
                        JOptionPane.WARNING_MESSAGE
                    );

                    camposTemperatura[i].requestFocus();

                    return;
                }

                // Permitir coma o punto decimal
                texto = texto.replace(',', '.');

                // Convertir a número decimal
                double temperatura =
                    Double.parseDouble(texto);

                // Validar que sea un número finito
                if (!Double.isFinite(temperatura)) {

                    JOptionPane.showMessageDialog(
                        this,
                        "La temperatura de " + dias[i]
                        + " no es válida.",
                        "Error de temperatura",
                        JOptionPane.ERROR_MESSAGE
                    );

                    camposTemperatura[i].requestFocus();

                    return;
                }

                // Guardar en el arreglo
                temperaturas[i] = temperatura;
            }

            // Enviar las temperaturas al gráfico
            graficoLineas.actualizarDatos(
                temperaturas
            );

            // Actualizar mensaje de estado
            lblEstado.setText(
                "Gráfico actualizado correctamente. "
                + "Se muestran las temperaturas de los siete días."
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Ingrese únicamente valores numéricos válidos "
                + "en los campos de temperatura.",
                "Error de datos",
                JOptionPane.ERROR_MESSAGE
            );

        }
    }
}
