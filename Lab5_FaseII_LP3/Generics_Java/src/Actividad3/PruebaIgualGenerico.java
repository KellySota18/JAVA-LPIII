package Actividad3;

public class PruebaIgualGenerico {

    public static void main(String[] args) {

        // PRUEBA CON OBJECT

        // Crea dos objetos de tipo Object.
        Object objeto1 = new Object();
        Object objeto2 = new Object();

        // Compara los dos objetos.
        System.out.println(
            "Object: " + IgualGenerico.esIgualA(objeto1, objeto2)
        );

        // PRUEBA CON INTEGER

        // Crea dos objetos Integer con el mismo valor.
        Integer numero1 = 10;
        Integer numero2 = 10;

        // Compara los dos Integer.
        System.out.println(
            "Integer: " + IgualGenerico.esIgualA(numero1, numero2)
        );

        // PRUEBA CON STRING

        // Crea dos String con el mismo contenido.
        String texto1 = "Java";
        String texto2 = "Java";

        // Compara los dos String.
        System.out.println(
            "String: " + IgualGenerico.esIgualA(texto1, texto2)
        );

        // PRUEBA CON null

        // Se intenta comparar un valor null con un String.
        System.out.println(
            "null: " + IgualGenerico.esIgualA(null, "Java")
        );
    }
}