import Clientes.Cliente;
import Clientes.ControladorClientes;
import Habitaciones.*;
import Informes.GeneradorInformes;
import Notificaciones.EnviadorCorreo;
import Personal.ControladorPersonal;
import Personal.PersonalLimpieza;
import Promociones.*;
import Reservas.*;
import java.time.LocalDate;

/**
 * Punto de entrada del Sistema de Gestión de Reservas de Hotel.
 * Aquí se arma el grafo de objetos: es el único lugar que conoce
 * las implementaciones concretas.
 */
public class Main {

    public static void main(String[] args) {

        // ---------- 1. Gestión de habitaciones ----------
        System.out.println("=== 1. GESTIÓN DE HABITACIONES ===");
        ControladorHabitaciones ctrlHabitaciones = new ControladorHabitaciones();
        Habitacion h101 = new HabitacionIndividual("101");
        Habitacion h102 = new HabitacionDoble("102");
        Habitacion h201 = new HabitacionDoble("201");
        Habitacion h301 = new HabitacionSuite("301");
        ctrlHabitaciones.registrarHabitacion(h101);
        ctrlHabitaciones.registrarHabitacion(h102);
        ctrlHabitaciones.registrarHabitacion(h201);
        ctrlHabitaciones.registrarHabitacion(h301);
        ctrlHabitaciones.listarHabitaciones();

        // ---------- 2. Gestión de clientes ----------
        System.out.println("\n=== 2. GESTIÓN DE CLIENTES ===");
        ControladorClientes ctrlClientes = new ControladorClientes();
        Cliente ana = new Cliente("C-001", "Ana Quispe", "ana@correo.com", "959111222", true);
        Cliente luis = new Cliente("C-002", "Luis Ramos", "luis@correo.com", "959333444", false);
        ctrlClientes.registrarCliente(ana);
        ctrlClientes.registrarCliente(luis);

        // ---------- 3. Armado del sistema de reservas ----------
        CalculadoraTarifa calculadora = new CalculadoraTarifa();
        calculadora.registrarPromocion(new PromocionClienteFrecuente());
        calculadora.registrarPromocion(new PromocionEstadiaLarga());
        calculadora.registrarPromocion(new PromocionPorFecha("Fiestas Patrias (25%)",
                LocalDate.of(2026, 7, 26), LocalDate.of(2026, 7, 30), 0.25));

        ControladorReservas ctrlReservas = new ControladorReservas(
                new GestorDisponibilidad(), calculadora, new EnviadorCorreo());

        System.out.println("\n=== 3. RESERVAS ===");
        LocalDate ini = LocalDate.of(2026, 9, 10);
        Reserva r1 = ctrlReservas.crearReserva(ana, h102, ini, ini.plusDays(3),
                new PoliticaCancelacionFlexible());
        Reserva r2 = ctrlReservas.crearReserva(luis, h301, ini, ini.plusDays(6),
                new PoliticaCancelacionModerada());
        ctrlReservas.crearReserva(luis, h102, ini.plusDays(1), ini.plusDays(2),
                new PoliticaCancelacionEstricta());
        Reserva r4 = ctrlReservas.crearReserva(luis, h201, ini, ini.plusDays(2),
                new PoliticaCancelacionCorporativa());

        // ---------- 4. Cancelaciones ----------
        System.out.println("\n=== 4. CANCELACIONES ===");
        ctrlReservas.procesarCancelacion(r4.getIdReserva());

        // ---------- 5. Check-in y check-out ----------
        System.out.println("\n=== 5. RECEPCIÓN ===");
        ctrlHabitaciones.realizarCheckIn("102");
        ctrlHabitaciones.realizarCheckOut("102");

        // ---------- 6. Personal de limpieza ----------
        System.out.println("\n=== 6. PERSONAL DE LIMPIEZA ===");
        ControladorPersonal ctrlPersonal = new ControladorPersonal();
        ctrlPersonal.registrarPersonal(new PersonalLimpieza("P-01", "Rosa Mamani"));
        ctrlPersonal.registrarPersonal(new PersonalLimpieza("P-02", "Julio Ccama"));
        ctrlPersonal.asignarLimpieza(ctrlHabitaciones.getHabitaciones());
        ctrlPersonal.consultarCargaTrabajo();

        // ---------- 7. Servicios opcionales ----------
        System.out.println("\n=== 7. SERVICIOS ADICIONALES ===");
        for (Habitacion habitacion : ctrlHabitaciones.getHabitaciones()) {
            if (habitacion instanceof ServicioComida) {
                ((ServicioComida) habitacion).solicitarComida("Lomo saltado");
            } else {
                System.out.println("La habitación " + habitacion.getNumero()
                        + " no cuenta con servicio de comida.");
            }
        }
        ((ServicioLavanderia) h301).solicitarLavanderia(4);

        // ---------- 8. Historial e informes ----------
        System.out.println("\n=== 8. HISTORIAL E INFORMES ===");
        System.out.println("Historial de " + ana.getNombre() + ":");
        ctrlReservas.historialDeCliente(ana).forEach(r -> System.out.println("   " + r));

        GeneradorInformes informes = new GeneradorInformes();
        informes.informeOcupacionPorTipo(ctrlReservas.getReservas());
        informes.informeIngresosPorPeriodo(ctrlReservas.getReservas(),
                LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 30));

        System.out.println("\nReservas activas: " + r1.isActiva() + " / " + r2.isActiva());
    }
}
