package practicaswing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BindingDatosPanel extends JPanel {

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtCategoria;

    private JLabel lblResultado;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private final List<Producto> productos = new ArrayList<>();

    private int indiceSeleccionado = -1;

    private final Color AZUL = new Color(84, 121, 201);
    private final Color OSCURO = new Color(38, 50, 72);

    public BindingDatosPanel() {

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(242, 245, 250));
        setBorder(new EmptyBorder(20, 25, 20, 25));

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JLabel titulo = new JLabel("BINDING MANUAL DE DATOS");

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 21));
        titulo.setForeground(OSCURO);

        // FORMULARIO

        JPanel formulario = new JPanel(new GridLayout(4, 2, 12, 12));

        formulario.setBackground(Color.WHITE);

        formulario.setBorder(new EmptyBorder(20, 20, 20, 20));

        txtNombre = crearCampo();
        txtPrecio = crearCampo();
        txtCantidad = crearCampo();
        txtCategoria = crearCampo();

        formulario.add(crearEtiqueta("Nombre del producto:"));
        formulario.add(txtNombre);

        formulario.add(crearEtiqueta("Precio unitario (S/):"));
        formulario.add(txtPrecio);

        formulario.add(crearEtiqueta("Cantidad en stock:"));
        formulario.add(txtCantidad);

        formulario.add(crearEtiqueta("Categoría:"));
        formulario.add(txtCategoria);

        // BOTONES

        JButton btnActualizar = crearBoton("Actualizar Producto");
        JButton btnLimpiar = crearBoton("Limpiar");

        btnActualizar.addActionListener(e -> actualizarProducto());

        btnLimpiar.addActionListener(e -> limpiarFormulario());

        JPanel panelBotones = new JPanel(
                new FlowLayout(FlowLayout.RIGHT));

        panelBotones.setBackground(Color.WHITE);

        panelBotones.add(btnLimpiar);
        panelBotones.add(btnActualizar);

        // INFORMACION

        JPanel panelResultado = new JPanel(new BorderLayout());

        panelResultado.setBackground(Color.WHITE);

        panelResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        "Información actualizada"),
                new EmptyBorder(12, 15, 12, 15)));

        lblResultado = new JLabel(
                "<html><b>Complete los campos y actualice el producto.</b></html>");

        lblResultado.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        panelResultado.add(lblResultado, BorderLayout.CENTER);

        // TABLA

        modeloTabla = new DefaultTableModel(
                new Object[]{
                    "Nombre", "Precio", "Stock", "Categoría"
                }, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);

        tabla.setRowHeight(28);

        tabla.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        tabla.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 12));

        tabla.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {
                cargarSeleccion();
            }
        });

        JScrollPane scroll = new JScrollPane(tabla);

        scroll.setBorder(BorderFactory.createTitledBorder(
                "Productos registrados"));

        // DISTRIBUCION

        JPanel superior = new JPanel(new BorderLayout(10, 10));

        superior.setOpaque(false);

        superior.add(titulo, BorderLayout.NORTH);
        superior.add(formulario, BorderLayout.CENTER);
        superior.add(panelBotones, BorderLayout.SOUTH);

        JPanel centro = new JPanel(new BorderLayout(10, 10));

        centro.setOpaque(false);

        centro.add(panelResultado, BorderLayout.NORTH);
        centro.add(scroll, BorderLayout.CENTER);

        add(superior, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
    }

    // ACTUALIZAR PRODUCTO

    private void actualizarProducto() {

        String nombre = txtNombre.getText().trim();
        String precioTexto = txtPrecio.getText().trim()
                .replace(',', '.');

        String cantidadTexto = txtCantidad.getText().trim();
        String categoria = txtCategoria.getText().trim();

        if (nombre.isEmpty() || precioTexto.isEmpty()
                || cantidadTexto.isEmpty() || categoria.isEmpty()) {

            mostrarMensaje(
                    "Todos los campos son obligatorios.",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        try {

            double precio = Double.parseDouble(precioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);

            if (!Double.isFinite(precio) || precio <= 0) {

                mostrarMensaje(
                        "El precio debe ser positivo.",
                        JOptionPane.WARNING_MESSAGE);

                txtPrecio.requestFocus();
                return;
            }

            if (cantidad < 0) {

                mostrarMensaje(
                        "El stock no puede ser negativo.",
                        JOptionPane.WARNING_MESSAGE);

                txtCantidad.requestFocus();
                return;
            }

            Producto producto;

            if (indiceSeleccionado == -1) {

                producto = new Producto();

                producto.actualizarProducto(
                        nombre, precio, cantidad, categoria);

                productos.add(producto);

                modeloTabla.addRow(new Object[]{
                    nombre,
                    String.format("S/ %.2f", precio),
                    cantidad,
                    categoria
                });

            } else {

                producto = productos.get(indiceSeleccionado);

                producto.actualizarProducto(
                        nombre, precio, cantidad, categoria);

                modeloTabla.setValueAt(nombre,
                        indiceSeleccionado, 0);

                modeloTabla.setValueAt(
                        String.format("S/ %.2f", precio),
                        indiceSeleccionado, 1);

                modeloTabla.setValueAt(cantidad,
                        indiceSeleccionado, 2);

                modeloTabla.setValueAt(categoria,
                        indiceSeleccionado, 3);
            }

            mostrarInformacion(producto);

            limpiarFormulario();

            JOptionPane.showMessageDialog(
                    this,
                    "Producto actualizado correctamente.");

        } catch (NumberFormatException ex) {

            mostrarMensaje(
                    "Ingrese valores numéricos válidos.",
                    JOptionPane.ERROR_MESSAGE);

        } catch (IllegalArgumentException ex) {

            mostrarMensaje(
                    ex.getMessage(),
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // MOSTRAR INFORMACION EN LABEL

    private void mostrarInformacion(Producto producto) {

        String informacion = producto.obtenerInformacion();

        String html = "<html><b>INFORMACIÓN DEL PRODUCTO</b><br>"
                + "Nombre: " + escaparHTML(producto.getNombre())
                + "<br>Precio: S/ "
                + String.format("%.2f", producto.getPrecio())
                + "<br>Stock: " + producto.getCantidadStock()
                + " unidades<br>Categoría: "
                + escaparHTML(producto.getCategoria())
                + "</html>";

        lblResultado.setText(html);
    }

    // CARGAR PRODUCTO SELECCIONADO

    private void cargarSeleccion() {

        int fila = tabla.getSelectedRow();

        if (fila < 0) {
            return;
        }

        indiceSeleccionado = tabla.convertRowIndexToModel(fila);

        Producto producto = productos.get(indiceSeleccionado);

        txtNombre.setText(producto.getNombre());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtCantidad.setText(
                String.valueOf(producto.getCantidadStock()));
        txtCategoria.setText(producto.getCategoria());

        mostrarInformacion(producto);
    }

    // LIMPIAR

    private void limpiarFormulario() {

        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtCategoria.setText("");

        indiceSeleccionado = -1;

        tabla.clearSelection();

        lblResultado.setText(
                "<html>Complete los campos y actualice el producto.</html>");
    }

    private JTextField crearCampo() {

        JTextField campo = new JTextField();

        campo.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        return campo;
    }

    private JLabel crearEtiqueta(String texto) {

        JLabel etiqueta = new JLabel(texto);

        etiqueta.setFont(new Font("Segoe UI", Font.BOLD, 13));
        etiqueta.setForeground(OSCURO);

        return etiqueta;
    }

    private JButton crearBoton(String texto) {

        JButton boton = new JButton(texto);

        boton.setBackground(AZUL);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(10, 15, 10, 15));

        return boton;
    }

    private String escaparHTML(String texto) {

        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private void mostrarMensaje(String mensaje, int tipo) {

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Gestión de productos",
                tipo);
    }
}
