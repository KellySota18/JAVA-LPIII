package exp05_dip;

public class Reserva {

    private final String idReserva;
    private final String contactoCliente;

    public Reserva(String idReserva, String contactoCliente) {
        this.idReserva = idReserva;
        this.contactoCliente = contactoCliente;
    }

    public String getIdReserva()      { return idReserva; }
    public String getContactoCliente(){ return contactoCliente; }
}
