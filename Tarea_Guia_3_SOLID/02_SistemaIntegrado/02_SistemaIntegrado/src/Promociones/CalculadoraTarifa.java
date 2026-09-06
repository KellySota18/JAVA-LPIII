package Promociones;

import Reservas.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 * RESPONSABILIDAD ÚNICA: calcular el importe de una reserva.
 * Recorre las promociones registradas y aplica la más conveniente.
 */
public class CalculadoraTarifa {

    private final List<Promocion> promociones = new ArrayList<>();

    public void registrarPromocion(Promocion promocion) {
        promociones.add(promocion);
    }

    public double calcularImporte(Reserva reserva) {
        double bruto = reserva.getHabitacion().calcularPrecio() * reserva.getNoches();
        Promocion mejor = buscarMejorPromocion(reserva);
        if (mejor == null) {
            return bruto;
        }
        System.out.println("   Promoción aplicada: " + mejor.getNombre());
        return bruto * (1 - mejor.getDescuento());
    }

    private Promocion buscarMejorPromocion(Reserva reserva) {
        Promocion mejor = null;
        for (Promocion promocion : promociones) {
            if (promocion.aplica(reserva)
                    && (mejor == null || promocion.getDescuento() > mejor.getDescuento())) {
                mejor = promocion;
            }
        }
        return mejor;
    }
}
