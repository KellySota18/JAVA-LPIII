package actividad2;

public class Contador {
    static int acumulador = 0;
    final static int VALOR_INICIAL = 10;
    private int valor;

    // Variables de clase (item j): total de contadores creados y valor inicial del ultimo
    static int nContadores = 0;
    static int ultimoContador = 0;

    public static int acumulador() {
        return acumulador;
    }

    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
        nContadores++;
        ultimoContador = valor;
    }

    // Segundo constructor: usa VALOR_INICIAL por defecto
    public Contador() {
        this(Contador.VALOR_INICIAL);
    }

    public void inc() {
        valor++;
        acumulador++;
    }

    public int getValor() {
        return this.valor;
    }

    public static int getnContadores() {
        return nContadores;
    }

    public static int getUltimoContador() {
        return ultimoContador;
    }
}
