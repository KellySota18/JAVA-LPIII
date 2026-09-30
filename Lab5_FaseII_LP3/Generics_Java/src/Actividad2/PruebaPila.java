package Actividad2;

public class PruebaPila {

    public static void main(String[] args) {

        // Crea una pila de tipo Integer con capacidad para 5 elementos.
        Pila<Integer> pila = new Pila<>(5);

        // Inserta elementos en la pila.
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);

        System.out.println("Elementos insertados en la pila.");

        // Busca un elemento que sí existe.
        System.out.println(
            "¿La pila contiene 30?: " + pila.contains(30)
        );

        // Busca un elemento que no existe.
        System.out.println(
            "¿La pila contiene 50?: " + pila.contains(50)
        );

        // Comprueba nuevamente que la pila no ha sido modificada.
        System.out.println(
            "¿La pila sigue conteniendo 40?: " + pila.contains(40)
        );

        // Ahora extrae un elemento para comprobar pop().
        System.out.println(
            "Elemento retirado: " + pila.pop()
        );

        // Comprueba que 40 ya no está en la pila.
        System.out.println(
            "¿La pila contiene 40?: " + pila.contains(40)
        );
    }
}