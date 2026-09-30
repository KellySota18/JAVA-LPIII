package Actividad2;

//Excepción que se produce cuando se intenta insertar un elemento en una pila que ya está llena.
public class ExcepcionPilaLlena extends RuntimeException {

 // Constructor que recibe el mensaje de error.
 public ExcepcionPilaLlena(String mensaje) {
     super(mensaje);
 }
}