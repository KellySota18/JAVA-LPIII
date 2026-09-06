package ejercicios;

/** Ejercicio 1 (SRP): responsabilidad única de calcular el pago. */
public class CalculadoraPago {

    private static final double TASA_AFP = 0.13;

    public double calcularPagoMensual(Empleado empleado) {
        double bruto = empleado.getSalarioAnual() / 12;
        return bruto - (bruto * TASA_AFP);
    }
}
