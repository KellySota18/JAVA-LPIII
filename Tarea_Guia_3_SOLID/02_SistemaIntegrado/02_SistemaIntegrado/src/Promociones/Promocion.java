package Promociones;

import Reservas.Reserva;

/**
 * Abstracción de promoción. Agregar una promoción nueva es crear una clase,
 * no modificar la calculadora de tarifas (Principio Abierto/Cerrado).
 */
public interface Promocion {

    boolean aplica(Reserva reserva);

    /** Descuento expresado como porcentaje (0.0 a 1.0). */
    double getDescuento();

    String getNombre();
}
