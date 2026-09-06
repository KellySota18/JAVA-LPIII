package Habitaciones;

import java.util.ArrayList;
import java.util.List;

/**
 * RESPONSABILIDAD ÚNICA: administrar la colección de habitaciones.
 * Antes estaba anidado dentro de Habitacion junto con una lista estática,
 * lo que convertía a la entidad en un "god object".
 */
public class ControladorHabitaciones {

    private final List<Habitacion> habitaciones = new ArrayList<>();

    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        System.out.println("Habitación " + habitacion.getNumero() + " registrada.");
    }

    public void listarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    public List<Habitacion> consultarDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    public Habitacion buscarPorNumero(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return habitacion;
            }
        }
        return null;
    }

    public void realizarCheckIn(String numero) {
        Habitacion habitacion = buscarPorNumero(numero);
        if (habitacion == null) {
            System.out.println("No existe la habitación " + numero);
        } else if (!habitacion.isDisponible()) {
            System.out.println("La habitación " + numero + " ya está ocupada.");
        } else {
            habitacion.ocupar();
            System.out.println("Check-in realizado en la habitación " + numero);
        }
    }

    public void realizarCheckOut(String numero) {
        Habitacion habitacion = buscarPorNumero(numero);
        if (habitacion != null) {
            habitacion.liberar();
            System.out.println("Check-out realizado; habitación " + numero + " liberada.");
        }
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}
