package Habitaciones;

/**
 * Personal de limpieza del hotel (requisito "Gestión de Personal").
 * Esto es lo que antes intentaba ser la clase ServicioLimpieza:
 * una PERSONA, no un rol de la habitación.
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

    /**
     * Recibe cualquier objeto que sepa limpiarse, sin importar su tipo concreto.
     * (Inversión de dependencias: depende de la interfaz, no de HabitacionDoble.)
     */
    public void atender(ServicioLimpieza habitacion) {
        habitacion.limpiar();
        habitacionesAsignadas++;
    }

    public int getCargaTrabajo() {
        return habitacionesAsignadas;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | habitaciones atendidas: " + habitacionesAsignadas;
    }
}
