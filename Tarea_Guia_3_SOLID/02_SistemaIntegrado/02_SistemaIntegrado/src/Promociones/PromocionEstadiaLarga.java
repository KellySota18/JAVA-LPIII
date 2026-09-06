package Promociones;

import Reservas.Reserva;

public class PromocionEstadiaLarga implements Promocion {

    private static final int NOCHES_MINIMAS = 5;

    @Override public boolean aplica(Reserva reserva) { return reserva.getNoches() >= NOCHES_MINIMAS; }
    @Override public double getDescuento() { return 0.20; }
    @Override public String getNombre() { return "Estadía larga (20%)"; }
}
