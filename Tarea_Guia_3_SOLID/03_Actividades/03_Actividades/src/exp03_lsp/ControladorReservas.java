package exp03_lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControladorReservas {

    /** Trabaja con el tipo base: no hay instanceof ni try/catch defensivos. */
    public void procesarReserva(Habitacion h, LocalDate fInicio, LocalDate fFin) {
        if (h.esReservable()) {
            h.reservar(fInicio, fFin);
            double total = h.calcularPrecio((int) ChronoUnit.DAYS.between(fInicio, fFin));
            System.out.printf("   Total a pagar: S/ %.2f%n", total);
        } else {
            System.out.println("Habitación " + h.getNumero() + " en mantenimiento; se omite.");
        }
    }

    public void procesarLote(List<Habitacion> habitaciones, LocalDate fIni, LocalDate fFin) {
        habitaciones.forEach(h -> procesarReserva(h, fIni, fFin));
    }
}
