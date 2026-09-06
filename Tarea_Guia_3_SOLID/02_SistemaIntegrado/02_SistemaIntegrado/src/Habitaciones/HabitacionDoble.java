package Habitaciones;

/**
 * Habitación doble: ofrece limpieza y servicio de comida.
 */
public class HabitacionDoble extends Habitacion
        implements ServicioLimpieza, ServicioComida {

    private static final double PRECIO_BASE = 190.0;

    public HabitacionDoble(String numero) {
        super(numero, PRECIO_BASE);
    }

    @Override
    public String getTipo() {
        return "Doble";
    }

    @Override
    public String getCaracteristicas() {
        return "2 camas, baño privado, wifi, TV por cable";
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public void limpiar() {
        System.out.println("Limpieza estándar de la habitación " + numero);
    }

    @Override
    public void solicitarComida(String pedido) {
        System.out.println("Pedido registrado para la habitación "
                + numero + ": " + pedido);
    }
}
