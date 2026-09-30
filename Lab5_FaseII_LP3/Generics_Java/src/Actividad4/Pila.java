package Actividad4;

public class Pila<E> {

    private final int tamanio; // Capacidad maxima de la pila
    private int superior;      // Posicion del elemento superior
    private E[] elementos;     // Arreglo que almacena los elementos

    // Constructor sin argumentos.
    // Crea una pila con capacidad para 10 elementos.
    public Pila() {
        this(10);
    }

    // Constructor que recibe el tamaño de la pila.
    public Pila(int s) {

        // Si el tamaño es mayor que cero, utiliza s.
        // Si no, utiliza 10.
        tamanio = s > 0 ? s : 10;

        // La pila comienza vacia.
        superior = -1;

        // Crea el arreglo que almacenara los elementos.
        elementos = (E[]) new Object[tamanio];
    }

    // METODO push

    // Inserta un elemento en la parte superior de la pila.
    public void push(E valorAMeter) {

        // Comprueba si la pila esta llena.
        if (superior == tamanio - 1) {

            // Lanza una excepcion si no hay espacio.
            throw new ExcepcionPilaLlena(
                String.format(
                    "La Pila esta llena, no se puede meter %s",
                    valorAMeter
                )
            );
        }

        // Incrementa superior y almacena el elemento.
        elementos[++superior] = valorAMeter;
    }

    // METODO pop

    // Extrae y devuelve el elemento que se encuentra
    // en la parte superior de la pila.
    public E pop() {

        // Comprueba si la pila esta vacia.
        if (superior == -1) {

            // Lanza una excepcion si no hay elementos.
            throw new ExcepcionPilaVacia(
                "Pila vacia, no se puede sacar"
            );
        }

        // Devuelve el elemento superior
        // y disminuye el indice superior.
        return elementos[superior--];
    }

    // METODO contains

    // Busca un elemento desde el tope hacia el fondo.
    // No modifica la pila.
    public boolean contains(E elemento) {

        // Recorre desde el elemento superior
        // hasta el primer elemento.
        for (int i = superior; i >= 0; i--) {

            // Compara utilizando equals().
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }

        // Si no encuentra el elemento.
        return false;
    }

    // METODO esIgual

    // Compara esta pila con otra pila.
    // Devuelve true si tienen el mismo tamaño,
    // los mismos elementos y en el mismo orden.
    public boolean esIgual(Pila<E> otraPila) {

        // Comprueba si la otra pila es null.
        if (otraPila == null) {
            return false;
        }

        // Compara la cantidad de elementos.
        // superior representa la posicion del ultimo elemento.
        // Por ejemplo:
        // superior = 2 significa que hay 3 elementos.
        if (superior != otraPila.superior) {
            return false;
        }

        // Recorre todos los elementos de las dos pilas.
        for (int i = 0; i <= superior; i++) {

            // Compara los elementos de la misma posicion.
            if (!elementos[i].equals(otraPila.elementos[i])) {

                // Si algun elemento es diferente,
                // las pilas no son iguales.
                return false;
            }
        }

        // Si tienen el mismo tamaño y todos los elementos
        // son iguales y estan en el mismo orden.
        return true;
    }
}
