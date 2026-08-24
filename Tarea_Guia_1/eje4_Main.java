public class eje4_Main{   //estoy usando compilador online de java

    // Función que recibe tres números decimales y devuelve el menor de ellos
    public static double menor(double num1, double num2, double num3) {
        // Se asume inicialmente que num1 es el menor
        double resultado = num1;
        // Si num2 es menor que el resultado actual, se actualiza
        if (num2 < resultado) {
            resultado = num2;
        }
        // Si num3 es menor que el resultado actual, se actualiza
        if (num3 < resultado) {
            resultado = num3;
        }
        return resultado;
    }
    public static void main(String[] args) {  // Ejemplo de uso de la función
        double a = 5.7;
        double b = 2.3;
        double c = 8.1;

        // Llama a la función y la muestra pantalla
        double resultadoMenor = menor(a, b, c);
        System.out.println("El menor de los tres números es: " + resultadoMenor);
    }
}