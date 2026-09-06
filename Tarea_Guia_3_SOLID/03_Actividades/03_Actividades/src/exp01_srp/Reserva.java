package exp01_srp;

import java.time.LocalDate;

/**
 * Entidad que representa una reserva de habitación.
 * Experiencia 1 - Principio de Responsabilidad Única (SRP).
 */
public class Reserva {

    private final String idReserva;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public Reserva(String idReserva, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin) {
        this("R-" + System.nanoTime(), fechaInicio, fechaFin);
    }

    public String getIdReserva()      { return idReserva; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin()    { return fechaFin; }

    @Override
    public String toString() {
        return idReserva + " [" + fechaInicio + " -> " + fechaFin + "]";
    }
}
