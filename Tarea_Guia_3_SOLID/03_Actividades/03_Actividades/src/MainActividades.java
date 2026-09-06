/**
 * Punto de entrada único: ejecuta las 5 Experiencias de Práctica (Sección IV
 * "ACTIVIDADES" de la guía) sobre el sistema de reservas de hotel.
 *
 * Compilar:  javac -d bin $(find src -name "*.java")
 * Ejecutar:  java -cp bin MainActividades
 */
public class MainActividades {
    public static void main(String[] args) {
        System.out.println("=== Experiencia 01: SRP ===");
        exp01_srp.MainSRP.main(args);

        System.out.println("\n=== Experiencia 02: OCP ===");
        exp02_ocp.MainOCP.main(args);

        System.out.println("\n=== Experiencia 03: LSP ===");
        exp03_lsp.MainLSP.main(args);

        System.out.println("\n=== Experiencia 04: ISP ===");
        exp04_isp.MainISP.main(args);

        System.out.println("\n=== Experiencia 05: DIP ===");
        exp05_dip.MainDIP.main(args);
    }
}
