package actividad4;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        // Composicion: la cuenta se crea y "vive" solo dentro de la persona
        // El numero de cuenta se determina a partir del id de la persona
        this.cuenta = new Cuenta(id * 1000);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public String toString() {
        return "Persona [ID: " + id + ", Nombre: " + nombre + " " + apellido + ", " + cuenta.toString() + "]";
    }
}
