package EjercicioIII;

import java.util.Random;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;
    private Random random;

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
        this.random = new Random();
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("\n Un " + enemigo.getNombre() + " ha aparecido");

        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstadoCombate(jugador, enemigo);
            vista.mostrarOpciones();
            int opcion = vista.pedirOpcion();

            boolean turnoValido = false;

            switch (opcion) {
                case 1:
                    int danoJugador = jugador.atacar();
                    enemigo.recibirDano(danoJugador);
                    vista.mostrarMensaje(" " + jugador.getNombre() + " ataca a " + enemigo.getNombre() + " causando " + danoJugador + " de daño.");
                    turnoValido = true;
                    break;

                case 2:
                    if (jugador.getInventario().isEmpty()) {
                        vista.mostrarMensaje("no tienes nada en tu inventario");
                    } else {
                        Item objeto = jugador.getInventario().get(0); 
                        if (jugador.usarObjeto(objeto)) {
                            vista.mostrarMensaje(" Has usado " + objeto.getNombre() + " y recuperaste salud.");
                            turnoValido = true;
                        } else {
                            vista.mostrarMensaje("No se pudo usar el objeto.");
                        }
                    }
                    break;

                case 3:
                    vista.mostrarMensaje("te rendiste");
                    return;

                default:
                    vista.mostrarMensaje("Opción inválida.");
            }

            if (turnoValido && enemigo.estaVivo()) {
                accionEnemigo();
            }
        }

        if (jugador.estaVivo() && !enemigo.estaVivo()) {
            vista.mostrarMensaje("\n lo derrotaste " + enemigo.getNombre() + "Ganaste");
        } else if (!jugador.estaVivo()) {
            vista.mostrarMensaje("\nHas sido derrotado en combate...");
        }
    }

    private void accionEnemigo() {
        int decision = random.nextInt(100);
        if (decision < 75) { 
            int danoEnemigo = enemigo.atacar();
            jugador.recibirDano(danoEnemigo);
            vista.mostrarMensaje(" " + enemigo.getNombre() + " te ataca y te inflige " + danoEnemigo + " de daño.");
        } else { 
            vista.mostrarMensaje(" " + enemigo.getNombre() + " Te esta viendo");
        }
    }
}