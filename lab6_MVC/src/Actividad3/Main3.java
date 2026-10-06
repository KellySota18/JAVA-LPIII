package Actividad3;

public class Main3 {

    public static void main(String[] args) {

        // Crear Modelo
        PedidoModeloEstado modelo = new PedidoModeloEstado();

        // Crear Vista
        PedidoVistaEstado vista = new PedidoVistaEstado();

        // Crear Controlador
        PedidoControladorEstado controlador = new PedidoControladorEstado(modelo,vista);

        // Iniciar aplicación
        controlador.iniciar();
    }
}