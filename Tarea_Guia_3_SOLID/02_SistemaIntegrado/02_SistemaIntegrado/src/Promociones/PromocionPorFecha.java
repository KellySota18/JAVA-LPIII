package Promociones;

import Reservas.Reserva;
import java.time.LocalDate;

/** Promoción vigente sólo dentro de un rango de fechas configurable. */
public class PromocionPorFecha implements Promocion {

    private final String nombre;
    private final LocalDate desde;
    private final LocalDate hasta;
    private final double descuento;

    public PromocionPorFecha(String nombre, LocalDate desde, LocalDate hasta, double descuento) {
        this.nombre = nombre;
        this.desde = desde;
        this.hasta = hasta;
        this.descuento = descuento;
    }

    @Override
    public boolean aplica(Reserva reserva) {
        LocalDate inicio = reserva.getFechaInicio();
        return !inicio.isBefore(desde) && !inicio.isAfter(hasta);
    }

    @Override public double getDescuento() { return descuento; }
    @Override public String getNombre() { return nombre; }
}
