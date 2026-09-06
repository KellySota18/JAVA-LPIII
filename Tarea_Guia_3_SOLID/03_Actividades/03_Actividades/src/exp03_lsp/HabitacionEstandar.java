package exp03_lsp;

public class HabitacionEstandar extends Habitacion {

    public HabitacionEstandar(String numero, double precioBase) {
        super(numero, precioBase);
    }

    @Override
    public double calcularPrecio(int dias) {
        return precioBase * dias;
    }
}
