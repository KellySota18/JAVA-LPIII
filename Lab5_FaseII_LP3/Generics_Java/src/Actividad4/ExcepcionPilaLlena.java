package Actividad4;

//Excepcion que se produce cuando se intenta insertar un elemento en una pila llena
public class ExcepcionPilaLlena extends RuntimeException {

 // Constructor que recibe el mensaje de error.
 public ExcepcionPilaLlena(String mensaje) {
     super(mensaje);
 }
}