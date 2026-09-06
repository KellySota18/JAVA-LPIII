package Promociones;

import Reservas.Reserva;

public class PromocionClienteFrecuente implements Promocion {

    @Override public boolean aplica(Reserva reserva) { return reserva.getCliente().esFrecuente(); }
    @Override public double getDescuento() { return 0.15; }
    @Override public String getNombre() { return "Cliente frecuente (15%)"; }
}
