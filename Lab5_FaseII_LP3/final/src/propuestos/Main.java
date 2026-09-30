package propuestos;

/**
 * Ejercicio 3: metodo generico estatico imprimirPar.
 * Ejercicio 4: prueba del Contenedor.
 * Relaciona ademas los ejercicios 1 y 2 (Par, setters y esIgual).
 */
public class Main {

    /** Ejercicio 3: imprime cualquier Par<F, S>. */
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {

        // ---------- Ejercicio 3 ----------
        System.out.println("=== Ejercicio 3: imprimirPar ===");
        Par<String, Integer> parStringInteger = new Par<>("Edad", 25);
        Par<Double, Boolean> parDoubleBoolean = new Par<>(3.14, true);
        Par<Persona, Integer> parPersonaInteger = new Par<>(new Persona("Ana", 20), 1001);

        imprimirPar(parStringInteger);
        imprimirPar(parDoubleBoolean);
        imprimirPar(parPersonaInteger);

        // Relacion con el ejercicio 2 (esIgual con objetos Persona)
        Par<Persona, Integer> otroPar = new Par<>(new Persona("Ana", 20), 1001);
        System.out.println("\nEjercicio 2 aplicado, son iguales? "
                + parPersonaInteger.esIgual(otroPar));

        // ---------- Ejercicio 4 ----------
        System.out.println("\n=== Ejercicio 4: Contenedor<String, Integer> ===");
        Contenedor<String, Integer> notas = new Contenedor<>();
        notas.agregarPar("Ana", 18);
        notas.agregarPar("Luis", 15);
        notas.agregarPar("Marta", 20);
        notas.mostrarPares();

        System.out.println("\nobtenerPar(1): " + notas.obtenerPar(1));

        System.out.println("\nRecorrido con imprimirPar (ejercicio 3):");
        for (Par<String, Integer> p : notas.obtenerTodosLosPares()) {
            imprimirPar(p);
        }

        Par<String, Integer> buscado = new Par<>("Luis", 15);
        System.out.println("\nobtenerPar(1) es igual a " + buscado + "? "
                + notas.obtenerPar(1).esIgual(buscado));

        notas.obtenerPar(0).setSegundo(19);
        System.out.println("Tras setSegundo(19) en el par 0: " + notas.obtenerPar(0));

        try {
            notas.obtenerPar(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }

        System.out.println("\n=== Contenedor<Persona, Double> ===");
        Contenedor<Persona, Double> sueldos = new Contenedor<>();
        sueldos.agregarPar(new Persona("Carlos", 30), 2500.50);
        sueldos.agregarPar(new Persona("Sofia", 28), 3200.00);
        sueldos.mostrarPares();
    }
}
