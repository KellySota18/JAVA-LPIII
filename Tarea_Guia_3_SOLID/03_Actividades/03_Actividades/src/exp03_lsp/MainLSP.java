package exp03_lsp;

import java.time.LocalDate;
import java.util.List;

/** Demostración de la Experiencia 3 (LSP). */
public class MainLSP {

    public static void main(String[] args) {
        System.out.println("===== EXPERIENCIA 3: LSP =====");

        Habitacion estandar = new HabitacionEstandar("201", 150.0);
        Habitacion suite    = new HabitacionSuite("301", 300.0);
        Habitacion deluxe   = new HabitacionDeluxe("401", 220.0);

        deluxe.ponerEnMantenimiento();   // estado, no subtipo

        List<Habitacion> habitaciones = List.of(estandar, suite, deluxe);

        new ControladorReservas().procesarLote(habitaciones,
                LocalDate.of(2026, 9, 10), LocalDate.of(2026, 9, 13));

        System.out.println("El recorrido polimórfico terminó sin excepciones: LSP cumplido.");
    }
}
