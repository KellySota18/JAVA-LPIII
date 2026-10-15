package Actividad1; // Indica que la clase pertenece al paquete Actividad1.

public class Pedido { // Declara la clase Pedido, que representa un pedido de comida.

    // Atributo privado que almacena el nombre del plato solicitado.
    private String nombrePlato;

    // Constructor que recibe el nombre del plato al crear un objeto Pedido.
    public Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato; // Guarda el nombre recibido en el atributo del objeto.
    }

    // Método getter que devuelve el nombre del plato almacenado.
    public String getNombrePlato() {
        return nombrePlato; // Retorna el valor del atributo nombrePlato.
    }
}
