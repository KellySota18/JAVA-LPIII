package Ejercicio4;

import javax.swing.*;
import java.awt.*;

public class VentanaReproductor extends JFrame {

    private ReproductorAudio reproductor;
    private JLabel lblEstado;

    // Ruta del archivo de música
    private static final String RUTA_MUSICA =
            "C:\\Users\\PC\\Downloads\\musica.wav";

    public VentanaReproductor() {

        reproductor = new ReproductorAudio();

        // Configuración de la ventana
        setTitle("Reproductor de Música");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Colores
        Color fondo = new Color(29, 39, 40);
        Color panelColor = new Color(36, 42, 56);
        Color colorReproducir = new Color(45, 130, 85);
        Color colorPausar = new Color(190, 135, 40);
        Color colorReanudar = new Color(55, 100, 160);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(15, 15));
        panelPrincipal.setBackground(fondo);
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(30, 25, 30, 25)
        );

        // Título
        JLabel lblTitulo = new JLabel(
                "REPRODUCTOR DE MÚSICA",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);

        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(10, 10));
        panelCentral.setBackground(panelColor);
        panelCentral.setBorder(
                BorderFactory.createEmptyBorder(25, 15, 25, 15)
        );

        // Icono de música
        JLabel lblIcono = new JLabel(
                "\u266B",
                SwingConstants.CENTER
        );

        lblIcono.setFont(new Font("Arial", Font.PLAIN, 65));
        lblIcono.setForeground(Color.WHITE);

        panelCentral.add(lblIcono, BorderLayout.CENTER);

        // Estado de reproducción
        lblEstado = new JLabel(
                "Estado: Detenido",
                SwingConstants.CENTER
        );

        lblEstado.setFont(new Font("Arial", Font.PLAIN, 15));
        lblEstado.setForeground(Color.WHITE);

        panelCentral.add(lblEstado, BorderLayout.SOUTH);

        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 12, 0));
        panelBotones.setBackground(fondo);

        // Botón Reproducir
        JButton btnReproducir = new JButton("Reproducir");
        btnReproducir.setBackground(colorReproducir);
        btnReproducir.setForeground(Color.WHITE);
        btnReproducir.setFocusPainted(false);

        // Botón Pausar
        JButton btnPausar = new JButton("Pausar");
        btnPausar.setBackground(colorPausar);
        btnPausar.setForeground(Color.WHITE);
        btnPausar.setFocusPainted(false);

        // Botón Reanudar
        JButton btnReanudar = new JButton("Reanudar");
        btnReanudar.setBackground(colorReanudar);
        btnReanudar.setForeground(Color.WHITE);
        btnReanudar.setFocusPainted(false);

        // Evento del botón Reproducir
        btnReproducir.addActionListener(e -> {

            reproductor.reproducir(RUTA_MUSICA);

            if (reproductor.estaReproduciendo()) {
                lblEstado.setText("Estado: Reproduciendo música");
            } else {
                lblEstado.setText("Estado: No se pudo reproducir");
            }
        });

        // Evento del botón Pausar
        btnPausar.addActionListener(e -> {

            if (reproductor.estaReproduciendo()) {

                reproductor.pausar();

                lblEstado.setText("Estado: Música pausada");

            } else {
                lblEstado.setText(
                        "Estado: No hay música reproduciéndose"
                );
            }
        });

        // Evento del botón Reanudar
        btnReanudar.addActionListener(e -> {

            if (reproductor.estaPausado()) {

                reproductor.reanudar();

                if (reproductor.estaReproduciendo()) {
                    lblEstado.setText("Estado: Música reanudada");
                }

            } else {
                lblEstado.setText(
                        "Estado: No hay música pausada"
                );
            }
        });

        // Agregar botones
        panelBotones.add(btnReproducir);
        panelBotones.add(btnPausar);
        panelBotones.add(btnReanudar);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Agregar panel principal a la ventana
        add(panelPrincipal);
    }
}

