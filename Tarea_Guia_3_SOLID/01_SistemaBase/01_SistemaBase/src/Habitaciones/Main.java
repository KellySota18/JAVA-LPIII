package Habitaciones;

/**
 * Punto de entrada del sistema de gestión de reservas.
 */
public class Main {

    public static void main(String[] args) {

        ControladorHabitaciones controlador = new ControladorHabitaciones();

        // --- Registro de habitaciones ---
        Habitacion h101 = new HabitacionIndividual("101");
        Habitacion h102 = new HabitacionDoble("102");
        Habitacion h201 = new HabitacionDoble("201");
        Habitacion h301 = new HabitacionSuite("301");

        controlador.registrarHabitacion(h101);
        controlador.registrarHabitacion(h102);
        controlador.registrarHabitacion(h201);
        controlador.registrarHabitacion(h301);

        System.out.println("\n--- Listado de habitaciones ---");
        controlador.listarHabitaciones();

        // --- Check-in y check-out ---
        System.out.println("\n--- Operaciones de recepción ---");
        controlador.realizarCheckIn("102");
        controlador.realizarCheckIn("102");
        System.out.println("Disponibles ahora: " + controlador.consultarDisponibles().size());
        controlador.realizarCheckOut("102");

        // --- Personal de limpieza ---
        System.out.println("\n--- Servicio de limpieza ---");
        PersonalLimpieza rosa = new PersonalLimpieza("P-01", "Rosa Mamani");
        for (Habitacion habitacion : controlador.getHabitaciones()) {
            if (habitacion instanceof ServicioLimpieza) {
                rosa.atender((ServicioLimpieza) habitacion);
            }
        }
        System.out.println(rosa);

        // --- Servicios que no todas las habitaciones ofrecen ---
        System.out.println("\n--- Servicios adicionales ---");
        for (Habitacion habitacion : controlador.getHabitaciones()) {
            if (habitacion instanceof ServicioComida) {
                ((ServicioComida) habitacion).solicitarComida("Lomo saltado");
            } else {
                System.out.println("La habitación " + habitacion.getNumero()
                        + " no cuenta con servicio de comida.");
            }
        }
        ((ServicioLavanderia) h301).solicitarLavanderia(4);

        System.out.println("\n--- Características ---");
        for (Habitacion habitacion : controlador.getHabitaciones()) {
            System.out.println(habitacion.getNumero() + ": " + habitacion.getCaracteristicas());
        }
    }
}
