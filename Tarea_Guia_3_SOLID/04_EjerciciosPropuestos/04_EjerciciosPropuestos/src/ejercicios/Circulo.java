package ejercicios;

public class Circulo implements Forma {

    private final double radio;

    public Circulo(double radio) { this.radio = radio; }

    @Override public void dibujar()        { System.out.println("Dibujando círculo"); }
    @Override public double calcularArea() { return Math.PI * radio * radio; }
}
