import java.util.Random;

public class eje3_Main {   //uso compilador online

    public static void main(String[] args) {
        // Arreglo para guardar la frecuencia de cada cara (índices 0 a 5 representan las caras 1 a 6)
        int[] frecuencias = new int[6];

        // Objeto para generar números aleatorios
        Random random = new Random();

        // Número de lanzamientos
        int totalLanzamientos = 20000;

        // Ciclo que simula cada lanzamiento del dado
        for (int i = 0; i < totalLanzamientos; i++) {
            // Genera un número aleatorio entre 0 y 5 (equivalente a las caras 1-6)
            int resultado = random.nextInt(6);

            // Incrementa la frecuencia de la cara obtenida
            frecuencias[resultado]++;
        }

        
        System.out.println("Resultados de " + totalLanzamientos + " lanzamientos del dado:");
        for (int cara = 0; cara < 6; cara++) {
            // cara + 1 porque el índice 0 representa la cara "1"
            System.out.println("Cara " + (cara + 1) + ": " + frecuencias[cara] + " veces");
        }
    }
}