package Actividad;

public class InvalidSubscriptException extends Exception {

 public InvalidSubscriptException() {
     super("Los índices proporcionados no son válidos");
 }
}