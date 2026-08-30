package actividad1;

public class EjemploCoche {
    public static void main(String[] args) {
        // Crear objetos coche
        Coche cocheDeportivo = new Coche("Ferrari", "488 GTB", 2022, 250000.0);
        Coche cocheTodoTerreno = new Coche("Toyota", "Land Cruiser", 2008, 45000.0);

        System.out.println("=== Datos iniciales ===");
        System.out.println("Deportivo: " + cocheDeportivo.getMarca() + " " + cocheDeportivo.getModelo()
                + " (" + cocheDeportivo.getAnoFabricacion() + ") - $" + cocheDeportivo.getPrecio());
        System.out.println("TodoTerreno: " + cocheTodoTerreno.getMarca() + " " + cocheTodoTerreno.getModelo()
                + " (" + cocheTodoTerreno.getAnoFabricacion() + ") - $" + cocheTodoTerreno.getPrecio());

        System.out.println("\n=== Aplicando descuento (solo modelos < 2010) ===");
        boolean descDeportivo = cocheDeportivo.aplicarDescuento(10);
        boolean descTodoTerreno = cocheTodoTerreno.aplicarDescuento(15);
        System.out.println("Descuento aplicado a deportivo: " + descDeportivo + " -> Precio: $" + cocheDeportivo.getPrecio());
        System.out.println("Descuento aplicado a todoterreno: " + descTodoTerreno + " -> Precio: $" + cocheTodoTerreno.getPrecio());

        // Encender los coches
        System.out.println("\n=== Encender los coches ===");
        cocheDeportivo.encender();
        cocheTodoTerreno.encender();

        // Acelerar y frenar los coches
        System.out.println("\n=== Acelerar y frenar los coches ===");
        cocheDeportivo.acelerar();
        cocheTodoTerreno.acelerar();
        cocheDeportivo.frenar();
        cocheTodoTerreno.frenar();

        // Apagar los coches
        System.out.println("\n=== Apagar los coches ===");
        cocheDeportivo.apagar();
        cocheTodoTerreno.apagar();
    }
}
