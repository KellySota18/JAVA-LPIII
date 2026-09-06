package ejercicios;

/** EXTENSIÓN: se agrega sin modificar Forma, Circulo, Rectangulo ni Lienzo. */
public class Triangulo implements Forma {

    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override public void dibujar()        { System.out.println("Dibujando triángulo"); }
    @Override public double calcularArea() { return base * altura / 2; }
}
