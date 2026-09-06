package Reservas;

/**
 * EXTENSIÓN: política añadida después. No obligó a modificar
 * ninguna clase existente; sólo se creó este archivo.
 */
public class PoliticaCancelacionCorporativa implements PoliticaCancelacion {

    @Override public boolean puedeCancelar(Reserva reserva) { return reserva.horasHastaCheckIn() >= 4; }
    @Override public double calcularPenalizacion(Reserva reserva) { return 0.10; }
    @Override public String getNombre() { return "CORPORATIVA"; }
}
