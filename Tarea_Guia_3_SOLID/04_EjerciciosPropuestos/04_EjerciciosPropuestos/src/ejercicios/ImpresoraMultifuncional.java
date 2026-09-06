package ejercicios;

public class ImpresoraMultifuncional implements Imprimible, Escaneable {

    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo a doble cara: " + documento);
    }

    @Override
    public String escanear() {
        System.out.println("Escaneando documento...");
        return "documento_escaneado.pdf";
    }
}
