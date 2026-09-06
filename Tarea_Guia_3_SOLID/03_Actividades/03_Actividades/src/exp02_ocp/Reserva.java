package exp02_ocp;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {

    private final String idReserva;
    private final LocalDateTime fechaInicio;
    private final double importeTotal;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva(String idReserva, LocalDateTime fechaInicio,
                   double importeTotal, PoliticaCancelacion politica) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.importeTotal = importeTotal;
        this.politicaCancelacion = politica;
    }

    public void setPoliticaCancelacion(PoliticaCancelacion politica) {
        this.politicaCancelacion = politica;
    }

    /** La decisión se delega por polimorfismo: esta clase ya no cambia. */
    public boolean solicitarCancelacion() {
        if (politicaCancelacion.puedeCancelar(this)) {
            double penalizacion = importeTotal * politicaCancelacion.calcularPenalizacion(this);
            System.out.printf("Reserva %s cancelada (política %s). Penalización: S/ %.2f%n",
                    idReserva, politicaCancelacion.getNombre(), penalizacion);
            return true;
        }
        System.out.printf("La política %s no permite cancelar la reserva %s.%n",
                politicaCancelacion.getNombre(), idReserva);
        return false;
    }

    public long horasHastaCheckIn() {
        return Duration.between(LocalDateTime.now(), fechaInicio).toHours();
    }

    public String getIdReserva()  { return idReserva; }
    public double getImporteTotal() { return importeTotal; }
}
