package actividad4;

public class TestComposicion {
    public static void main(String[] args) {
        Persona p1 = new Persona(1, "Kelly", "Mamani");
        Persona p2 = new Persona(2, "Ana", "Torres");

        p1.getCuenta().setSaldo(500.0);
        p2.getCuenta().setSaldo(1200.0);

        System.out.println(p1);
        System.out.println(p2);
    }
}
