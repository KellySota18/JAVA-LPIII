package Actividad1; 

// Importa ArrayList para crear una lista dinámica de pedidos.
import java.util.ArrayList;

// Importa List para declarar y manejar listas de pedidos.
import java.util.List;

// Clase Modelo: se encarga de almacenar y administrar los pedidos del restaurante.
public class PedidoModelo {

    // Declara una lista privada que almacenará objetos de tipo Pedido.
    private List<Pedido> pedidos;

    // Constructor de la clase: se ejecuta cuando se crea un objeto PedidoModelo.
    public PedidoModelo() {

        // Inicializa la lista utilizando ArrayList, que permite agregar elementos dinámicamente.
        pedidos = new ArrayList<>();
    }

    // Método que recibe un pedido y lo agrega a la lista.
    public void agregarPedido(Pedido pedido) {

        // Añade el objeto Pedido al final de la lista.
        pedidos.add(pedido);
    }

    // Método que devuelve la lista de pedidos almacenados.
    public List<Pedido> getPedidos() {

        // Retorna la lista para que otras clases puedan consultar los pedidos.
        return pedidos;
    }
}
