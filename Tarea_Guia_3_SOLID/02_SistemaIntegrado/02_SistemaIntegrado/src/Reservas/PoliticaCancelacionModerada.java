package Reservas;

public class PoliticaCancelacionModerada implements PoliticaCancelacion {

    @Override public boolean puedeCancelar(Reserva reserva) { return reserva.horasHastaCheckIn() >= 72; }
    @Override public double calcularPenalizacion(Reserva reserva) { return 0.5; }
    @Override public String getNombre() { return "MODERADA"; }
}
