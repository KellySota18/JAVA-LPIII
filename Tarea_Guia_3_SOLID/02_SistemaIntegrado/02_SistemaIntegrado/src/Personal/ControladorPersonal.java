package Personal;

import Habitaciones.Habitacion;
import Habitaciones.ServicioLimpieza;
import java.util.ArrayList;
import java.util.List;

/**
 * RESPONSABILIDAD ÚNICA: administrar al personal y repartir la carga de trabajo.
 */
public class ControladorPersonal {

    private final List<PersonalLimpieza> personal = new ArrayList<>();

    public void registrarPersonal(PersonalLimpieza trabajador) {
        personal.add(trabajador);
        System.out.println("Personal registrado: " + trabajador.getNombre());
    }

    /**
     * Asigna cada habitación limpiable al trabajador con menos carga.
     * Las habitaciones que no implementan ServicioLimpieza simplemente se omiten:
     * no hay excepciones ni métodos vacíos (Segregación de Interfaces).
     */
    public void asignarLimpieza(List<Habitacion> habitaciones) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion instanceof ServicioLimpieza) {
                PersonalLimpieza trabajador = buscarMenosCargado();
                if (trabajador != null) {
                    trabajador.atender((ServicioLimpieza) habitacion);
                }
            }
        }
    }

    public void consultarCargaTrabajo() {
        for (PersonalLimpieza trabajador : personal) {
            System.out.println("   " + trabajador);
        }
    }

    private PersonalLimpieza buscarMenosCargado() {
        PersonalLimpieza menor = null;
        for (PersonalLimpieza trabajador : personal) {
            if (menor == null || trabajador.getCargaTrabajo() < menor.getCargaTrabajo()) {
                menor = trabajador;
            }
        }
        return menor;
    }
}
