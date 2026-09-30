package Actividad3;

public class IgualGenerico {

    // Método genérico esIgualA.
    // Recibe dos objetos de cualquier tipo y los compara utilizando el método equals()
    public static <T> boolean esIgualA(T objeto1, T objeto2) {

        // Compara los dos objetos utilizando equals()
        return objeto1.equals(objeto2);
    }
}