package Modelo;

public class Profesor extends Persona {
    private String especialidad;

    public Profesor(String dni, String nombre, int edad, String especialidad) {
        super(dni, nombre, edad);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Rol: Profesor");
    }
}