package exp04_isp;

/** Sólo implementa el rol que realmente presta: nada de métodos vacíos. */
public class HabitacionEstandar extends Habitacion implements IServicioLimpieza {

    public HabitacionEstandar(String numero, double precioBase) {
        super(numero, precioBase);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza programada para la habitación estándar " + numero);
    }

    @Override
    public double calcularPrecio(int dias) {
        return precioBase * dias;
    }
}
