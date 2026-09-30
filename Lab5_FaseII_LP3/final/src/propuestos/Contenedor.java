package propuestos;
import java.util.ArrayList;
/**
 * Ejercicio 4: contenedor generico de multiples pares.
 *
 * @param <F> tipo de los primeros elementos
 * @param <S> tipo de los segundos elementos
 */
public class Contenedor<F, S> {
//Crea una lista privada y final llamada pares que almacenará objetos Par cuyos tipos serán F y S
//ArrayList<Par<F, S>>  : Indica que pares es una lista que almacena objetos de tipo
    private final ArrayList<Par<F, S>> pares = new ArrayList<>();

    /** Anade un nuevo par al contenedor. */
    public void agregarPar(F primero, S segundo) {
        pares.add(new Par<>(primero, segundo));
    }

    //Devuelve el par en la posicion indicada
    //obtenerPar(int indice) : El metodo recibe un número entero llamado indice
    public Par<F, S> obtenerPar(int indice) {

        //indice < 0 → evita índices negativos.
//indice >= pares.size() → evita acceder a una posición que no existe.
    
        if (indice < 0 || indice >= pares.size()) {
            throw new IndexOutOfBoundsException("Indice " + indice + " fuera de rango (tamanio: " + pares.size() + ")");
        }
        return pares.get(indice);
    }

    //Devuelve la lista completa de pares
    public ArrayList<Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    //Imprime todos los pares almacenados
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
