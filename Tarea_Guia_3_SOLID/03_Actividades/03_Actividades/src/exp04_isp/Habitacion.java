package exp04_isp;

public abstract class Habitacion {

    protected final String numero;
    protected final double precioBase;

    protected Habitacion(String numero, double precioBase) {
        this.numero = numero;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecio(int dias);

    public String getNumero() { return numero; }
}
