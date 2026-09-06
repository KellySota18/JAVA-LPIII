package Clientes;

/**
 * Entidad cliente. RESPONSABILIDAD ÚNICA: guardar sus datos de contacto.
 * El historial de reservas lo administra ControladorClientes.
 */
public class Cliente {

    private final String idCliente;
    private final String nombre;
    private final String correo;
    private final String telefono;
    private final boolean frecuente;

    public Cliente(String idCliente, String nombre, String correo,
                   String telefono, boolean frecuente) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.frecuente = frecuente;
    }

    public String  getIdCliente() { return idCliente; }
    public String  getNombre()    { return nombre; }
    public String  getCorreo()    { return correo; }
    public String  getTelefono()  { return telefono; }
    public boolean esFrecuente()  { return frecuente; }

    @Override
    public String toString() {
        return idCliente + " - " + nombre + (frecuente ? " (frecuente)" : "");
    }
}
