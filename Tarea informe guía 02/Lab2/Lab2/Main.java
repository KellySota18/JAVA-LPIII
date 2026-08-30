package Main;

import Gestion.SistemaGestion;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Profesor;

public class Main {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();

        Profesor prof1 = new Profesor("73581176", "Grower Padilla", 45, "Sistemas");
        Estudiante est1 = new Estudiante("63584173", "Brandom Prez", 20, "2024000133");
        Estudiante est2 = new Estudiante("83082150", "Patience", 21, "2024000641");
        
        sistema.registrarPersona(prof1);
        sistema.registrarPersona(est1);
        sistema.registrarPersona(est2);

        Curso curso1 = new Curso("SYS101", "Lenguajes de Programación III", "Programación", prof1);
        Curso curso2 = new Curso("MAT201", "Cálculo Aplicado", "Matemáticas", null);

        sistema.registrarCurso(curso1);
        sistema.registrarCurso(curso2);

        curso1.agregarEstudiante(est1);
        curso1.agregarEstudiante(est2);

        sistema.mostrarCursosDisponibles();
        sistema.mostrarReportePersonas();

        System.out.println("Total de cursos en la plataforma: " + SistemaGestion.totalCursosRegistrados);
    }
}