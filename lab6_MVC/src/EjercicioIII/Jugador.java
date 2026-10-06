package EjercicioIII;


import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int saludMaxima;
    private int nivel;
    private List<Item> inventario;
    private Item armaEquipada;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.saludMaxima = salud;
        this.nivel = nivel;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public List<Item> getInventario() { return inventario; }
    public Item getArmaEquipada() { return armaEquipada; }

    public void equiparArma(Item arma) {
        if (arma != null && arma.getTipo().equalsIgnoreCase("Arma")) {
            this.armaEquipada = arma;
        }
    }

    public int atacar() {
        if (armaEquipada != null) {
            return 15 + (nivel * 5);
        }
        return 5 + nivel; 
    }

    public boolean usarObjeto(Item item) {
        if (item != null && inventario.contains(item)) {
            if (item.getTipo().equalsIgnoreCase("Poción")) {
                if (item.usarItem()) {
                    this.salud = Math.min(saludMaxima, salud + 30);
                    return true;
                }
            }
        }
        return false;
    }

    public void recibirDano(int cantidad) {
        this.salud -= cantidad;
        if (this.salud < 0) this.salud = 0;
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}