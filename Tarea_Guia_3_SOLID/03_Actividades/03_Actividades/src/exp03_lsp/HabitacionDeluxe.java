package exp03_lsp;

public class HabitacionDeluxe extends Habitacion {

    public HabitacionDeluxe(String numero, double precioBase) {
        super(numero, precioBase);
    }

    @Override
    public double calcularPrecio(int dias) {
        return precioBase * dias * 1.20;
    }
}
