package Reservas;

import Clientes.Cliente;
import Habitaciones.Habitacion;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Entidad reserva. La regla de cancelación NO está aquí:
 * se delega a la política asociada (Principio Abierto/Cerrado).
 */
public class Reserva {

    private final String idReserva;
    private final Cliente cliente;
    private final Habitacion habitacion;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private double importeTotal;
    private PoliticaCancelacion politicaCancelacion;
    private boolean activa = true;

    public Reserva(String idReserva, Cliente cliente, Habitacion habitacion,
                   LocalDate fechaInicio, LocalDate fechaFin,
                   PoliticaCancelacion politicaCancelacion) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politicaCancelacion = politicaCancelacion;
    }

    public int getNoches() {
        return (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public long horasHastaCheckIn() {
        return Duration.between(LocalDateTime.now(), fechaInicio.atStartOfDay()).toHours();
    }

    public void anular() {
        this.activa = false;
    }

    public String            getIdReserva()   { return idReserva; }
    public Cliente           getCliente()     { return cliente; }
    public Habitacion        getHabitacion()  { return habitacion; }
    public LocalDate         getFechaInicio() { return fechaInicio; }
    public LocalDate         getFechaFin()    { return fechaFin; }
    public double            getImporteTotal(){ return importeTotal; }
    public boolean           isActiva()       { return activa; }
    public PoliticaCancelacion getPoliticaCancelacion() { return politicaCancelacion; }

    public void setImporteTotal(double importeTotal) { this.importeTotal = importeTotal; }
    public void setPoliticaCancelacion(PoliticaCancelacion p) { this.politicaCancelacion = p; }

    @Override
    public String toString() {
        return idReserva + " | " + cliente.getNombre()
                + " | Hab. " + habitacion.getNumero()
                + " | " + fechaInicio + " a " + fechaFin
                + " | S/ " + String.format("%.2f", importeTotal)
                + " | " + (activa ? "activa" : "cancelada");
    }
}
