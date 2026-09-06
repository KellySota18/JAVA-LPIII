package exp04_isp;

import java.util.List;

public class ControladorServicios {

    /** La firma declara exactamente el rol necesario. */
    public void atenderLimpieza(IServicioLimpieza servicio) {
        servicio.solicitarLimpieza();
    }

    public void atenderComida(IServicioComida servicio, Menu opcion) {
        servicio.solicitarComida(opcion);
    }

    public void atenderLavanderia(IServicioLavanderia servicio, List<Prenda> prendas) {
        servicio.solicitarLavanderia(prendas);
    }

    /** Cuando se parte de un tipo genérico, se consulta la capacidad antes de invocarla. */
    public void atenderSolicitudComida(Habitacion habitacion, Menu opcion) {
        if (habitacion instanceof IServicioComida servicio) {
            atenderComida(servicio, opcion);
        } else {
            System.out.println("La habitación " + habitacion.getNumero()
                    + " no cuenta con servicio de comida.");
        }
    }
}
