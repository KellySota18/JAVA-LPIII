package Actividad;

public class PruebaMetodoGenerico {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {

        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }

        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, 
    		int subindiceSuperior) throws InvalidSubscriptException {

        if (subindiceInferior < 0 || subindiceInferior >= arregloEntrada.length || 
        		subindiceSuperior < 0 || subindiceSuperior >= arregloEntrada.length || 
        		subindiceSuperior <= subindiceInferior) {

            throw new InvalidSubscriptException();
        }

        int cantidadElementos = 0;

        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            cantidadElementos++;
        }

        System.out.println();

        return cantidadElementos;
    }

    public static void main(String[] args) {

        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {
            1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7
        };

        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger);

        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble);

        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter);

        System.out.println("\nElementos seleccionados de arregloInteger:");

        try {
            int cantidad = imprimirArreglo(arregloInteger, 1, 4);

            System.out.println("Cantidad de elementos impresos: " + cantidad);

        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nElementos seleccionados de arregloDouble:");

        try {
            int cantidad = imprimirArreglo(arregloDouble, 2, 5);

            System.out.println("Cantidad de elementos impresos: " + cantidad);

        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nElementos seleccionados de arregloCharacter:");

        try {
            int cantidad = imprimirArreglo(arregloCharacter, 0, 2);

            System.out.println("Cantidad de elementos impresos: " + cantidad);

        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // PRUEBA DE LA EXCEPCIÓN

        System.out.println("\nPrueba de índice inválido:");

        try {
            // 6 está fuera del rango de arregloInteger
            imprimirArreglo(arregloInteger, 2, 6);

        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}