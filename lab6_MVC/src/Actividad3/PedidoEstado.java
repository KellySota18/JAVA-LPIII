package Actividad3;

public class PedidoEstado {

    private String nombrePlato;
    private String tipo;
    private String estado;

    // Constructor
    public PedidoEstado(String nombrePlato, String tipo) {

        this.nombrePlato = nombrePlato;
        this.tipo = tipo;

        // Todo pedido nuevo comienza como pendiente
        this.estado = "PENDIENTE";
    }

    // Getter del nombre del plato
    public String getNombrePlato() {
        return nombrePlato;
    }

    // Setter del nombre del plato
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    // Getter del tipo
    public String getTipo() {
        return tipo;
    }

    // Setter del tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter del estado
    public String getEstado() {
        return estado;
    }

    // Setter del estado
    public void setEstado(String estado) {
        this.estado = estado;
    }
}