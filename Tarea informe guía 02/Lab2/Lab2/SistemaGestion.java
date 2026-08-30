package Gestion;

import java.util.ArrayList;
import Modelo.Curso;
import Modelo.Persona;

public class SistemaGestion {
    public static int totalCursosRegistrados = 0;

    private ArrayList<Curso> listaCursos;
    private ArrayList<Persona> listaPersonas;

    public SistemaGestion() {
        listaCursos = new ArrayList<>();
        listaPersonas = new ArrayList<>();
    }

    public void registrarCurso(Curso curso) {
        listaCursos.add(curso);
        totalCursosRegistrados++;
    }

    public void registrarPersona(Persona persona) {
        listaPersonas.add(persona);
    }

    public void mostrarCursosDisponibles() {
        System.out.println("LISTA DE CURSOS");
        for (Curso c : listaCursos) {
            c.mostrarDetalle();
        }
    }

    public void mostrarReportePersonas() {
        System.out.println(" PERSONAS EN EL SISTEMA");
        for (Persona p : listaPersonas) {
            p.mostrarInfo();
            System.out.println("---");
        }
    }
}