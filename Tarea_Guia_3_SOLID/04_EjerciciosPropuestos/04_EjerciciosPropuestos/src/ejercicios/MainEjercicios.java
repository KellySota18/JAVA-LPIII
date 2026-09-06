package ejercicios;

import java.util.List;

/** Ejecuta los cuatro ejercicios propuestos de la guía. */
public class MainEjercicios {

    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
    }

    static void ejercicio1() {
        System.out.println("----- Ejercicio 1: SRP -----");
        Empleado empleado = new Empleado("Ana Quispe", 42000, "Finanzas");
        double pago = new CalculadoraPago().calcularPagoMensual(empleado);
        System.out.printf("%s (%s) - pago mensual: S/ %.2f%n",
                empleado.getNombre(), empleado.getDepartamento(), pago);
    }

    static void ejercicio2() {
        System.out.println("----- Ejercicio 2: OCP -----");
        List<Forma> formas = List.of(new Circulo(3), new Rectangulo(4, 5), new Triangulo(6, 2));
        new Lienzo().dibujarTodo(formas);
    }

    static void ejercicio3() {
        System.out.println("----- Ejercicio 3: LSP -----");
        List<Vehiculo> vehiculos = List.of(new Coche(), new Bicicleta());
        vehiculos.forEach(v -> v.acelerar(20));
        System.out.println("Ambas subclases respetan el contrato: LSP cumplido.");
    }

    static void ejercicio4() {
        System.out.println("----- Ejercicio 4: ISP -----");
        List<Imprimible> dispositivos = List.of(new Impresora(), new ImpresoraMultifuncional());
        dispositivos.forEach(d -> d.imprimir("Informe de ocupación 2026"));

        for (Imprimible d : dispositivos) {
            if (d instanceof Escaneable escaner) {
                System.out.println("Resultado: " + escaner.escanear());
            }
        }
    }
}
