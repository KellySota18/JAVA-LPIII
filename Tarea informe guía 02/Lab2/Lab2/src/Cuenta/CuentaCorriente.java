package Cuenta;

public class CuentaCorriente extends Cuenta {
    private int retiros;

    public CuentaCorriente() {
        super();
        this.retiros = 0;
    }

    public CuentaCorriente(double saldoInicial) {
        super(saldoInicial);
        this.retiros = 0;
    }

    @Override
    public void retirar(double monto) {
        final int LIBRE_RETIROS = 3;
        final double TARIFA_TRANSACCION = 3.0;

        super.retirar(monto);
        retiros++;

        if (retiros > LIBRE_RETIROS) {
            super.retirar(TARIFA_TRANSACCION);
        }
    }

    @Override
    public void consultar() {
        retiros = 0; // Restablece el contador de retiros
    }
}