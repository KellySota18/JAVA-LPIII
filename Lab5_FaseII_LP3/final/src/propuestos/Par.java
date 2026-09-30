package propuestos;

import java.util.Objects;

/**
 * Ejercicios 1 y 2: clase generica Par con dos parametros de tipo.
 *
 * @param <F> tipo del primer elemento
 * @param <S> tipo del segundo elemento
 */
public class Par<F, S> {

    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    /** Devuelve true si ambos pares tienen los mismos valores en el mismo orden. */
    public boolean esIgual(Par<F, S> otroPar) {
        if (otroPar == null) {
            return false;
        }
        return Objects.equals(primero, otroPar.getPrimero())
                && Objects.equals(segundo, otroPar.getSegundo());
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
}
