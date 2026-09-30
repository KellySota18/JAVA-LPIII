package Actividad2;

//Excepción que se produce cuando se intenta sacar
//un elemento de una pila que está vacía.
public class ExcepcionPilaVacia extends RuntimeException {

 // Constructor que recibe el mensaje de error.
 public ExcepcionPilaVacia(String mensaje) {
     super(mensaje);
 }
}