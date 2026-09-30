package propuestos;

import java.util.ArrayList;

/**
 * Ejercicio 4: contenedor generico de multiples pares.
 *
 * @param <F> tipo de los primeros elementos
 * @param <S> tipo de los segundos elementos
 */
public class Contenedor<F, S> {

    private final ArrayList<Par<F, S>> pares = new ArrayList<>();

    /** Anade un nuevo par al contenedor. */
    public void agregarPar(F primero, S segundo) {
        pares.add(new Par<>(primero, segundo));
    }

    /** Devuelve el par en la posicion indicada. */
    public Par<F, S> obtenerPar(int indice) {
        if (indice < 0 || indice >= pares.size()) {
            throw new IndexOutOfBoundsException(
                    "Indice " + indice + " fuera de rango (tamanio: " + pares.size() + ")");
        }
        return pares.get(indice);
    }

    /** Devuelve la lista completa de pares. */
    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    /** Imprime todos los pares almacenados. */
    public void mostrarPares() {
        if (pares.isEmpty()) {
            System.out.println("El contenedor esta vacio.");
            return;
        }
        for (int i = 0; i < pares.size(); i++) {
            System.out.println(i + ": " + pares.get(i));
        }
    }
}
