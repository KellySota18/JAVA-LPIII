package ejercicios;

import java.util.List;

public class Lienzo {

    public void dibujarTodo(List<Forma> formas) {
        formas.forEach(f -> {
            f.dibujar();
            System.out.printf("   área = %.2f%n", f.calcularArea());
        });
    }
}
