package EjercicioI;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner sc;

    public CarritoVista() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n GESTIÓN DE CARRITO DE COMPRAS ");
        System.out.println("1. Agregar nuevo producto al catálogo");
        System.out.println("2. Ver lista de productos en catálogo");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver contenido del carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar cupón de descuento");
        System.out.println("7. Calcular tarifa de envío");
        System.out.println("8. Confirmar y realizar compra");
        System.out.println("9. Ver historial de compras");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    public String pedirTexto(String msj) {
        System.out.print(msj);
        return sc.nextLine().trim();
    }

    public double pedirDouble(String msj) {
        System.out.print(msj);
        while (!sc.hasNextDouble()) {
            System.out.print("Ingresa un número válido (ej. 12.50): ");
            sc.next();
        }
        double num = sc.nextDouble();
        sc.nextLine(); 
        return num;
    }

    public int pedirEntero(String msj) {
        System.out.print(msj);
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número entero: ");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine(); 
        return num;
    }

    public void mostrarCatalogo(List<Producto> lista) {
        System.out.println("\n CATÁLOGO DE PRODUCTOS ");
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay productos cargados en el sistema.");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    public void mostrarCarrito(List<Producto> carrito, double subtotal, double desc, double envio, double total) {
        System.out.println("\n CARRITO ACTUAL ");
        if (carrito == null || carrito.isEmpty()) {
            System.out.println("Tu carrito está vacío.");
        } else {
            for (int i = 0; i < carrito.size(); i++) {
                System.out.println((i + 1) + ". " + carrito.get(i).getNombre() + " - S/ " + String.format("%.2f", carrito.get(i).getPrecio()));
            }

            System.out.println("Subtotal:            S/ " + String.format("%.2f", subtotal));
            System.out.println("Descuento:          -S/ " + String.format("%.2f", desc));
            System.out.println("Costo de envío:      S/ " + String.format("%.2f", envio));
            System.out.println("TOTAL FINAL:         S/ " + String.format("%.2f", total));
        }
    }

    public void mostrarHistorial(List<Compra> historial) {
        System.out.println("\n HISTORIAL DE COMPRAS ");
        if (historial == null || historial.isEmpty()) {
            System.out.println("Aún no se ha realizado ninguna compra.");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println("Compra #" + (i + 1) + ":");
                historial.get(i).mostrarResumen();
                System.out.println();
            }
        }
    }

    public void mostrarMensaje(String msj) {
        System.out.println(">> " + msj);
    }
}