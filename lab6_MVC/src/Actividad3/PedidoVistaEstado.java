package Actividad3; 

// Importa List para trabajar con listas de pedidos.
import java.util.List;

// Importa Scanner para leer los datos ingresados por el usuario.
import java.util.Scanner;

// Clase Vista: muestra información y solicita datos al usuario por consola.
public class PedidoVistaEstado {

    // Atributo que permite leer los datos ingresados desde el teclado.
    private Scanner scanner;

    // Constructor de la clase PedidoVistaEstado.
    public PedidoVistaEstado() {

        // Inicializa Scanner para leer datos desde la consola.
        scanner = new Scanner(System.in);
    }

    // Método que solicita el nombre del plato al usuario.
    public String solicitarNombrePlato() {

        // Muestra un mensaje solicitando el nombre del plato.
        System.out.print("Introduce el nombre del plato: ");

        // Lee y devuelve el nombre ingresado por el usuario.
        return scanner.nextLine();
    }

    // Método que solicita el tipo de plato al usuario.
    public String solicitarTipo() {

        // Muestra un mensaje solicitando el tipo del plato.
        System.out.print(
            "Introduce el tipo del plato: "
        );

        // Lee y devuelve el tipo ingresado.
        return scanner.nextLine();
    }

    // Método que solicita el estado inicial o actual del pedido.
    public String solicitarEstado() {

        // Indica los estados permitidos para el pedido.
        System.out.print(
            "Introduce el estado (PENDIENTE/COMPLETO): "
        );

        // Lee y devuelve el estado ingresado por el usuario.
        return scanner.nextLine();
    }

    // Método que muestra todos los pedidos registrados.
    public void mostrarPedidos(
            List<PedidoEstado> pedidos) {

        // Comprueba si la lista de pedidos está vacía.
        if (pedidos.isEmpty()) {

            // Informa que no hay pedidos registrados.
            System.out.println(
                "\nNo hay pedidos en la lista."
            );

        } else {

            // Muestra el encabezado de la lista de pedidos.
            System.out.println("\n===== LISTA DE PEDIDOS =====");

            // Inicializa el contador para numerar los pedidos.
            int numero = 1;

            // Recorre todos los pedidos almacenados en la lista.
            for (PedidoEstado pedido : pedidos) {

                // Muestra el número, nombre, tipo y estado de cada pedido.
                System.out.println(numero + ". Plato: " + pedido.getNombrePlato() + " | Tipo: " + pedido.getTipo() + " | Estado: " + pedido.getEstado());

                // Incrementa el contador para el siguiente pedido.
                numero++;
            }
        }
    }

    // Método que muestra únicamente los pedidos recibidos para un estado específico.
    public void mostrarPedidosPorEstado(
            List<PedidoEstado> pedidos) {

        // Comprueba si la lista recibida está vacía.
        if (pedidos.isEmpty()) {

            // Informa que no se encontraron pedidos con ese estado.
            System.out.println("\nNo se encontraron pedidos con ese estado.");

        } else {

            // Muestra el encabezado de los pedidos filtrados por estado.
            System.out.println("\n===== PEDIDOS POR ESTADO =====");

            // Inicializa el contador de pedidos.
            int numero = 1;

            // Recorre los pedidos que se deben mostrar.
            for (PedidoEstado pedido : pedidos) {

                // Muestra el número, nombre del plato, tipo y estado del pedido.
                System.out.println(numero + ". Plato: " + pedido.getNombrePlato() + " | Tipo: " + pedido.getTipo() + " | Estado: " + pedido.getEstado());

                // Incrementa el contador.
                numero++;
            }
        }
    }

    // Método que muestra el historial de pedidos.
    public void mostrarHistorial(
            List<PedidoEstado> historial) {

        // Comprueba si el historial está vacío.
        if (historial.isEmpty()) {

            // Informa que todavía no hay registros en el historial.
            System.out.println("\nEl historial está vacío");

        } else {

            // Muestra el encabezado del historial.
            System.out.println("\n===== HISTORIAL DE PEDIDOS =====");

            // Inicializa el contador para numerar los registros.
            int numero = 1;

            // Recorre todos los pedidos almacenados en el historial.
            for (PedidoEstado pedido : historial) {

                // Muestra los datos de cada pedido del historial.
                System.out.println(numero + ". Plato: " + pedido.getNombrePlato() + " | Tipo: " + pedido.getTipo() + " | Estado: " + pedido.getEstado());

                // Incrementa el contador para el siguiente registro.
                numero++;
            }
        }
    }

    // Método que muestra el menú principal de gestión de pedidos.
    public void mostrarMenu() {

        // Muestra una línea decorativa.
        System.out.println("\n==============================");

        // Muestra el nombre del sistema.
        System.out.println("GESTIÓN DE PEDIDOS");

        // Identifica el número de la actividad.
        System.out.println("ACTIVIDAD 3");

        // Cierra el encabezado del menú.
        System.out.println("==============================");

        // Opción 1: permite agregar un pedido.
        System.out.println("1. Agregar Pedido");

        // Opción 2: muestra todos los pedidos.
        System.out.println("2. Mostrar Pedidos");

        // Opción 3: permite marcar un pedido como completo.
        System.out.println("3. Marcar Pedido como Completo");

        // Opción 4: muestra los pedidos según su estado.
        System.out.println("4. Mostrar Pedidos por Estado");

        // Opción 5: permite consultar la cantidad de pedidos pendientes.
        System.out.println("5. Contar Pedidos Pendientes");

        // Opción 6: permite eliminar un pedido.
        System.out.println("6. Eliminar Pedido");

        // Opción 7: muestra el historial de pedidos.
        System.out.println("7. Mostrar Historial");

        // Opción 8: permite salir del programa.
        System.out.println("8. Salir");
    }

    // Método que solicita al usuario una opción del menú.
    public String solicitarOpcion() {

        // Muestra el mensaje para seleccionar una opción.
        System.out.print("Selecciona una opción: ");

        // Lee y devuelve la opción ingresada como texto.
        return scanner.nextLine();
    }

    // Método que recibe un mensaje y lo muestra por consola.
    public void mostrarMensaje(String mensaje) {

        // Imprime el mensaje recibido como parámetro.
        System.out.println(mensaje);
    }

    // Método que cierra el Scanner cuando ya no se necesita.
    public void cerrarScanner() {

        // Cierra Scanner y el recurso de entrada System.in asociado.
        scanner.close();
    }
}
