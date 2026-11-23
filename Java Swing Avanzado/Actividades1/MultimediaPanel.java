package practicaswing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class MultimediaPanel extends JPanel {
    private JLabel lblImagen;
    private JLabel lblArchivo;
    private JLabel lblEstado;
    private Clip clip;
    private long posicionPausa = 0;
    private boolean pausado = false;
    private BufferedImage imagenOriginal;
    private final Color AZUL = new Color(84, 121, 201);
    private final Color OSCURO = new Color(38, 50, 72);
    private final Color FONDO = new Color(242, 245, 250);
    public MultimediaPanel() {
        setLayout(new BorderLayout(15, 15));
        setBackground(FONDO);
        setBorder(new EmptyBorder(20, 25, 20, 25));
        inicializarComponentes();
    }
    private void inicializarComponentes() {
        JLabel titulo = new JLabel("APLICACIONES MULTIMEDIA");

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 21));
        titulo.setForeground(OSCURO);

        // =====================================
        // VISOR DE IMAGEN
        // =====================================

        JPanel panelImagen = new JPanel(new BorderLayout(10, 10));

        panelImagen.setBackground(Color.WHITE);

        panelImagen.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel tituloImagen = new JLabel(
                "Visor de imágenes",
                SwingConstants.CENTER);

        tituloImagen.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        lblImagen = new JLabel(
                "Seleccione una imagen",
                SwingConstants.CENTER);

        lblImagen.setOpaque(true);
        lblImagen.setBackground(new Color(245, 247, 250));

        lblImagen.setPreferredSize(new Dimension(350, 280));

        lblImagen.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                mostrarImagenEscalada();
            }
        });

        JButton btnImagen = crearBoton("Cargar imagen");

        btnImagen.addActionListener(e -> cargarImagen());

        panelImagen.add(tituloImagen, BorderLayout.NORTH);
        panelImagen.add(lblImagen, BorderLayout.CENTER);
        panelImagen.add(btnImagen, BorderLayout.SOUTH);

        // =====================================
        // REPRODUCTOR DE AUDIO
        // =====================================

        JPanel panelAudio = new JPanel();

        panelAudio.setLayout(
                new BoxLayout(panelAudio, BoxLayout.Y_AXIS));

        panelAudio.setBackground(Color.WHITE);

        panelAudio.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel tituloAudio = new JLabel("Reproductor de audio");

        tituloAudio.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        lblArchivo = new JLabel("Ningún archivo seleccionado");

        lblEstado = new JLabel("Estado: detenido");

        lblArchivo.setFont(
                new Font("Segoe UI", Font.PLAIN, 12));

        lblEstado.setFont(
                new Font("Segoe UI", Font.PLAIN, 12));

        JButton btnCargar = crearBoton("Cargar audio WAV");

        JButton btnReproducir = crearBoton("Reproducir");

        JButton btnPausar = crearBoton("Pausar");

        JButton btnDetener = crearBoton("Detener");

        btnCargar.addActionListener(e -> cargarAudio());

        btnReproducir.addActionListener(e -> reproducir());

        btnPausar.addActionListener(e -> pausar());

        btnDetener.addActionListener(e -> detener());

        panelAudio.add(tituloAudio);
        panelAudio.add(Box.createVerticalStrut(20));

        panelAudio.add(lblArchivo);
        panelAudio.add(Box.createVerticalStrut(12));

        panelAudio.add(lblEstado);
        panelAudio.add(Box.createVerticalStrut(25));

        panelAudio.add(btnCargar);
        panelAudio.add(Box.createVerticalStrut(12));

        panelAudio.add(btnReproducir);
        panelAudio.add(Box.createVerticalStrut(12));

        panelAudio.add(btnPausar);
        panelAudio.add(Box.createVerticalStrut(12));

        panelAudio.add(btnDetener);

        // =====================================
        // DISTRIBUCION
        // =====================================

        JPanel contenido = new JPanel(new GridLayout(1, 2, 15, 0));

        contenido.setOpaque(false);

        contenido.add(panelImagen);
        contenido.add(panelAudio);

        add(titulo, BorderLayout.NORTH);
        add(contenido, BorderLayout.CENTER);
    }

    // =====================================
    // CARGAR IMAGEN
    // =====================================

    private void cargarImagen() {

        JFileChooser selector = new JFileChooser();

        selector.setDialogTitle("Seleccionar imagen");

        selector.setFileFilter(
                new javax.swing.filechooser.FileNameExtensionFilter(
                        "Imágenes JPG, JPEG y PNG",
                        "jpg", "jpeg", "png"));

        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            try {

                BufferedImage imagen = ImageIO.read(archivo);

                if (imagen == null) {
                    throw new IOException(
                            "El archivo no es una imagen compatible.");
                }

                imagenOriginal = imagen;

                mostrarImagenEscalada();

            } catch (IOException ex) {

                mostrarError(
                        "No se pudo cargar la imagen: "
                        + ex.getMessage());
            }
        }
    }

    // =====================================
    // AJUSTAR IMAGEN
    // =====================================

    private void mostrarImagenEscalada() {

        if (imagenOriginal == null) {
            return;
        }

        int ancho = lblImagen.getWidth();
        int alto = lblImagen.getHeight();

        if (ancho <= 0 || alto <= 0) {
            return;
        }

        double escala = Math.min(
                (double) ancho / imagenOriginal.getWidth(),
                (double) alto / imagenOriginal.getHeight());

        int nuevoAncho = Math.max(
                1, (int) (imagenOriginal.getWidth() * escala));

        int nuevoAlto = Math.max(
                1, (int) (imagenOriginal.getHeight() * escala));

        Image imagenEscalada = imagenOriginal.getScaledInstance(
                nuevoAncho,
                nuevoAlto,
                Image.SCALE_SMOOTH);

        lblImagen.setText("");
        lblImagen.setIcon(new ImageIcon(imagenEscalada));
    }

    // =====================================
    // CARGAR AUDIO WAV
    // =====================================

    private void cargarAudio() {

        JFileChooser selector = new JFileChooser();

        selector.setDialogTitle("Seleccionar archivo WAV");

        selector.setFileFilter(
                new javax.swing.filechooser.FileNameExtensionFilter(
                        "Archivos de audio WAV",
                        "wav"));

        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            File archivo = selector.getSelectedFile();

            detener();

            try {

                cargarClip(archivo);

                lblArchivo.setText(
                        "Archivo: " + archivo.getName());

                lblEstado.setText("Estado: audio cargado");

            } catch (Exception ex) {

                detener();

                mostrarError(
                        "No se pudo cargar el audio: "
                        + ex.getMessage());
            }
        }
    }

    private void cargarClip(File archivo)
            throws UnsupportedAudioFileException,
                   IOException,
                   LineUnavailableException {

        try (AudioInputStream audio =
                     AudioSystem.getAudioInputStream(archivo)) {

            Clip nuevoClip = AudioSystem.getClip();

            try {
                nuevoClip.open(audio);
                clip = nuevoClip;

            } catch (LineUnavailableException | IOException ex) {

                nuevoClip.close();
                throw ex;
            }
        }
    }

    // REPRODUCIR

    private void reproducir() {

        if (clip == null) {

            mostrarError("Primero debe cargar un archivo WAV.");

            return;
        }

        if (pausado) {

            if (posicionPausa >= clip.getMicrosecondLength()) {
                posicionPausa = 0;
            }

            clip.setMicrosecondPosition(posicionPausa);

        } else if (!clip.isRunning()
                && clip.getMicrosecondPosition()
                >= clip.getMicrosecondLength()) {

            clip.setMicrosecondPosition(0);
        }

        clip.start();

        pausado = false;

        lblEstado.setText("Estado: reproduciendo");
    }

    // PAUSAR
    private void pausar() {
        if (clip != null && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();
            clip.stop();
            pausado = true;
            lblEstado.setText("Estado: pausado");
        }
    }

    // DETENER
    public void detener() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
        posicionPausa = 0;
        pausado = false;
        if (lblEstado != null) {
            lblEstado.setText("Estado: detenido");
        }
        if (lblArchivo != null && clip == null) {
            // Se conserva el nombre del último archivo cargado.
        }
    }
    
    // CREAR BOTON
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(AZUL);
        boton.setForeground(Color.WHITE);
        boton.setFont( new Font("Segoe UI", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(11, 15, 11, 15));
        boton.setAlignmentX(Component.LEFT_ALIGNMENT);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }
    // MOSTRAR ERROR
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error multimedia",
                JOptionPane.ERROR_MESSAGE);
    }
}