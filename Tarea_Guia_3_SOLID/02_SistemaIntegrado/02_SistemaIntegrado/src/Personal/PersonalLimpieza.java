package Personal;

import Habitaciones.ServicioLimpieza;

/**
 * Personal de limpieza del hotel. Depende de la interfaz ServicioLimpieza,
 * no de un tipo concreto de habitación.
 */
public class PersonalLimpieza {

    private final String codigo;
    private final String nombre;
    private int habitacionesAsignadas;

    public PersonalLimpieza(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.habitacionesAsignadas = 0;
    }

    public void atender(ServicioLimpieza habitacion) {
        habitacion.limpiar();
        habitacionesAsignadas++;
    }

    public int    getCargaTrabajo() { return habitacionesAsignadas; }
    public String getCodigo()       { return codigo; }
    public String getNombre()       { return nombre; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | habitaciones atendidas: " + habitacionesAsignadas;
    }
}
