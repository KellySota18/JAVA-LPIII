package EjercicioII;

import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("\nEl inventario está vacío.");
        } else {
            System.out.println("\n=== INVENTARIO DE ITEMS ===");
            for (Item item : items) {
                System.out.println("- " + item.getNombre() + " (x" + item.getCantidad() + ") [" + item.getTipo() + "]");
            }
        }
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("\n DETALLES DEL ITEM ");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("El ítem no fue encontrado.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMenu() {
        System.out.println("\n GESTIÓN DE INVENTARIOS ");
        System.out.println("1. Agregar Ítem");
        System.out.println("2. Eliminar Ítem");
        System.out.println("3. Ver Inventario");
        System.out.println("4. Buscar Ítem / Mostrar Detalles");
        System.out.println("5. Usar Ítem");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); 
        return num;
    }

    public void cerrarScanner() {
        scanner.close();
    }
}