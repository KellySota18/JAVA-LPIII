package EjercicioIII; 

// Importa Random para generar números aleatorios.
import java.util.Random;

// Clase Controlador: administra la lógica y las acciones del combate.
public class CombateController {

    // Objeto que representa al jugador que participa en el combate.
    private Jugador jugador;

    // Objeto que representa al enemigo contra el que se combate.
    private Enemigo enemigo;

    // Objeto encargado de mostrar mensajes y solicitar opciones al usuario.
    private CombateView vista;

    // Generador de números aleatorios para decidir las acciones del enemigo.
    private Random random;

    // Constructor que recibe al jugador, al enemigo y a la vista.
    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {

        // Guarda la referencia del jugador recibido.
        this.jugador = jugador;

        // Guarda la referencia del enemigo recibido.
        this.enemigo = enemigo;

        // Guarda la referencia de la vista recibida.
        this.vista = vista;

        // Inicializa el generador de números aleatorios.
        this.random = new Random();
    }

    // Método que inicia y controla todo el combate.
    public void iniciarCombate() {

        // Informa al usuario que ha aparecido un enemigo.
        vista.mostrarMensaje("\n Un " + enemigo.getNombre() + " ha aparecido");

        // Repite el combate mientras el jugador y el enemigo sigan vivos.
        while (jugador.estaVivo() && enemigo.estaVivo()) {

            // Muestra el estado actual del jugador y del enemigo.
            vista.mostrarEstadoCombate(jugador, enemigo);

            // Muestra las opciones de acción disponibles.
            vista.mostrarOpciones();

            // Solicita al usuario que seleccione una opción.
            int opcion = vista.pedirOpcion();

            // Indica si la acción del jugador fue válida y debe permitir el turno del enemigo.
            boolean turnoValido = false;

            // Evalúa la opción seleccionada por el jugador.
            switch (opcion) {

                // Opción 1: el jugador ataca al enemigo.
                case 1:

                    // Calcula el daño que realiza el jugador.
                    int danoJugador = jugador.atacar();

                    // Reduce la salud del enemigo según el daño recibido.
                    enemigo.recibirDano(danoJugador);

                    // Muestra el mensaje del ataque y el daño causado.
                    vista.mostrarMensaje(" " + jugador.getNombre() + " ataca a " + enemigo.getNombre() + " causando " + danoJugador + " de daño.");

                    // Marca el turno como válido para permitir la acción del enemigo.
                    turnoValido = true;

                    // Finaliza este caso del switch.
                    break;

                // Opción 2: el jugador intenta usar un objeto del inventario.
                case 2:

                    // Comprueba si el inventario del jugador está vacío.
                    if (jugador.getInventario().isEmpty()) {

                        // Informa que no hay objetos disponibles.
                        vista.mostrarMensaje("no tienes nada en tu inventario");

                    } else {

                        // Obtiene el primer objeto de la lista del inventario.
                        Item objeto = jugador.getInventario().get(0);

                        // Intenta utilizar el objeto seleccionado.
                        if (jugador.usarObjeto(objeto)) {

                            // Informa que el objeto se utilizó y que se recuperó salud.
                            vista.mostrarMensaje(" Has usado " + objeto.getNombre() + " y recuperaste salud.");

                            // Marca el turno como válido para permitir la acción del enemigo.
                            turnoValido = true;

                        } else {

                            // Informa que no fue posible utilizar el objeto.
                            vista.mostrarMensaje("No se pudo usar el objeto.");
                        }
                    }

                    // Finaliza este caso del switch.
                    break;

                // Opción 3: el jugador decide rendirse.
                case 3:

                    // Muestra un mensaje indicando que el jugador se rindió.
                    vista.mostrarMensaje("te rendiste");

                    // Finaliza inmediatamente el método y termina el combate.
                    return;

                // Se ejecuta cuando el usuario ingresa una opción diferente de 1, 2 o 3.
                default:

                    // Informa que la opción ingresada no es válida.
                    vista.mostrarMensaje("Opción inválida.");

                    // Finaliza el caso predeterminado.
                    break;
            }

            // Comprueba si el turno fue válido y si el enemigo continúa vivo.
            if (turnoValido && enemigo.estaVivo()) {

                // Permite que el enemigo realice su acción.
                accionEnemigo();
            }
        }

        // Comprueba si el jugador sigue vivo y el enemigo fue derrotado.
        if (jugador.estaVivo() && !enemigo.estaVivo()) {

            // Muestra el mensaje de victoria del jugador.
            vista.mostrarMensaje("\n lo derrotaste " + enemigo.getNombre() + "Ganaste");

        // Comprueba si el jugador fue derrotado.
        } else if (!jugador.estaVivo()) {

            // Muestra el mensaje de derrota.
            vista.mostrarMensaje("\nHas sido derrotado en combate...");
        }
    }

    // Método privado que controla la acción del enemigo durante su turno.
    private void accionEnemigo() {

        // Genera un número aleatorio entre 0 y 99.
        int decision = random.nextInt(100);

        // Si el número es menor que 75, el enemigo decide atacar.
        if (decision < 75) {

            // Calcula el daño que realizará el enemigo.
            int danoEnemigo = enemigo.atacar();

            // Aplica el daño recibido a la salud del jugador.
            jugador.recibirDano(danoEnemigo);

            // Muestra el mensaje del ataque y el daño causado al jugador.
            vista.mostrarMensaje(" " + enemigo.getNombre() + " te ataca y te inflige " + danoEnemigo + " de daño.");

        } else {

            // Si el número es 75 o mayor, el enemigo no ataca.
            vista.mostrarMensaje(" " + enemigo.getNombre() + " Te esta viendo");
        }
    }
}
