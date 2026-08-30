package Cuenta;

public class Cuenta {
    private double saldo;

    public Cuenta() {
        this.saldo = 0.0;
    }

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        saldo -= monto;
    }

    public void consultar() {
        // Comportamiento base vacio o por defecto
    }

    public double getSaldo() {
        return saldo;
    }
}