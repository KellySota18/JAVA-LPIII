	import java.util.Scanner;

public class eje6_convertir {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("ingrese las horas: ");
        int horas = teclado.nextInt();
        
        System.out.print("ingrese los minutos: ");
        int minutos = teclado.nextInt();
        
        System.out.print("ingrese los segundos: ");
        int segundos = teclado.nextInt();

        int segundos_horas = horas * 3600;   
        int segundos_minutos = minutos * 60; 

        int totalSegundos = segundos_horas + segundos_minutos + segundos;

        System.out.println("el total es: " + totalSegundos + " segundos");
        
    }
}
