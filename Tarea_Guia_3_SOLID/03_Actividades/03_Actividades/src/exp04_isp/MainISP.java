package exp04_isp;

import java.util.List;

/** Demostración de la Experiencia 4 (ISP). */
public class MainISP {

    public static void main(String[] args) {
        System.out.println("===== EXPERIENCIA 4: ISP =====");

        ControladorServicios controlador = new ControladorServicios();
        HabitacionEstandar estandar = new HabitacionEstandar("202", 150.0);
        SuiteLujo suite = new SuiteLujo("501", 420.0);

        controlador.atenderLimpieza(estandar);
        controlador.atenderLimpieza(suite);

        controlador.atenderComida(suite, Menu.CENA_GOURMET);
        controlador.atenderLavanderia(suite, List.of(new Prenda("camisa"), new Prenda("saco")));

        // La habitación estándar simplemente no ofrece el servicio; no lanza excepciones
        controlador.atenderSolicitudComida(estandar, Menu.DESAYUNO_CONTINENTAL);
    }
}
