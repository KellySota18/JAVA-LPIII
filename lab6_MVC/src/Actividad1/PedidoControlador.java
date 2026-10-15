package Actividad1; 

// Importa la interfaz List para trabajar con listas de pedidos.
import java.util.List;

// Clase Controlador: conecta el modelo con la vista y gestiona las acciones del usuario.
public class PedidoControlador {

    // Atributo que almacena la referencia al modelo, encargado de gestionar los pedidos.
    private PedidoModelo modelo;

    // Atributo que almacena la referencia a la vista, encargada de interactuar con el usuario.
    private PedidoVista vista;

    // Constructor que recibe el modelo y la vista para utilizarlos dentro del controlador.
    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {

        // Guarda el modelo recibido en el atributo de la clase.
        this.modelo = modelo;

        // Guarda la vista recibida en el atributo de la clase.
        this.vista = vista;
    }

    // Método que permite agregar un nuevo pedido a partir del nombre del plato.
    public void agregarPedido(String nombrePlato) {

        // Verifica que el nombre del plato no esté vacío.
        if (!nombrePlato.isEmpty()) {

            // Crea un objeto Pedido utilizando el nombre del plato ingresado.
            Pedido pedido = new Pedido(nombrePlato);

            // Envía el pedido al modelo para que lo almacene.
            modelo.agregarPedido(pedido);

            // Muestra un mensaje de confirmación al usuario.
            vista.mostrarMensaje(
                "Pedido agregado: " + nombrePlato
            );

        } else {

            // Si el nombre está vacío, muestra un mensaje de advertencia.
            vista.mostrarMensaje(
                "El nombre del plato no puede estar vacío."
            );
        }
    }

    // Método que obtiene los pedidos almacenados y solicita a la vista que los muestre.
    public void mostrarPedidos() {

        // Obtiene del modelo la lista de pedidos registrados.
        List<Pedido> pedidos = modelo.getPedidos();

        // Envía la lista de pedidos a la vista para presentarla al usuario.
        vista.mostrarPedidos(pedidos);
    }

    // Método que inicia el menú principal y controla las opciones seleccionadas.
    public void iniciar() {

        // Declara una variable para almacenar la opción ingresada por el usuario.
        String opcion;

        // Ejecuta el menú al menos una vez y lo repite hasta seleccionar la opción 3.
        do {

            // Muestra las opciones disponibles en la vista.
            vista.mostrarMenu();

            // Solicita al usuario que ingrese una opción.
            opcion = vista.solicitarOpcion();

            // Evalúa la opción ingresada y ejecuta la acción correspondiente.
            switch (opcion) {

                // Si el usuario selecciona 1, permite registrar un pedido.
                case "1":

                    // Solicita el nombre del plato al usuario.
                    String nombrePlato =
                        vista.solicitarNombrePlato();

                    // Llama al método que valida y agrega el pedido.
                    agregarPedido(nombrePlato);

                    // Finaliza este caso del switch.
                    break;

                // Si el usuario selecciona 2, muestra los pedidos registrados.
                case "2":

                    // Llama al método encargado de mostrar los pedidos.
                    mostrarPedidos();

                    // Finaliza este caso del switch.
                    break;

                // Si el usuario selecciona 3, inicia la salida del programa.
                case "3":

                    // Muestra un mensaje de despedida.
                    vista.mostrarMensaje("Saliendo...");

                    // Finaliza este caso del switch.
                    break;

                // Si la opción no coincide con ninguna de las anteriores.
                default:

                    // Informa al usuario que debe ingresar una opción válida.
                    vista.mostrarMensaje(
                        "Opción no válida. Inténtalo de nuevo."
                    );

                    // Finaliza el caso predeterminado.
                    break;
            }

        // Repite el menú mientras la opción ingresada sea diferente de 3.
        } while (!opcion.equals("3"));

        // Cierra el Scanner utilizado por la vista para leer datos del usuario.
        vista.cerrarScanner();
    }
}
