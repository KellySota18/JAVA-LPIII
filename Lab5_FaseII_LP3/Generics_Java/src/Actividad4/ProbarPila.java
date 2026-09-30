package Actividad4;

public class ProbarPila {

    public static void main(String[] args) {

        // PRUEBA 1: DOS PILAS IGUALES

        // Crea la primera pila.
        Pila<Integer> pila1 = new Pila<>(5);

        // Inserta los elementos.
        pila1.push(10);
        pila1.push(20);
        pila1.push(30);

        // Crea la segunda pila.
        Pila<Integer> pila2 = new Pila<>(5);

        // Inserta los mismos elementos y en el mismo orden.
        pila2.push(10);
        pila2.push(20);
        pila2.push(30);

        // Compara las dos pilas.
        System.out.println(
            "¿Pila 1 y Pila 2 son iguales?: "
            + pila1.esIgual(pila2)
        );

        // PRUEBA 2: PILAS CON DIFERENTE CONTENIDO

        Pila<Integer> pila3 = new Pila<>(5);

        pila3.push(10);
        pila3.push(20);
        pila3.push(40);

        System.out.println(
            "¿Pila 1 y Pila 3 son iguales?: "
            + pila1.esIgual(pila3)
        );

        // PRUEBA 3: PILAS CON DIFERENTE TAMAÑO

        Pila<Integer> pila4 = new Pila<>(5);

        pila4.push(10);
        pila4.push(20);

        System.out.println(
            "¿Pila 1 y Pila 4 son iguales?: "
            + pila1.esIgual(pila4)
        );

        // PRUEBA 4: MISMO CONTENIDO PERO
        // DIFERENTE ORDEN

        Pila<Integer> pila5 = new Pila<>(5);

        pila5.push(30);
        pila5.push(20);
        pila5.push(10);

        System.out.println(
            "¿Pila 1 y Pila 5 son iguales?: "
            + pila1.esIgual(pila5)
        );

        // PRUEBA 5: COMPROBAR QUE NO SE MODIFICAN

        // Antes de comparar, la pila1 tiene como tope 30.
        System.out.println(
            "Tope de pila1 antes de esIgual(): "
            + pila1.contains(30)
        );

        // Se comparan nuevamente las pilas.
        pila1.esIgual(pila2);

        // La pila1 sigue teniendo sus elementos.
        System.out.println(
            "Tope 30 sigue en pila1 despues de esIgual(): "
            + pila1.contains(30)
        );

        // PRUEBA 6: PILAS DE TIPO STRING

        Pila<String> pilaTexto1 = new Pila<>(5);

        pilaTexto1.push("Java");
        pilaTexto1.push("Genericos");
        pilaTexto1.push("Pila");

        Pila<String> pilaTexto2 = new Pila<>(5);

        pilaTexto2.push("Java");
        pilaTexto2.push("Genericos");
        pilaTexto2.push("Pila");

        System.out.println(
            "¿Las pilas String son iguales?: "
            + pilaTexto1.esIgual(pilaTexto2)
        );
    }
}