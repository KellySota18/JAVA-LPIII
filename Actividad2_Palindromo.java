import java.util.Scanner;

public class Actividad2_Palindromo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Pedir un número al usuario
        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();

        // Guardar el número original
        int original = numero;

        // Variable para guardar el número invertido
        int inverso = 0;

        // Invertir el número
        while (numero != 0) {

            // Obtener el último dígito y agregarlo al inverso
            inverso = inverso * 10 + (numero % 10);

            // Eliminar el último dígito del número
            numero /= 10;
        }

        // Comparar el número original con el inverso
        if (original == inverso) {
            System.out.println(original + " es un palíndromo.");
        } else {
            System.out.println(original + " no es un palíndromo.");
        }

        scanner.close();
    }
}