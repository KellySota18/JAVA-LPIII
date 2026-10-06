package Actividad1;

public class Main_MVC {

    public static void main(String[] args) {

        PedidoModelo modelo = new PedidoModelo();

        PedidoVista vista = new PedidoVista();

        PedidoControlador controlador = new PedidoControlador(modelo, vista);

        controlador.iniciar();
    }
}