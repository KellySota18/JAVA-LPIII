package Actividad2;

public static void MainActividad2(String[] args) {

        // Crear Modelo
        PedidoModelo modelo = new PedidoModelo();

        // Crear Vista
        PedidoVista vista = new PedidoVista();

        // Crear Controlador
        PedidoControlador controlador = new PedidoControlador(modelo,vista);

        // Iniciar aplicación
        controlador.iniciar();
    }
}