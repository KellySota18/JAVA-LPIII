package exp01_srp;

public class Cliente {

    private final String idCliente;
    private final String nombre;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public String getIdCliente() { return idCliente; }
    public String getNombre()    { return nombre; }
}
