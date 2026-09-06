package Reservas;

/**
 * Abstracción que permite agregar políticas nuevas sin modificar Reserva
 * ni el controlador (Principio Abierto/Cerrado).
 */
public interface PoliticaCancelacion {

    boolean puedeCancelar(Reserva reserva);

    /** Porcentaje de penalización sobre el importe total (0.0 a 1.0). */
    double calcularPenalizacion(Reserva reserva);

    String getNombre();
}
