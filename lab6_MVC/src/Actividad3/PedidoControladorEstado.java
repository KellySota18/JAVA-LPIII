package Actividad3;

import java.util.List;

public class PedidoControladorEstado {

    private PedidoModeloEstado modelo;
    private PedidoVistaEstado vista;

    // Constructor
    public PedidoControladorEstado(
            PedidoModeloEstado modelo,
            PedidoVistaEstado vista) {

        this.modelo = modelo;
        this.vista = vista;
    }

    // ==========================================
    // AGREGAR PEDIDO
    // ==========================================

    public void agregarPedido() {

        String nombrePlato =
                vista.solicitarNombrePlato();

        String tipo =
                vista.solicitarTipo();

        if (nombrePlato.isBlank()) {

            vista.mostrarMensaje(
                "El nombre del plato no puede estar vacío."
            );

            return;
        }

        if (tipo.isBlank()) {

            vista.mostrarMensaje(
                "El tipo del plato no puede estar vacío."
            );

            return;
        }

        PedidoEstado pedido =
                new PedidoEstado(
                    nombrePlato,
                    tipo
                );

        modelo.agregarPedido(pedido);

        vista.mostrarMensaje(
            "Pedido agregado correctamente."
        );

        vista.mostrarMensaje(
            "Estado inicial: PENDIENTE"
        );
    }

    // ==========================================
    // MOSTRAR PEDIDOS
    // ==========================================

    public void mostrarPedidos() {

        List<PedidoEstado> pedidos =
                modelo.getPedidos();

        vista.mostrarPedidos(pedidos);
    }

    // ==========================================
    // MARCAR COMO COMPLETO
    // ==========================================

    public void marcarComoCompleto() {

        String nombre =
                vista.solicitarNombrePlato();

        if (nombre.isBlank()) {

            vista.mostrarMensaje(
                "El nombre no puede estar vacío."
            );

            return;
        }

        boolean completado =
                modelo.marcarComoCompleto(nombre);

        if (completado) {

            vista.mostrarMensaje(
                "Pedido marcado como COMPLETO."
            );

        } else {

            vista.mostrarMensaje(
                "No se encontró el pedido."
            );
        }
    }

    // ==========================================
    // MOSTRAR PEDIDOS POR ESTADO
    // ==========================================

    public void mostrarPorEstado() {

        String estado = vista.solicitarEstado();

        if (estado.isBlank()) {

            vista.mostrarMensaje("El estado no puede estar vacío");

            return;
        }

        if (!estado.equalsIgnoreCase("PENDIENTE") && !estado.equalsIgnoreCase("COMPLETO")) {

            vista.mostrarMensaje("Estado no válido");

            return;
        }

        List<PedidoEstado> resultados = modelo.buscarPorEstado(estado);

        vista.mostrarPedidosPorEstado(resultados);
    }

    // CONTAR PENDIENTES

    public void contarPendientes() {

        int cantidad = modelo.contarPendientes();

        vista.mostrarMensaje("\n===== PEDIDOS PENDIENTES =====");
        vista.mostrarMensaje("Cantidad de pedidos pendientes: "+ cantidad);
    }

    // ELIMINAR PEDIDO
    public void eliminarPedido() {

        String nombre = vista.solicitarNombrePlato();

        if (nombre.isBlank()) {

            vista.mostrarMensaje("El nombre no puede estar vacío");
            return;
        }

        boolean eliminado = modelo.eliminarPedido(nombre);

        if (eliminado) {

            vista.mostrarMensaje("Pedido eliminado correctamente");

        } else {

            vista.mostrarMensaje("No se encontró el pedido");
        }
    }

    // MOSTRAR HISTORIAL
    public void mostrarHistorial() {

        List<PedidoEstado> historial = modelo.getHistorial();
        vista.mostrarHistorial(historial);
    }

    // INICIAR APLICACIÓN
    public void iniciar() {

        String opcion;

        do {

            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            switch (opcion) {

                case "1":

                    agregarPedido();
                    break;

                case "2":

                    mostrarPedidos();
                    break;

                case "3":

                    marcarComoCompleto();
                    break;

                case "4":

                    mostrarPorEstado();
                    break;

                case "5":

                    contarPendientes();
                    break;

                case "6":

                    eliminarPedido();
                    break;

                case "7":

                    mostrarHistorial();
                    break;

                case "8":

                    vista.mostrarMensaje("Saliendo del sistema");
                    break;

                default:

                    vista.mostrarMensaje("Opción no válida"+ "Inténtalo nuevamente");
                    break;
            }

        } while (!opcion.equals("8"));

        vista.cerrarScanner();
    }
}