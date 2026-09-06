package Habitaciones;

/**
 * Habitación individual: sólo ofrece servicio de limpieza.
 */
public class HabitacionIndividual extends Habitacion implements ServicioLimpieza {

    private static final double PRECIO_BASE = 120.0;

    public HabitacionIndividual(String numero) {
        super(numero, PRECIO_BASE);
    }

    @Override
    public String getTipo() {
        return "Individual";
    }

    @Override
    public String getCaracteristicas() {
        return "1 cama simple, baño privado, wifi";
    }

    @Override
    public double calcularPrecio() {
        return precioBase;
    }

    @Override
    public void limpiar() {
        System.out.println("Limpieza estándar de la habitación " + numero);
    }
}
