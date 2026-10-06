package EjercicioI;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Producto> productos;
    private double subtotal;
    private double descuento;
    private double costoEnvio;
    private double total;

    public Compra(List<Producto> productos, double subtotal, double descuento, double costoEnvio, double total) {
        this.productos = new ArrayList<>(productos);
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.costoEnvio = costoEnvio;
        this.total = total;
    }

    public void mostrarResumen() {
        System.out.println("Productos comprados (" + productos.size() + ") - Total final: S/ " + String.format("%.2f", total));
        for (Producto p : productos) {
            System.out.println("  • " + p.getNombre() + " -> S/ " + String.format("%.2f", p.getPrecio()));
        }
    }
}