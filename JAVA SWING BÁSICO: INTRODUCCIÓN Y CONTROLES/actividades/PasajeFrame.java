import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class PasajeFrame extends JFrame {

    // TODO: reemplazar por los nombres reales de los integrantes del grupo
    private static final String INTEGRANTES = "Kelly Del Carpio Sota";

    // Campos de texto
    private final JTextField campoNombre;
    private final JTextField campoDocumento;
    private final JTextField campoFecha;

    // Cuadros combinados
    private final JComboBox<String> comboOrigen;
    private final JComboBox<String> comboDestino;

    // Botones de opción (piso)
    private final JRadioButton radioPrimerPiso;
    private final JRadioButton radioSegundoPiso;
    private final ButtonGroup grupoPiso;

    // Casillas de verificación (servicios opcionales)
    private final JCheckBox checkAudifonos;
    private final JCheckBox checkManta;
    private final JCheckBox checkRevistas;

    // Lista (calidad de servicio)
    private final JList<String> listaCalidad;

    // Botones de comando
    private final JButton botonComprar;
    private final JButton botonLimpiar;

    private static final String[] CIUDADES = {"Arequipa", "Lima", "Cusco", "Puno", "Tacna"};
    private static final String[] CALIDADES = {"Economico", "Standard", "VIP"};

    public PasajeFrame() {
        super("Compra de Pasajes - " + INTEGRANTES);
        setLayout(new BorderLayout());

        // ---------- Panel central: datos del pasajero ----------
        JPanel panelDatos = new JPanel(new GridLayout(0, 2, 8, 8));

        panelDatos.add(new JLabel("Nombre completo:"));
        campoNombre = new JTextField(15);
        panelDatos.add(campoNombre);

        panelDatos.add(new JLabel("Documento de identidad:"));
        campoDocumento = new JTextField(15);
        panelDatos.add(campoDocumento);

        panelDatos.add(new JLabel("Fecha de viaje (dd/mm/aaaa):"));
        campoFecha = new JTextField(15);
        panelDatos.add(campoFecha);

        panelDatos.add(new JLabel("Origen:"));
        comboOrigen = new JComboBox<>(CIUDADES);
        panelDatos.add(comboOrigen);

        panelDatos.add(new JLabel("Destino:"));
        comboDestino = new JComboBox<>(CIUDADES);
        comboDestino.setSelectedIndex(1);
        panelDatos.add(comboDestino);

        panelDatos.add(new JLabel("Piso del bus:"));
        JPanel panelPiso = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        radioPrimerPiso = new JRadioButton("1er piso", true);
        radioSegundoPiso = new JRadioButton("2do piso");
        grupoPiso = new ButtonGroup();
        grupoPiso.add(radioPrimerPiso);
        grupoPiso.add(radioSegundoPiso);
        panelPiso.add(radioPrimerPiso);
        panelPiso.add(radioSegundoPiso);
        panelDatos.add(panelPiso);

        panelDatos.add(new JLabel("Servicios opcionales:"));
        JPanel panelServicios = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        checkAudifonos = new JCheckBox("Audifonos");
        checkManta = new JCheckBox("Manta");
        checkRevistas = new JCheckBox("Revistas");
        panelServicios.add(checkAudifonos);
        panelServicios.add(checkManta);
        panelServicios.add(checkRevistas);
        panelDatos.add(panelServicios);

        panelDatos.add(new JLabel("Calidad de servicio:"));
        listaCalidad = new JList<>(CALIDADES);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCalidad.setSelectedIndex(0);
        panelDatos.add(new JScrollPane(listaCalidad));

        add(panelDatos, BorderLayout.CENTER);

        // ---------- Panel inferior: botones de comando ----------
        JPanel panelBotones = new JPanel(new FlowLayout());
        botonComprar = new JButton("Comprar pasaje");
        botonLimpiar = new JButton("Limpiar");
        panelBotones.add(botonComprar);
        panelBotones.add(botonLimpiar);
        add(panelBotones, BorderLayout.SOUTH);

        // ---------- Manejo de eventos ----------
        ManejadorBotones manejador = new ManejadorBotones();
        botonComprar.addActionListener(manejador);
        botonLimpiar.addActionListener(manejador);
    }

    // Clase interna privada para el manejo de los eventos de los botones
    private class ManejadorBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == botonComprar) {
                mostrarResumen();
            } else if (evento.getSource() == botonLimpiar) {
                limpiarFormulario();
            }
        }

        // Valida los datos obligatorios y muestra el resumen de la compra
        private void mostrarResumen() {
            String nombre = campoNombre.getText().trim();
            String documento = campoDocumento.getText().trim();
            String fecha = campoFecha.getText().trim();

            if (nombre.isEmpty() || documento.isEmpty() || fecha.isEmpty()) {
                JOptionPane.showMessageDialog(PasajeFrame.this,
                        "Por favor complete nombre, documento y fecha de viaje.",
                        "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String piso = radioPrimerPiso.isSelected() ? "1er piso" : "2do piso";

            StringBuilder servicios = new StringBuilder();
            if (checkAudifonos.isSelected()) servicios.append("Audifonos ");
            if (checkManta.isSelected()) servicios.append("Manta ");
            if (checkRevistas.isSelected()) servicios.append("Revistas ");
            if (servicios.length() == 0) servicios.append("Ninguno");

            String calidad = listaCalidad.getSelectedValue();
            if (calidad == null) calidad = "No seleccionada";

            String resumen = String.format(
                    "RESUMEN DE COMPRA%n%n" +
                    "Pasajero: %s%n" +
                    "Documento: %s%n" +
                    "Fecha de viaje: %s%n" +
                    "Origen: %s%n" +
                    "Destino: %s%n" +
                    "Piso: %s%n" +
                    "Servicios opcionales: %s%n" +
                    "Calidad de servicio: %s",
                    nombre, documento, fecha,
                    comboOrigen.getSelectedItem(), comboDestino.getSelectedItem(),
                    piso, servicios.toString().trim(), calidad);

            JOptionPane.showMessageDialog(PasajeFrame.this, resumen,
                    "Pasaje confirmado", JOptionPane.INFORMATION_MESSAGE);
        }

        // Reinicia todos los componentes del formulario a su estado inicial
        private void limpiarFormulario() {
            campoNombre.setText("");
            campoDocumento.setText("");
            campoFecha.setText("");
            comboOrigen.setSelectedIndex(0);
            comboDestino.setSelectedIndex(1);
            radioPrimerPiso.setSelected(true);
            checkAudifonos.setSelected(false);
            checkManta.setSelected(false);
            checkRevistas.setSelected(false);
            listaCalidad.setSelectedIndex(0);
        }
    }
}
