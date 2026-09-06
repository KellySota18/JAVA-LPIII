package exp03_lsp;

import java.time.LocalDate;

/**
 * Clase base abstracta. Define un contrato que TODA subclase puede cumplir:
 * el mantenimiento se modela como ESTADO y no como subtipo, de modo que
 * ninguna subclase necesita lanzar UnsupportedOperationException.
 */
public abstract class Habitacion {

    protected final String numero;
    protected final double precioBase;
    protected boolean disponibleParaReserva = true;

    protected Habitacion(String numero, double precioBase) {
        this.numero = numero;
        this.precioBase = precioBase;
    }

    public boolean esReservable() {
        return disponibleParaReserva;
    }

    public void ponerEnMantenimiento() { this.disponibleParaReserva = false; }
    public void liberarMantenimiento() { this.disponibleParaReserva = true;  }

    /**
     * Postcondición garantizada para toda subclase:
     * si esReservable() es true, la reserva queda registrada; en caso contrario
     * la operación se omite de forma previsible, sin excepciones.
     */
    public void reservar(LocalDate fInicio, LocalDate fFin) {
        if (!esReservable()) {
            System.out.println("Habitación " + numero + " no disponible; se omite la reserva.");
            return;
        }
        System.out.println("Habitación " + numero + " reservada del " + fInicio + " al " + fFin);
    }

    /** Cada subtipo aporta su tarifa sin alterar la semántica del método. */
    public abstract double calcularPrecio(int dias);

    public String getNumero() { return numero; }
}
