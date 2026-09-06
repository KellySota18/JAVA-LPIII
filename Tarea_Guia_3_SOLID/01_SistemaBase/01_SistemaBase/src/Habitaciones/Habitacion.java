package Habitaciones;

/**
 * Entidad base del sistema de gestión de reservas.
 *
 * RESPONSABILIDAD ÚNICA: representar los datos y el estado de una habitación.
 * No almacena la colección de habitaciones ni contiene el controlador:
 * de eso se encarga ControladorHabitaciones.
 */
public abstract class Habitacion {

    protected final String numero;      // no cambia durante la vida del objeto
    protected final double precioBase;
    protected boolean disponible;

    public Habitacion(String numero, double precioBase) {
        this.numero = numero;
        this.precioBase = precioBase;
        this.disponible = true;
    }

    // ---------- MÉTODOS ABSTRACTOS ----------
    // Toda subclase está obligada a definirlos.

    public abstract String getTipo();

    public abstract String getCaracteristicas();

    public abstract double calcularPrecio();

    // ---------- ESTADO ----------

    public void ocupar() {
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }

    // ---------- GETTERS ----------

    public String getNumero() {
        return numero;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Habitación " + numero
                + " | Tipo: " + getTipo()
                + " | Precio: S/ " + String.format("%.2f", calcularPrecio())
                + " | Disponible: " + (disponible ? "Sí" : "No");
    }
}
