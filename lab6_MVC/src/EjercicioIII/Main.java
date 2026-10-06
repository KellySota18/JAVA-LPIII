package EjercicioIII;

public class Main {
    public static void main(String[] args) {

        Jugador jugador = new Jugador("Heroe", 100, 1);
        
        Item espada = new Item("Espada de Hierro", 1, "Arma", "Una espada ");
        Item pocion = new Item("Poción de Curación", 2, "Poción", "Restaura 30 de vida");
        
        jugador.getInventario().add(espada);
        jugador.getInventario().add(pocion);
        jugador.equiparArma(espada);

        Enemigo enemigo = new Enemigo("Goblin", 50, 1, "Monstruo");

        CombateView vista = new CombateView();
        CombateController controladorCombate = new CombateController(jugador, enemigo, vista);

        controladorCombate.iniciarCombate();
    }
}