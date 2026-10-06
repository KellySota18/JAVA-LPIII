package EjercicioIII;


public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    public int atacar() {
        return 8 + (nivel * 3);
    }

    public void recibirDano(int cantidad) {
        this.salud -= cantidad;
        if (this.salud < 0) meSalvo0();
    }

    private void meSalvo0() {
        this.salud = 0;
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}