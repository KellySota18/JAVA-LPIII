package exp01_srp;

import java.time.LocalDate;

/** Demostración de la Experiencia 1 (SRP). */
public class MainSRP {

    public static void main(String[] args) {
        System.out.println("===== EXPERIENCIA 1: SRP =====");

        ControladorReservas controlador = new ControladorReservas();
        Habitacion h101 = new Habitacion("101", "Doble", 180.00);
        controlador.registrarHabitacion(h101);

        LocalDate inicio = LocalDate.of(2026, 9, 10);
        LocalDate fin    = LocalDate.of(2026, 9, 14);

        controlador.crearReserva("C-001", "101", inicio, fin);
        controlador.crearReserva("C-002", "101", inicio.plusDays(2), fin.plusDays(2));

        System.out.println(h101.generarInformeOcupacion());
        System.out.printf("Precio en temporada alta: S/ %.2f%n", h101.calcularPrecio("ALTA"));

        controlador.cancelarReserva("101", inicio, fin);
        System.out.println(h101.generarInformeOcupacion());
    }
}
