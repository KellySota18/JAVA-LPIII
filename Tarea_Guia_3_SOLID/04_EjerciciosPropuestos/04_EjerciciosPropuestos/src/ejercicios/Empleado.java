package ejercicios;

/** Ejercicio 1 (SRP): la entidad sólo almacena datos. */
public class Empleado {

    private final String nombre;
    private final double salarioAnual;
    private final String departamento;

    public Empleado(String nombre, double salarioAnual, String departamento) {
        this.nombre = nombre;
        this.salarioAnual = salarioAnual;
        this.departamento = departamento;
    }

    public String getNombre()       { return nombre; }
    public double getSalarioAnual() { return salarioAnual; }
    public String getDepartamento() { return departamento; }
}
