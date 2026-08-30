package actividad3;

public class TestAgregacion {
    public static void main(String[] args) {
        Automovil auto1 = new Automovil("ABC-123", 4, "Toyota", "Corolla");
        Motor motor1 = new Motor(1001, 6500);
        auto1.setMotor(motor1);

        Automovil auto2 = new Automovil("XYZ-789", 2, "Chevrolet", "Camaro");
        Motor motor2 = new Motor(2002, 7200);
        auto2.setMotor(motor2);

        System.out.println(auto1);
        System.out.println(auto2);

        // Se demuestra que un motor puede existir con independencia del automovil (agregacion)
        Motor motorSuelto = new Motor(3003, 5000);
        System.out.println("\nMotor independiente: " + motorSuelto);
    }
}
