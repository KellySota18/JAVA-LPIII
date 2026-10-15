package Actividad1; 

// Importa List para trabajar con una lista de pedidos
import java.util.List;

// Importa Scanner para leer los datos ingresados por el usuario.
import java.util.Scanner;
// Clase Vista: se encarga de mostrar información y recibir datos del usuario.
public class PedidoVista {
    // Declara un atributo Scanner para leer lo que el usuario escribe por consola.
    private Scanner scanner;

    // Constructor de la vista: se ejecuta cuando se crea un objeto PedidoVista.
    public PedidoVista() {
        // Inicializa Scanner para leer datos desde el teclado.
        scanner = new Scanner(System.in);
    }

    // Método que solicita al usuario el nombre del plato y devuelve el texto ingresado.
    public String solicitarNombrePlato() {

        // Muestra un mensaje para solicitar el nombre del plato.
        System.out.print("Introduce el nombre del plato: ");

        // Lee una línea completa ingresada por el usuario y la devuelve.
        return scanner.nextLine();
    }

    // Método que recibe una lista de pedidos y los muestra por consola.
    public void mostrarPedidos(List<Pedido> pedidos) {

        // Comprueba si la lista de pedidos está vacía.
        if (pedidos.isEmpty()) {

            // Informa que todavía no hay pedidos registrados.
            System.out.println("No hay pedidos en la lista");

        } else {
            // Muestra el título de la lista de pedidos.
            System.out.println("\nLista de Pedidos:");

            // Recorre cada pedido almacenado en la lista.
            for (Pedido pedido : pedidos) {

                // Muestra el nombre del plato de cada pedido.
                System.out.println("- " + pedido.getNombrePlato());
            }
        }
    }

    // Método que muestra las opciones disponibles en el menú principal.
    public void mostrarMenu() {

        // Muestra el título del menú del restaurante.
        System.out.println("\n===== RESTAURANTE =====");

        // Muestra la opción para agregar un pedido.
        System.out.println("1. Agregar Pedido");

        // Muestra la opción para visualizar los pedidos registrados.
        System.out.println("2. Mostrar Pedidos");

        // Muestra la opción para salir del programa.
        System.out.println("3. Salir");
    }

    // Método que solicita una opción del menú y devuelve la respuesta del usuario.
    public String solicitarOpcion() {

        // Solicita al usuario que seleccione una opción.
        System.out.print("Selecciona una opción: ");

        // Lee la opción ingresada y la devuelve como una cadena de texto.
        return scanner.nextLine();
    }
    // Método que recibe un mensaje y lo muestra por consola.
    public void mostrarMensaje(String mensaje) {
        // Imprime el mensaje recibido como parámetro.
        System.out.println(mensaje);
    }
    // Método que cierra el Scanner cuando ya no se necesita.
    public void cerrarScanner() {
        // Cierra Scanner y libera el recurso de entrada asociado.
        scanner.close();
    }
}
