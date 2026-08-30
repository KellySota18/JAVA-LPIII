package Cuenta;

import java.util.Scanner;

public class AppBanco {
    public static void main(String[] args) {
        // Crear 5 Cuentas Corrientes y 5 Cuentas de Ahorro
        Cuenta[] cuentas = new Cuenta[10];

        for (int i = 0; i < 5; i++) {
            cuentas[i] = new CuentaCorriente(100.0); // Cuentas 0 a 4
        }
        for (int i = 5; i < 10; i++) {
            cuentas[i] = new CuentaAhorro(500.0, 2.5); // Cuentas 5 a 9 (Tasa 2.5%)
        }

        Scanner in = new Scanner(System.in);
        boolean done = false;

        System.out.println("=== SISTEMA DE GESTION BANCARIA ===");
        System.out.println("Cuentas 0-4: Cuenta Corriente | Cuentas 5-9: Cuenta Ahorro");

        while (!done) {
            System.out.print("\nD)epositar  R)etirar  C)onsultar  S)alir: ");
            String op = in.next().toUpperCase();

            if (op.equals("D") || op.equals("R")) {
                System.out.print("Ingrese numero de cuenta (0-9) y monto: ");
                int num = in.nextInt();
                double monto = in.nextDouble();

                if (num >= 0 && num < cuentas.length) {
                    if (op.equals("D")) {
                        cuentas[num].depositar(monto);
                    } else {
                        cuentas[num].retirar(monto);
                    }
                    System.out.println("Saldo de cuenta [" + num + "]: S/. " + cuentas[num].getSaldo());
                } else {
                    System.out.println("Numero de cuenta invalido.");
                }
            } 
            else if (op.equals("C")) {
                System.out.println("\n--- ESTADO DE TODAS LAS CUENTAS ---");
                for (int n = 0; n < cuentas.length; n++) {
                    cuentas[n].consultar();
                    String tipo = (cuentas[n] instanceof CuentaAhorro) ? "Ahorro" : "Corriente";
                    System.out.println("Cuenta " + n + " (" + tipo + ") - Saldo: S/. " + cuentas[n].getSaldo());
                }
            } 
            else if (op.equals("S")) {
                done = true;
                System.out.println("Gracias por usar el sistema bancario!");
            } else {
                System.out.println("Opcion no valida.");
            }
        }
        in.close();
    }
}