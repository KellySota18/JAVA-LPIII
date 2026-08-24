import java.util.Scanner;

public class eje1_SumarArreglo {

    public static int sumarArreglo(int[] numeros) {
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        return suma;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] arreglo = new int[5];

        // Ingresar los valores del arreglo
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Ingrese el valor " + (i + 1) + ": ");
            arreglo[i] = entrada.nextInt();
        }

        // Llamar a la función para calcular la suma
        int resultado = sumarArreglo(arreglo);

        // Mostrar el resultado
        System.out.println("La suma es: " + resultado);

        entrada.close();
    }
}