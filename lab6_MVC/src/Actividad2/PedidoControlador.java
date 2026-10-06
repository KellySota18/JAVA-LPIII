package Actividad2;

import java.util.List;

public class PedidoControlador {

    private PedidoModelo modelo;
    private PedidoVista vista;

    // Constructor
    public PedidoControlador(
            PedidoModelo modelo,
            PedidoVista vista) {

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

        Pedido pedido =
                new Pedido(nombrePlato, tipo);

        modelo.agregarPedido(pedido);

        vista.mostrarMensaje(
            "Pedido agregado correctamente: "
            + nombrePlato
        );
    }

    // ==========================================
    // MOSTRAR PEDIDOS
    // ==========================================

    public void mostrarPedidos() {

        List<Pedido> pedidos =
                modelo.getPedidos();

        vista.mostrarPedidos(pedidos);
    }

    // ==========================================
    // ELIMINAR PEDIDO
    // ==========================================

    public void eliminarPedido() {

        String nombre =
                vista.solicitarNombrePlato();

        if (nombre.isBlank()) {

            vista.mostrarMensaje(
                "El nombre no puede estar vacío."
            );

            return;
        }

        boolean eliminado =
                modelo.eliminarPedido(nombre);

        if (eliminado) {

            vista.mostrarMensaje(
                "Pedido eliminado correctamente."
            );

        } else {

            vista.mostrarMensaje(
                "No se encontró un pedido con ese nombre."
            );
        }
    }

    // ==========================================
    // ACTUALIZAR PEDIDO
    // ==========================================

    public void actualizarPedido() {

        String nombreActual =
                vista.solicitarNombrePlato();

        if (nombreActual.isBlank()) {

            vista.mostrarMensaje(
                "El nombre actual no puede estar vacío."
            );

            return;
        }

        String nuevoNombre =
                vista.solicitarNuevoNombre();

        if (nuevoNombre.isBlank()) {

            vista.mostrarMensaje(
                "El nuevo nombre no puede estar vacío."
            );

            return;
        }

        boolean actualizado =
                modelo.actualizarPedido(
                    nombreActual,
                    nuevoNombre
                );

        if (actualizado) {

            vista.mostrarMensaje(
                "Pedido actualizado correctamente."
            );

        } else {

            vista.mostrarMensaje(
                "No se encontró un pedido con ese nombre."
            );
        }
    }

    // ==========================================
    // BUSCAR PEDIDO
    // ==========================================

    public void buscarPedido() {

        System.out.println("\n===== BUSCAR PEDIDO =====");
        System.out.println("1. Buscar por nombre");
        System.out.println("2. Buscar por tipo");

        String opcion =
                vista.solicitarOpcion();

        switch (opcion) {

            case "1":

                String nombre =
                        vista.solicitarNombrePlato();

                if (nombre.isBlank()) {

                    vista.mostrarMensaje(
                        "El nombre no puede estar vacío."
                    );

                    return;
                }

                List<Pedido> resultadosNombre =
                        modelo.buscarPorNombre(nombre);

                vista.mostrarResultados(
                        resultadosNombre
                );

                break;

            case "2":

                String tipo = vista.solicitarTipo();

                if (tipo.isBlank()) {

                    vista.mostrarMensaje("El tipo no puede estar vacio");

                    return;
                }

                List<Pedido> resultadosTipo = modelo.buscarPorTipo(tipo);

                vista.mostrarResultados(resultadosTipo);

                break;

            default:

                vista.mostrarMensaje("busqueda invalida");

                break;
        }
    }

    // ==========================================
    // CONTAR PEDIDOS
    // ==========================================

    public void contarPedidos() {

        int total = modelo.contarPedidos();

        System.out.println("\n===== CANTIDAD DE PEDIDOS =====");
        System.out.println("Cantidad total de pedidos: " + total);
        System.out.println("\n===== PEDIDOS SEGÚN TIPO =====");

        String[] tipos = {
            "Entrada",
            "Plato principal",
            "Postre",
            "Bebida"
        };

        for (String tipo : tipos) {

            int cantidad = modelo.contarPorTipo(tipo);

            System.out.println(
                tipo + ": " + cantidad
            );
        }
    }

    // ==========================================
    // INICIAR PROGRAMA
    // ==========================================

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

                    eliminarPedido();

                    break;

                case "4":

                    actualizarPedido();

                    break;

                case "5":

                    buscarPedido();

                    break;

                case "6":

                    contarPedidos();

                    break;

                case "7":

                    vista.mostrarMensaje("Saliendo del sistema");

                    break;

                default:

                    vista.mostrarMensaje("Opción no valida, inténtalo otra vez");

                    break;
            }

        } while (!opcion.equals("7"));

        vista.cerrarScanner();
    }
}