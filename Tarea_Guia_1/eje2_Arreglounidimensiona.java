import java.util.Scanner;

// Declaramos la clase principal
public class eje2_Arreglounidimensiona {

    // Método principal
    public static void main(String[] args) {

        // Creamos un objeto Scanner para leer datos
        Scanner entrada = new Scanner(System.in);

        // Creamos un arreglo de 10 posiciones
        int[] numeros = new int[10];

        // Pedimos los 10 números al usuario
        for (int i = 0; i < numeros.length; i++) {

            // Mostramos qué número debe ingresar
            System.out.print("Ingrese el número " + (i + 1) + ": ");

            int numero = entrada.nextInt();

            // Verificamos que sea mayor que el número anterior
            if (i > 0) {

                while (numero <= numeros[i - 1]) {

                    System.out.println("El numero debe ser mayor que "
                            + numeros[i - 1]);

                    System.out.print("Ingrese nuevamente el número "
                            + (i + 1) + ": ");

                    numero = entrada.nextInt();
                }
            }

            // Guardamos el número válido en el arreglo
            numeros[i] = numero;
        }

        // Mostramos los números ingresados
        System.out.println("\nNúmeros ingresados:");

        for (int i = 0; i < numeros.length; i++) {

            System.out.println("Posición " + i + ": " + numeros[i]);
        }

        // Cerramos el Scanner
        entrada.close();
    }
}