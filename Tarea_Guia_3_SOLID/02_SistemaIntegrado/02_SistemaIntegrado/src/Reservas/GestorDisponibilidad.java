package Reservas;

import Habitaciones.Habitacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * RESPONSABILIDAD ÚNICA: resolver la disponibilidad por rango de fechas.
 * Esta lógica se extrajo de la entidad Habitacion (Experiencia 1, SRP).
 */
public class GestorDisponibilidad {

    private final List<Reserva> reservas = new ArrayList<>();

    public boolean verificarDisponibilidad(Habitacion habitacion,
                                           LocalDate fInicio, LocalDate fFin) {
        if (fInicio == null || fFin == null || !fFin.isAfter(fInicio)) {
            throw new IllegalArgumentException("Rango de fechas inválido");
        }
        for (Reserva r : reservas) {
            if (!r.isActiva()) {
                continue;
            }
            if (!r.getHabitacion().getNumero().equals(habitacion.getNumero())) {
                continue;
            }
            boolean seSolapa = fInicio.isBefore(r.getFechaFin())
                            && fFin.isAfter(r.getFechaInicio());
            if (seSolapa) {
                return false;
            }
        }
        return true;
    }

    public void registrar(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
