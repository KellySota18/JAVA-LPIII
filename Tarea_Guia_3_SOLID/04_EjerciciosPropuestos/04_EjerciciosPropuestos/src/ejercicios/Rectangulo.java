package ejercicios;

public class Rectangulo implements Forma {

    private final double base;
    private final double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override public void dibujar()        { System.out.println("Dibujando rectángulo"); }
    @Override public double calcularArea() { return base * altura; }
}
