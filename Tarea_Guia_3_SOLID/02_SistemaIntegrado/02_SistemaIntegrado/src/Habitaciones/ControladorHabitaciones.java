package Habitaciones;

import java.util.ArrayList;
import java.util.List;

/**
 * RESPONSABILIDAD ÚNICA: administrar el catálogo de habitaciones del hotel.
 */
public class ControladorHabitaciones {

    private final List<Habitacion> habitaciones = new ArrayList<>();

    public void registrarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        System.out.println("Habitación " + habitacion.getNumero()
                + " (" + habitacion.getTipo() + ") registrada.");
    }

    public void listarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println("   " + habitacion);
        }
    }

    public Habitacion buscarPorNumero(String numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numero)) {
                return habitacion;
            }
        }
        return null;
    }

    public List<Habitacion> buscarPorTipo(String tipo) {
        List<Habitacion> resultado = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(habitacion);
            }
        }
        return resultado;
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
