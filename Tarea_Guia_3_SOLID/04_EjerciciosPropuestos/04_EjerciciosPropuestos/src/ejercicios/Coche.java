package ejercicios;

public class Coche extends Vehiculo implements Motorizado {

    @Override
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("El coche acelera usando el motor. Velocidad: " + velocidad);
    }

    @Override
    public void encenderMotor() {
        System.out.println("Motor encendido.");
    }
}
