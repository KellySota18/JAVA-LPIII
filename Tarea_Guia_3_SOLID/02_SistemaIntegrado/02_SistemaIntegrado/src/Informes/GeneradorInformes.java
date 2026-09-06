package Informes;

import Habitaciones.Habitacion;
import Reservas.Reserva;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * RESPONSABILIDAD ÚNICA: generar informes.
 * Esta lógica estaba antes dentro de la entidad Habitacion.
 */
public class GeneradorInformes {

    public void informeOcupacionPorTipo(List<Reserva> reservas) {
        Map<String, Integer> conteo = new LinkedHashMap<>();
        Map<String, Integer> noches = new LinkedHashMap<>();

        for (Reserva reserva : reservas) {
            if (!reserva.isActiva()) {
                continue;
            }
            Habitacion habitacion = reserva.getHabitacion();
            conteo.merge(habitacion.getTipo(), 1, Integer::sum);
            noches.merge(habitacion.getTipo(), reserva.getNoches(), Integer::sum);
        }

        System.out.println("   INFORME DE OCUPACIÓN POR TIPO DE HABITACIÓN");
        for (Map.Entry<String, Integer> entrada : conteo.entrySet()) {
            System.out.printf("   %-12s reservas: %d | noches vendidas: %d%n",
                    entrada.getKey(), entrada.getValue(), noches.get(entrada.getKey()));
        }
    }

    public void informeIngresosPorPeriodo(List<Reserva> reservas,
                                          LocalDate desde, LocalDate hasta) {
        double total = 0;
        int cantidad = 0;

        for (Reserva reserva : reservas) {
            LocalDate inicio = reserva.getFechaInicio();
            if (reserva.isActiva() && !inicio.isBefore(desde) && !inicio.isAfter(hasta)) {
                total += reserva.getImporteTotal();
                cantidad++;
            }
        }

        System.out.println("   INFORME DE INGRESOS DEL " + desde + " AL " + hasta);
        System.out.printf("   Reservas consideradas: %d | Ingresos: S/ %.2f%n", cantidad, total);
    }
}
