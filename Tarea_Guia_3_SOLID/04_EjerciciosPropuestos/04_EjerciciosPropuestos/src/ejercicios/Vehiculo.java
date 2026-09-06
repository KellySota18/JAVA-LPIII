package ejercicios;

/**
 * Ejercicio 3 (LSP).
 * Contrato: tras llamar a acelerar(incremento) con incremento >= 0,
 * la velocidad resultante es mayor o igual a la anterior y no se lanzan
 * excepciones adicionales. Toda subclase debe respetarlo.
 */
public abstract class Vehiculo {

    protected int velocidad;

    public abstract void acelerar(int incremento);

    public int getVelocidad() { return velocidad; }
}
