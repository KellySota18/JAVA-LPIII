package Modelo;

import java.util.ArrayList;

public class Curso {
    public static final int MAX_CAPACIDAD = 30;

    private String codigo;
    private String nombre;
    private String categoria;
    private Profesor profesor;
    private ArrayList<Estudiante> estudiantes;

    public Curso(String codigo, String nombre, String categoria, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < MAX_CAPACIDAD) {
            estudiantes.add(estudiante);
            System.out.println("Estudiante " + estudiante.getNombre() + " inscrito en " + nombre);
        } else {
            System.out.println("No hay cupos disponibles.");
        }
    }

    public int getCantidadEstudiantes() {
        return estudiantes.size();
    }

    public void mostrarDetalle() {

        System.out.println("Curso: " + nombre + " (" + codigo + ")");
        System.out.println("Categoría: " + categoria);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre());
        } else {
            System.out.println("Profesor: Por asignar");
        }
        System.out.println("Inscritos: " + getCantidadEstudiantes() + " / " + MAX_CAPACIDAD);
        
    }
}