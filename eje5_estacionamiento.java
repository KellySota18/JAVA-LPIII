import java.util.Scanner;

public class eje5_estacionamiento {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("ingrese las horas: ");
        double horas = teclado.nextDouble();
        double total = 0;
        
        if (horas <= 1) {
            total = 3; 
        } else {

            total = 3 + (horas - 1) * 0.50; 
        }
        
        if (total > 12) {
            total = 12;
        }
        
        System.out.println("total a pagar es: " + total);
        
    }
}
