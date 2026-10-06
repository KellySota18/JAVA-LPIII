package Actividad2;
import java.util.List;
import java.util.Scanner;

public class PedidoVista {

    private Scanner scanner;

    // Constructor
    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Solicitar nombre del plato
    public String solicitarNombrePlato() {

        System.out.print("Introduce el nombre del plato: ");       
        return scanner.nextLine();
    }

    // Solicitar nuevo nombre
    public String solicitarNuevoNombre() {

        System.out.print("Introduce el nuevo nombre del plato: ");

        return scanner.nextLine();
    }

    // Solicitar tipo
    public String solicitarTipo() {

        System.out.print("Introduce el tipo del plato: ");

        return scanner.nextLine();
    }

    // Mostrar todos los pedidos
    public void mostrarPedidos(List<Pedido> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println("\nNo hay pedidos en la lista.");

        } else {

            System.out.println("\n===== LISTA DE PEDIDOS =====");

            int numero = 1;

            for (Pedido pedido : pedidos) {

                System.out.println(
                    numero + ". Plato: "
                    + pedido.getNombrePlato()
                    + " | Tipo: "
                    + pedido.getTipo()
                );

                numero++;
            }
        }
    }

    // Mostrar menú principal
    public void mostrarMenu() {

        System.out.println("\n==============================");
        System.out.println("     GESTIÓN DE PEDIDOS");
        System.out.println("==============================");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
        System.out.println("==============================");
    }

    // Solicitar opción
    public String solicitarOpcion() {

        System.out.print("Selecciona una opción: ");

        return scanner.nextLine();
    }

    // Mostrar mensaje
    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    // Mostrar resultados de búsqueda
    public void mostrarResultados(List<Pedido> resultados) {

        if (resultados.isEmpty()) {

            System.out.println(
                "\nNo se encontraron pedidos."
            );

        } else {

            System.out.println("\n===== RESULTADOS DE BÚSQUEDA =====");

            int numero = 1;

            for (Pedido pedido : resultados) {

                System.out.println(
                    numero + ". Plato: "
                    + pedido.getNombrePlato()
                    + " | Tipo: "
                    + pedido.getTipo()
                );

                numero++;
            }
        }
    }

    // Cerrar Scanner
    public void cerrarScanner() {

        scanner.close();
    }
}