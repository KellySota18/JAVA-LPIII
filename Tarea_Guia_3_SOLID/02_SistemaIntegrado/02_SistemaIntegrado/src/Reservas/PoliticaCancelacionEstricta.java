package Reservas;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {

    @Override public boolean puedeCancelar(Reserva reserva) { return false; }
    @Override public double calcularPenalizacion(Reserva reserva) { return 1.0; }
    @Override public String getNombre() { return "ESTRICTA"; }
}
