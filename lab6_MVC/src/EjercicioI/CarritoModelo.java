package EjercicioI;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<Producto> catalogo;
    private List<Producto> carrito;
    private List<Compra> historialCompras;
    private double porcentajeDescuento;
    private double costoEnvio;

    public CarritoModelo() {
        catalogo = new ArrayList<>();
        carrito = new ArrayList<>();
        historialCompras = new ArrayList<>();
        porcentajeDescuento = 0.0;
        costoEnvio = 8.0;
    }

    public void agregarAlCatalogo(Producto p) {
        catalogo.add(p);
    }

    public List<Producto> getCatalogo() {
        return catalogo;
    }

    public Producto buscarEnCatalogo(String id) {
        for (Producto p : catalogo) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public void agregarAlCarrito(Producto p) {
        carrito.add(p);
    }

    public boolean eliminarDelCarrito(int pos) {
        if (pos >= 0 && pos < carrito.size()) {
            carrito.remove(pos);
            return true;
        }
        return false;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setPorcentajeDescuento(double porcentaje) {
        this.porcentajeDescuento = porcentaje;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public double calcularSubtotal() {
        double acum = 0;
        for (Producto p : carrito) {
            acum += p.getPrecio();
        }
        return acum;
    }

    public double calcularMontoDescuento() {
        return calcularSubtotal() * (porcentajeDescuento / 100.0);
    }

    public double calcularTotal() {
        if (carrito.isEmpty()) {
            return 0;
        }
        return (calcularSubtotal() - calcularMontoDescuento()) + costoEnvio;
    }

    public boolean procesarCompra() {
        if (carrito.isEmpty()) {
            return false;
        }

        Compra venta = new Compra(
            carrito,
            calcularSubtotal(),
            calcularMontoDescuento(),
            costoEnvio,
            calcularTotal()
        );

        historialCompras.add(venta);
        carrito.clear();
        porcentajeDescuento = 0.0;
        return true;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }
}