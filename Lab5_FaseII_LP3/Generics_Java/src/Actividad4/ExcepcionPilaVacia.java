package Actividad4;

//Excepcion que se produce cuando se intenta sacar un elemento de una pila vacia
public class ExcepcionPilaVacia extends RuntimeException {

 // Constructor que recibe el mensaje de error
 public ExcepcionPilaVacia(String mensaje) {
     super(mensaje);
 }
}