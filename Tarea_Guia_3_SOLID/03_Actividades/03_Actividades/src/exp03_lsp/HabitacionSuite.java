package exp03_lsp;

public class HabitacionSuite extends Habitacion {

    public HabitacionSuite(String numero, double precioBase) {
        super(numero, precioBase);
    }

    @Override
    public double calcularPrecio(int dias) {
        return precioBase * dias * 1.45;
    }
}
