package EjercicioI;

public class CarritoController {
    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoController(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = -1;
        do {
            vista.mostrarMenu();
            opcion = vista.pedirEntero("");
            
            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    vista.mostrarCatalogo(modelo.getCatalogo());
                    break;
                case 3:
                    agregarAlCarrito();
                    break;
                case 4:
                    verCarrito();
                    break;
                case 5:
                    eliminarDelCarrito();
                    break;
                case 6:
                    aplicarDescuento();
                    break;
                case 7:
                    calcularEnvio();
                    break;
                case 8:
                    confirmarCompra();
                    break;
                case 9:
                    vista.mostrarHistorial(modelo.getHistorialCompras());
                    break;
                case 0:
                    vista.mostrarMensaje("Cerrando el sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida, intenta otra vez.");
            }
        } while (opcion != 0);
    }

    private void registrarProducto() {
        String id = vista.pedirTexto("Código/ID del producto: ");
        String nombre = vista.pedirTexto("Nombre del producto: ");
        double precio = vista.pedirDouble("Precio unitario: ");

        modelo.agregarAlCatalogo(new Producto(id, nombre, precio));
        vista.mostrarMensaje("Producto guardado correctamente.");
    }

    private void agregarAlCarrito() {
        vista.mostrarCatalogo(modelo.getCatalogo());
        if (modelo.getCatalogo().isEmpty()) return;

        String id = vista.pedirTexto("Ingresa el código del producto a agregar: ");
        Producto p = modelo.buscarEnCatalogo(id);

        if (p != null) {
            modelo.agregarAlCarrito(p);
            vista.mostrarMensaje("Se agregó '" + p.getNombre() + "' al carrito.");
        } else {
            vista.mostrarMensaje("El producto no existe.");
        }
    }

    private void verCarrito() {
        vista.mostrarCarrito(
            modelo.getCarrito(),
            modelo.calcularSubtotal(),
            modelo.calcularMontoDescuento(),
            modelo.getCostoEnvio(),
            modelo.calcularTotal()
        );
    }

    private void eliminarDelCarrito() {
        if (modelo.getCarrito().isEmpty()) {
            vista.mostrarMensaje("No hay ítems para eliminar en el carrito.");
            return;
        }

        verCarrito();
        int pos = vista.pedirEntero("Ingresa el número del producto que quieres quitar: ");
        if (modelo.eliminarDelCarrito(pos - 1)) {
            vista.mostrarMensaje("Producto eliminado.");
        } else {
            vista.mostrarMensaje("Número de ítem no válido.");
        }
    }

    private void aplicarDescuento() {
        double porc = vista.pedirDouble("Ingresa el porcentaje de descuento (0 a 100): ");
        if (porc >= 0 && porc <= 100) {
            modelo.setPorcentajeDescuento(porc);
            vista.mostrarMensaje("Se aplicó un " + porc + "% de descuento.");
        } else {
            vista.mostrarMensaje("Porcentaje inválido.");
        }
    }

    private void calcularEnvio() {
        double km = vista.pedirDouble("Distancia de entrega en km: ");
        double costo = 5.0 + (km * 1.2);
        modelo.setCostoEnvio(costo);
        vista.mostrarMensaje("Costo de envío recalculado: S/ " + String.format("%.2f", costo));
    }

    private void confirmarCompra() {
        if (modelo.procesarCompra()) {
            vista.mostrarMensaje("Comprado");
        } else {
            vista.mostrarMensaje("No se pudo realizar la compra porque el carrito esta vacio.");
        }
    }
}