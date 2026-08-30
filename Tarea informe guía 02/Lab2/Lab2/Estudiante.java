package Modelo;

public class Estudiante extends Persona {
    private String codigoEstudiante;

    public Estudiante(String dni, String nombre, int edad, String codigoEstudiante) {
        super(dni, nombre, edad);
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Código: " + codigoEstudiante);
        System.out.println("Rol: Estudiante");
    }
}