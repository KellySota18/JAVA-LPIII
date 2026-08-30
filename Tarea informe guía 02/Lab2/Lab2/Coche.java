package actividad1;

public class Coche {
    // Atributos
    private String marca;
    private String modelo;
    private int anoFabricacion;
    private double precio;
    private boolean enMarcha;

    // Constructor por defecto
    public Coche() {
        this.marca = "Desconocida";
        this.modelo = "Desconocido";
        this.anoFabricacion = 2020;
        this.precio = 0.0;
        this.enMarcha = false;
    }

    // Constructor con 4 parametros: marca, modelo, anoFabricacion, precio
    public Coche(String marca, String modelo, int anoFabricacion, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.precio = precio;
        this.enMarcha = false;
    }

    // Metodos
    // Aplica un descuento (%) al precio si el coche es un modelo antiguo (< 2010)
    public boolean aplicarDescuento(double descuento) {
        if (anoFabricacion < 2010) {
            precio = precio - (precio * descuento / 100);
            return true;
        }
        return false;
    }

    public void acelerar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " esta acelerando.");
        } else {
            System.out.println("Primero enciende el coche.");
        }
    }

    public void frenar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " esta frenando.");
        } else {
            System.out.println("El coche esta apagado, no se puede frenar.");
        }
    }

    public void encender() {
        enMarcha = true;
        System.out.println("El coche " + modelo + " se ha encendido.");
    }

    public void apagar() {
        enMarcha = false;
        System.out.println("El coche " + modelo + " se ha apagado.");
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEnMarcha() {
        return enMarcha;
    }
}
