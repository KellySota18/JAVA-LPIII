package EjercicioII;

import java.util.List;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarItem() {
        String nombre = vista.pedirTexto("Nombre del ítem: ");
        int cantidad = vista.pedirEntero("Cantidad: ");
        String tipo = vista.pedirTexto("Tipo (Arma, Poción, etc.): ");
        String descripcion = vista.pedirTexto("Descripción: ");

        Item nuevo = new Item(nombre, cantidad, tipo, descripcion);
        modelo.agregarItem(nuevo);
        vista.mostrarMensaje("Ítem " + nombre + " agregado con éxito.");
    }

    public void eliminarItem() {
        String nombre = vista.pedirTexto("Nombre del ítem a eliminar: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("Ítem " + nombre + " eliminado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró el ítem.");
        }
    }

    public void verInventario() {
        List<Item> items = modelo.obtenerItems();
        vista.mostrarInventario(items);
    }

    public void mostrarDetalles() {
        String nombre = vista.pedirTexto("Nombre del ítem a consultar: ");
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public void buscarItem() {
        String nombre = vista.pedirTexto("Nombre del ítem a buscar: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            vista.mostrarMensaje("Ítem encontrado: " + item.getNombre() + " - " + item.getTipo());
        } else {
            vista.mostrarMensaje("Ítem no encontrado.");
        }
    }

    public void usarItem() {
        String nombre = vista.pedirTexto("Nombre del ítem a usar: ");
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            item.usarItem();
        } else {
            vista.mostrarMensaje("No se encontró el ítem en el inventario.");
        }
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.pedirEntero("");
            switch (opcion) {
                case 1:
                    agregarItem();
                    break;
                case 2:
                    eliminarItem();
                    break;
                case 3:
                    verInventario();
                    break;
                case 4:
                    mostrarDetalles();
                    break;
                case 5:
                    usarItem();
                    break;
                case 6:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 6);
        
        vista.cerrarScanner();
    }
}