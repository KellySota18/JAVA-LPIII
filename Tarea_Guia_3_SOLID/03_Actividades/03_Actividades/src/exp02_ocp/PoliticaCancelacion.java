package exp02_ocp;

/**
 * Abstracción que permite extender el sistema con nuevas políticas
 * sin modificar la clase Reserva (Principio Abierto/Cerrado).
 */
public interface PoliticaCancelacion {

    boolean puedeCancelar(Reserva reserva);

    /** @return porcentaje de penalización sobre el importe total (0.0 a 1.0). */
    double calcularPenalizacion(Reserva reserva);

    String getNombre();
}
