package Cuenta;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private double minSaldo;

    public CuentaAhorro() {
        super();
        this.tasaInteres = 0.0;
        this.minSaldo = getSaldo();
    }

    public CuentaAhorro(double saldoInicial, double tasaInteres) {
        super(saldoInicial);
        this.tasaInteres = tasaInteres;
        this.minSaldo = saldoInicial;
    }

    public void setTasaInteres(double interes) {
        this.tasaInteres = interes;
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        double saldoActual = getSaldo();
        if (saldoActual < minSaldo) {
            minSaldo = saldoActual;
        }
    }

    @Override
    public void consultar() {
        double interes = minSaldo * (tasaInteres / 100.0);
        depositar(interes);
        minSaldo = getSaldo(); // Restablece el saldo minimo para el siguiente periodo
    }
}