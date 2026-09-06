package Habitaciones;

/**
 * Suite: ofrece los tres servicios y aplica un recargo sobre el precio base.
 */
public class HabitacionSuite extends Habitacion
        implements ServicioLimpieza, ServicioComida, ServicioLavanderia {

    private static final double PRECIO_BASE = 350.0;
    private static final double RECARGO = 1.25;

    public HabitacionSuite(String numero) {
        super(numero, PRECIO_BASE);
    }

    @Override
    public String getTipo() {
        return "Suite";
    }

    @Override
    public String getCaracteristicas() {
        return "Cama king, sala, jacuzzi, wifi, minibar";
    }

    @Override
    public double calcularPrecio() {
        return precioBase * RECARGO;
    }

    @Override
    public void limpiar() {
        System.out.println("Limpieza premium de la suite " + numero);
    }

    @Override
    public void solicitarComida(String pedido) {
        System.out.println("Pedido gourmet para la suite " + numero + ": " + pedido);
    }

    @Override
    public void solicitarLavanderia(int cantidadPrendas) {
        System.out.println("Lavandería: " + cantidadPrendas
                + " prendas recogidas de la suite " + numero);
    }
}
