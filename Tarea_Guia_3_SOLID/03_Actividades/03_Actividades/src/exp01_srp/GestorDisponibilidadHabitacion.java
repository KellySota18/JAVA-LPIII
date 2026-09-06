package exp01_srp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ÚNICA RESPONSABILIDAD: gestionar la disponibilidad de una habitación.
 * Contiene toda la lógica de fechas que antes vivía dentro de Habitacion.
 */
public class GestorDisponibilidadHabitacion {

    private final List<Reserva> reservas = new ArrayList<>();

    public boolean verificarDisponibilidad(LocalDate fInicio, LocalDate fFin) {
        if (fInicio == null || fFin == null || fFin.isBefore(fInicio)) {
            throw new IllegalArgumentException("Rango de fechas inválido");
        }
        for (Reserva r : reservas) {
            boolean seSolapa = !fFin.isBefore(r.getFechaInicio())
                            && !fInicio.isAfter(r.getFechaFin());
            if (seSolapa) {
                return false;
            }
        }
        return true;
    }

    public void marcarComoReservada(LocalDate fInicio, LocalDate fFin) {
        if (!verificarDisponibilidad(fInicio, fFin)) {
            throw new IllegalStateException("La habitación ya está ocupada en ese rango");
        }
        reservas.add(new Reserva(fInicio, fFin));
    }

    public void marcarComoDisponible(LocalDate fInicio, LocalDate fFin) {
        reservas.removeIf(r -> r.getFechaInicio().equals(fInicio)
                            && r.getFechaFin().equals(fFin));
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }
}
