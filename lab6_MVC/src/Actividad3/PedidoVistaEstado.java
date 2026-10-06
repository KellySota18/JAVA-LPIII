package Actividad3;

import java.util.List;
import java.util.Scanner;

public class PedidoVistaEstado {
    private Scanner scanner;

    // Constructor
    public PedidoVistaEstado() {

        scanner = new Scanner(System.in);
    }

    // SOLICITAR NOMBRE

    public String solicitarNombrePlato() {

        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    // SOLICITAR TIPO
    public String solicitarTipo() {

        System.out.print(
            "Introduce el tipo del plato: "
        );

        return scanner.nextLine();
    }

    // SOLICITAR ESTADO

    public String solicitarEstado() {

        System.out.print(
            "Introduce el estado (PENDIENTE/COMPLETO): "
        );

        return scanner.nextLine();
    }

    // ==========================================
    // MOSTRAR TODOS LOS PEDIDOS
    // ==========================================

    public void mostrarPedidos(
            List<PedidoEstado> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println(
                "\nNo hay pedidos en la lista."
            );

        } else {

            System.out.println(
                "\n===== LISTA DE PEDIDOS ====="
            );

            int numero = 1;

            for (PedidoEstado pedido : pedidos) {

                System.out.println(numero + ". Plato: " + pedido.getNombrePlato()
                    + " | Tipo: "  + pedido.getTipo()
                    + " | Estado: " + pedido.getEstado()
                );

                numero++;
            }
        }
    }

    // MOSTRAR PEDIDOS POR ESTADO
    public void mostrarPedidosPorEstado(
            List<PedidoEstado> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println("\nNo se encontraron pedidos con ese estado.");

        } else {

            System.out.println("\n===== PEDIDOS POR ESTADO =====");

            int numero = 1;

            for (PedidoEstado pedido : pedidos) {

                System.out.println(
                    numero
                    + ". Plato: "
                    + pedido.getNombrePlato()
                    + " | Tipo: "
                    + pedido.getTipo()
                    + " | Estado: "
                    + pedido.getEstado()
                );

                numero++;
            }
        }
    }

    // MOSTRAR HISTORIAL

    public void mostrarHistorial(
            List<PedidoEstado> historial) {

        if (historial.isEmpty()) {

            System.out.println("\nEl historial está vacío");

        } else {

            System.out.println("\n===== HISTORIAL DE PEDIDOS =====");
            int numero = 1;
            for (PedidoEstado pedido : historial) {

                System.out.println(numero + ". Plato: "
                    + pedido.getNombrePlato() + " | Tipo: "
                    + pedido.getTipo() + " | Estado: " + pedido.getEstado()
                );

                numero++;
            }
        }
    }

    public void mostrarMenu() {

        System.out.println("\n==============================");
        System.out.println("GESTIÓN DE PEDIDOS");
        System.out.println("ACTIVIDAD 3");
        System.out.println("==============================");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Marcar Pedido como Completo");
        System.out.println("4. Mostrar Pedidos por Estado");
        System.out.println("5. Contar Pedidos Pendientes");
        System.out.println("6. Eliminar Pedido");
        System.out.println("7. Mostrar Historial");
        System.out.println("8. Salir");
    }

    // SOLICITAR OPCIÓN

    public String solicitarOpcion() {

        System.out.print("Selecciona una opción: ");

        return scanner.nextLine();
    }
    
    // MOSTRAR MENSAJE
    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}