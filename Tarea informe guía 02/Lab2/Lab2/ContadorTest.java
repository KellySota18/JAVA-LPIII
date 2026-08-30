package actividad2;

public class ContadorTest {
    public static void main(String[] args) {
        Contador c1, c2;

        System.out.println(Contador.acumulador());
        c1 = new Contador(3);
        c2 = new Contador(10);
        c1.inc();
        c1.inc();
        c2.inc();
        System.out.println(c1.getValor());
        System.out.println(c2.getValor());
        System.out.println(Contador.acumulador);

        System.out.println("\n=== Prueba del constructor por defecto (usa VALOR_INICIAL) ===");
        Contador c3 = new Contador();
        System.out.println("Valor de c3 (debe ser 10): " + c3.getValor());

        System.out.println("\n=== Variables de clase agregadas ===");
        System.out.println("Contadores creados: " + Contador.getnContadores());
        System.out.println("Valor inicial del ultimo contador creado: " + Contador.getUltimoContador());
    }
}
