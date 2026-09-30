package Actividad2;

public class Pila<E> {

    private final int tamanio; // Número máximo de elementos de la pila
    private int superior;      // Ubicación del elemento superior
    private E[] elementos;     // Arreglo que almacena los elementos

    // Constructor sin argumentos.
    // Crea una pila con el tamaño predeterminado de 10 elementos.
    public Pila() {
        this(10);
    }

    // Constructor que recibe el tamaño de la pila.
    public Pila(int s) {

        // Si el tamaño recibido es mayor que cero,
        // se utiliza ese tamaño; de lo contrario, se utiliza 10.
        tamanio = s > 0 ? s : 10;

        // Al comenzar, la pila está vacía.
        superior = -1;

        // Crea el arreglo que almacenará los elementos.
        elementos = (E[]) new Object[tamanio];
    }

    // Inserta un elemento en la pila.
    public void push(E valorAMeter) {

        // Comprueba si la pila está llena.
        if (superior == tamanio - 1) {

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

    // Elimina y devuelve el elemento que se encuentra
    // en el tope de la pila.
    public E pop() {

        // Comprueba si la pila está vacía.
        if (superior == -1) {

            throw new ExcepcionPilaVacia(
                "Pila vacia, no se puede sacar"
            );
        }

        // Devuelve el elemento superior y luego disminuye superior.
        return elementos[superior--];
    }

    // Busca un elemento desde el tope hacia el fondo.
    // No modifica el estado de la pila.
    public boolean contains(E elemento) {

        // Recorre la pila desde el elemento superior
        // hasta el elemento que se encuentra en el fondo.
        for (int i = superior; i >= 0; i--) {

            // Compara el elemento buscado con el elemento actual.
            if (elementos[i].equals(elemento)) {

                // Si encuentra el elemento, devuelve true.
                return true;
            }
        }

        // Si termina el recorrido sin encontrarlo, devuelve false.
        return false;
    }
}