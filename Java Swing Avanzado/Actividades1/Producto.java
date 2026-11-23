package practicaswing;
public class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;
    public Producto() {
    }
    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }
    // GETTERS
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getCantidadStock() {
        return cantidadStock;
    }
    public String getCategoria() {
        return categoria;
    }
    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    // ACTUALIZAR PRODUCTO
    public void actualizarProducto( String nombre, double precio, int cantidadStock,
            String categoria) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException( "El nombre es obligatorio.");
        }
        if (!Double.isFinite(precio) || precio <= 0) {
            throw new IllegalArgumentException( "El precio debe ser positivo.");
        }

        if (cantidadStock < 0) {
            throw new IllegalArgumentException( "El stock no puede ser negativo.");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException( "La categoría es obligatoria.");
        }
        this.nombre = nombre.trim();
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria.trim();
    }
    // OBTENER INFORMACION
    public String obtenerInformacion() {
        return String.format(
                """
                INFORMACIÓN DEL PRODUCTO

                Nombre: %s
                Precio: S/ %.2f
                Cantidad en stock: %d
                Categoría: %s
                """,
                nombre,
                precio,
                cantidadStock,
                categoria
        );
    }
}
