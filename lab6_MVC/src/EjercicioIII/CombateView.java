package EjercicioIII;

import java.util.Scanner;

public class CombateView {
    private Scanner scanner;

    public CombateView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n COMBATE ");
        System.out.println("JUGADOR: " + jugador.getNombre() + " (Nvl " + jugador.getNivel() + ") | HP: " + jugador.getSalud());
        System.out.println("ENEMIGO: " + enemigo.getNombre() + " (" + enemigo.getTipo() + " - Nvl " + enemigo.getNivel() + ") | HP: " + enemigo.getSalud());

    }

    public void mostrarOpciones() {
        System.out.println("1. Atacar");
        System.out.println("2. Usar Objeto");
        System.out.println("3. Huir");
        System.out.print("Selecciona tu acción: ");
    }

    public int pedirOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa una opción válida: ");
            scanner.next();
        }
        int op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}