package Actividad1; // Indica que la clase pertenece al paquete Actividad1.

public class Main_MVC { // Clase principal que inicia la aplicación MVC.

    public static void main(String[] args) { // Método principal donde comienza la ejecución del programa.

        // Crear un objeto del modelo, encargado de gestionar los datos y la lógica del pedido.
        PedidoModelo modelo = new PedidoModelo();

        // Crear un objeto de la vista, encargado de mostrar la información al usuario.
        PedidoVista vista = new PedidoVista();

        // Crear el controlador y pasarle el modelo y la vista para que pueda coordinarlos.
        PedidoControlador controlador = new PedidoControlador(modelo, vista);

        // Llamar al método iniciar() del controlador para comenzar la ejecución de la aplicación.
        controlador.iniciar();
    }
}
