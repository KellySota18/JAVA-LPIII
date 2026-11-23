package Ejercicio3;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReproductor extends JFrame {

    // Objeto encargado de reproducir los sonidos
    private final ReproductorSonido reproductor;

    // Etiqueta para mostrar el estado
    private JLabel lblEstado;

    // Rutas de los archivos WAV
    private final String RUTA_APLAUSOS =
            "C:\\Users\\PC\\Downloads\\aplausos.wav";

    private final String RUTA_CAMPANA =
            "C:\\Users\\PC\\Downloads\\campana.wav";

    private final String RUTA_EXPLOSION =
            "C:\\Users\\PC\\Downloads\\explosion.wav";

    private final String RUTA_RISA =
            "C:\\Users\\PC\\Downloads\\risa.wav";

    private final String RUTA_TIMBRE =
            "C:\\Users\\PC\\Downloads\\timbre.wav";

    private final String RUTA_LLUVIA =
            "C:\\Users\\PC\\Downloads\\lluvia.wav";

    // Colores de la interfaz
    private final Color COLOR_FONDO =
            new Color(25, 29, 40);

    private final Color COLOR_PANEL =
            new Color(36, 42, 56);

    private final Color COLOR_BOTON =
            new Color(55, 90, 140);

    private final Color COLOR_BOTON_DETENER =
            new Color(180, 55, 65);

    private final Color COLOR_TEXTO =
            Color.WHITE;

    // Constructor
    public VentanaReproductor() {
        reproductor = new ReproductorSonido();
        configurarVentana();
        inicializarComponentes();
    }
    // Configuración principal de la ventana
    private void configurarVentana() {
        setTitle("REPRODUCTOR DE SONIDOS");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(COLOR_FONDO);

        setLayout(new BorderLayout(15, 15));
    }

    // Crear los componentes de la interfaz
    private void inicializarComponentes() {

        // Panel principal
        JPanel panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BorderLayout(15, 20));

        panelPrincipal.setBackground(COLOR_FONDO);

        panelPrincipal.setBorder(
                new EmptyBorder(25, 30, 25, 30)
        );

        // Título
        JLabel lblTitulo = new JLabel(
                "REPRODUCTOR DE SONIDOS",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        lblTitulo.setForeground(COLOR_TEXTO);

        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 2, 15, 15));
        panelBotones.setBackground(COLOR_PANEL);
        panelBotones.setBorder(new EmptyBorder(20, 20, 20, 20));
        // Botones de reproducción
        JButton btnAplausos = crearBoton("APLAUSOS", RUTA_APLAUSOS);
        JButton btnCampana = crearBoton("CAMPANA", RUTA_CAMPANA);
        JButton btnExplosion =crearBoton("EXPLOSION", RUTA_EXPLOSION);
        JButton btnRisa = crearBoton("RISA", RUTA_RISA);
        JButton btnTimbre = crearBoton("TIMBRE", RUTA_TIMBRE);
        JButton btnLluvia = crearBoton("LLUVIA", RUTA_LLUVIA);

        // Agregar botones al panel
        panelBotones.add(btnAplausos);
        panelBotones.add(btnCampana);
        panelBotones.add(btnExplosion);
        panelBotones.add(btnRisa);
        panelBotones.add(btnTimbre);
        panelBotones.add(btnLluvia);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout(10, 10));
        panelInferior.setBackground(COLOR_FONDO);

        // Estado de reproducción
        lblEstado = new JLabel("Estado: Esperando reproducción",SwingConstants.CENTER);
        lblEstado.setForeground(COLOR_TEXTO);
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 14) );
        // Botón detener
        JButton btnDetener = new JButton("DETENER");
        btnDetener.setFont( new Font("Arial", Font.BOLD, 14));

        btnDetener.setForeground(Color.WHITE);
        btnDetener.setBackground(COLOR_BOTON_DETENER);
        btnDetener.setFocusPainted(false);
        btnDetener.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnDetener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.detener();
                lblEstado.setText("Estado: Reproducción detenida");
            }
        });

        panelInferior.add(lblEstado, BorderLayout.CENTER);
        panelInferior.add(btnDetener, BorderLayout.SOUTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        add(panelPrincipal, BorderLayout.CENTER);
    }
    // Crear un botón para reproducir un sonido
    private JButton crearBoton(String nombre, String ruta) {
        JButton boton = new JButton(nombre);
        boton.setFont(new Font("Arial", Font.BOLD, 15));

        boton.setForeground(COLOR_TEXTO);

        boton.setBackground(COLOR_BOTON);

        boton.setFocusPainted(false);

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        // Evento del botón
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                reproducirEfecto(nombre, ruta);
            }
        });

        return boton;
    }

    // Método para reproducir el efecto seleccionado
    private void reproducirEfecto(String nombre, String ruta) {

        lblEstado.setText("Estado: Cargando " + nombre + "...");

        boolean resultado = reproductor.reproducir(ruta);

        if (resultado) {

            lblEstado.setText("Estado: Reproduciendo " + nombre);

        } else {

            lblEstado.setText("Estado: Error al reproducir " + nombre);

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo reproducir el sonido: " + nombre
                            + "\nComprueba que el archivo exista y sea compatible.",
                    "Error de reproducción",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

