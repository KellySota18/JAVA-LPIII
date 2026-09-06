package ejercicios;

public class Bicicleta extends Vehiculo {

    @Override
    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("La bicicleta acelera pedaleando. Velocidad: " + velocidad);
    }
}
