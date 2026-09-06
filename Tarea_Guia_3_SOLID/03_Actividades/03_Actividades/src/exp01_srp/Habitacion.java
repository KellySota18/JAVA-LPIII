package exp01_srp;

/**
 * ÚNICA RESPONSABILIDAD: modelar los datos propios de la habitación.
 * La disponibilidad se delega al gestor mediante composición.
 */
public class Habitacion {

    private final String numero;
    private final String tipo;
    private final double precioBase;
    private final GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(String numero, String tipo, double precioBase) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public double calcularPrecio(String temporada) {
        return "ALTA".equalsIgnoreCase(temporada) ? precioBase * 1.30 : precioBase;
    }

    public String generarInformeOcupacion() {
        return "Habitación " + numero + " (" + tipo + ") - reservas registradas: "
                + gestorDisponibilidad.getReservas().size();
    }

    public GestorDisponibilidadHabitacion getGestorDisponibilidad() {
        return gestorDisponibilidad;
    }

    public String getNumero() { return numero; }
    public String getTipo()   { return tipo; }
}
