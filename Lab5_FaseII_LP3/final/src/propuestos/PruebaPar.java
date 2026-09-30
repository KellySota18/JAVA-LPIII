package propuestos;

/** Ejercicio 2: prueba del metodo esIgual. */
public class PruebaPar {

    public static void main(String[] args) {

        Par<String, Integer> par1 = new Par<>("Juan", 20);
        Par<String, Integer> par2 = new Par<>("Juan", 20);
        Par<String, Integer> par3 = new Par<>("Pedro", 25);

        System.out.println("Par 1: " + par1);
        System.out.println("Par 2: " + par2);
        System.out.println("Par 3: " + par3);

        System.out.println("Par 1 y Par 2 son iguales: " + par1.esIgual(par2));
        System.out.println("Par 1 y Par 3 son iguales: " + par1.esIgual(par3));
    }
}
