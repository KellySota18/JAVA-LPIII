package EjercicioIII; 

// Importa ArrayList para crear una lista dinámica de objetos.
import java.util.ArrayList;

// Importa List para declarar y manejar la lista del inventario.
import java.util.List;

// Clase que representa al jugador dentro del juego.
public class Jugador {

    // Nombre del jugador.
    private String nombre;

    // Cantidad actual de puntos de salud del jugador.
    private int salud;

    // Cantidad máxima de puntos de salud que puede recuperar el jugador.
    private int saludMaxima;

    // Nivel actual del jugador, que influye en el daño de sus ataques.
    private int nivel;

    // Lista que almacena los objetos que posee el jugador.
    private List<Item> inventario;

    // Objeto que representa el arma equipada actualmente por el jugador.
    private Item armaEquipada;

    // Constructor que inicializa los datos del jugador.
    public Jugador(String nombre, int salud, int nivel) {

        // Guarda el nombre recibido en el atributo nombre.
        this.nombre = nombre;

        // Establece la salud inicial del jugador.
        this.salud = salud;

        // Establece la salud inicial como la salud máxima.
        this.saludMaxima = salud;

        // Guarda el nivel inicial del jugador.
        this.nivel = nivel;

        // Crea una lista vacía para almacenar los objetos del inventario.
        this.inventario = new ArrayList<>();
    }

    // Devuelve el nombre del jugador.
    public String getNombre() {
        return nombre;
    }

    // Devuelve la salud actual del jugador.
    public int getSalud() {
        return salud;
    }

    // Devuelve el nivel actual del jugador.
    public int getNivel() {
        return nivel;
    }

    // Devuelve la lista de objetos del inventario.
    public List<Item> getInventario() {
        return inventario;
    }

    // Devuelve el arma que el jugador tiene equipada.
    public Item getArmaEquipada() {
        return armaEquipada;
    }

    // Permite equipar un objeto si es válido y corresponde a un arma.
    public void equiparArma(Item arma) {

        // Comprueba que el objeto no sea null y que su tipo sea "Arma".
        // equalsIgnoreCase permite comparar el texto sin distinguir mayúsculas y minúsculas.
        if (arma != null && arma.getTipo().equalsIgnoreCase("Arma")) {

            // Guarda el objeto recibido como el arma equipada del jugador.
            this.armaEquipada = arma;
        }
    }

    // Calcula y devuelve el daño que realiza el jugador al atacar.
    public int atacar() {

        // Comprueba si el jugador tiene un arma equipada.
        if (armaEquipada != null) {

            // Si tiene un arma, calcula el daño según su nivel.
            return 15 + (nivel * 5);
        }

        // Si no tiene un arma equipada, realiza un ataque básico.
        return 5 + nivel;
    }

    // Intenta utilizar un objeto del inventario y devuelve si se utilizó correctamente.
    public boolean usarObjeto(Item item) {

        // Comprueba que el objeto exista y esté dentro del inventario.
        if (item != null && inventario.contains(item)) {

            // Verifica si el objeto es una poción.
            if (item.getTipo().equalsIgnoreCase("Poción")) {

                // Comprueba si el objeto permite realizar su acción de uso.
                if (item.usarItem()) {

                    // Recupera 30 puntos de salud sin superar la salud máxima.
                    this.salud = Math.min(saludMaxima, salud + 30);

                    // Devuelve true para indicar que el objeto se utilizó correctamente.
                    return true;
                }
            }
        }

        // Devuelve false si el objeto no existe, no pertenece al inventario,
        // no es una poción o no se pudo utilizar.
        return false;
    }

    // Reduce la salud del jugador según la cantidad de daño recibido.
    public void recibirDano(int cantidad) {

        // Resta el daño recibido a la salud actual.
        this.salud -= cantidad;

        // Evita que la salud del jugador sea menor que cero.
        if (this.salud < 0) {
            this.salud = 0;
        }
    }

    // Comprueba si el jugador sigue vivo.
    public boolean estaVivo() {

        // Devuelve true si la salud es mayor que cero; de lo contrario, devuelve false.
        return salud > 0;
    }
}
