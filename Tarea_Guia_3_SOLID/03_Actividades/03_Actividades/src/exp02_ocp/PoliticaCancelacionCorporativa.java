package exp02_ocp;

/**
 * EXTENSIÓN: política agregada DESPUÉS del diseño original.
 * No obligó a modificar Reserva ni ControladorReservas: sólo se creó esta clase.
 */
public class PoliticaCancelacionCorporativa implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {
        return reserva.horasHastaCheckIn() >= 4;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {
        return 0.10;
    }

    @Override
    public String getNombre() { return "CORPORATIVA"; }
}
