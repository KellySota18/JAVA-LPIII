package Reservas;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override public boolean puedeCancelar(Reserva reserva) { return reserva.horasHastaCheckIn() >= 24; }
    @Override public double calcularPenalizacion(Reserva reserva) { return 0.0; }
    @Override public String getNombre() { return "FLEXIBLE"; }
}
