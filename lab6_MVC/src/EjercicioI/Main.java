package EjercicioI;

public class Main {
    public static void main(String[] args) {
        CarritoModelo modelo = new CarritoModelo();

        modelo.agregarAlCatalogo(new Producto("P01", "Audífonos Bluetooth", 89.90));
        modelo.agregarAlCatalogo(new Producto("P02", "Teclado Gamer", 145.00));
        modelo.agregarAlCatalogo(new Producto("P03", "Mouse Pad XL", 35.50));

        CarritoVista vista = new CarritoVista();
        CarritoController controller = new CarritoController(modelo, vista);

        controller.iniciar();
    }
}