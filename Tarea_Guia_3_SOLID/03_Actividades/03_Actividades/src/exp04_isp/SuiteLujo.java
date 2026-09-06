package exp04_isp;

import java.util.List;

public class SuiteLujo extends Habitacion
        implements IServicioLimpieza, IServicioComida, IServicioLavanderia {

    public SuiteLujo(String numero, double precioBase) {
        super(numero, precioBase);
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Limpieza premium para la suite " + numero);
    }

    @Override
    public void solicitarComida(Menu opcion) {
        System.out.println("Pedido de restaurante registrado para la suite "
                + numero + ": " + opcion);
    }

    @Override
    public void solicitarLavanderia(List<Prenda> prendas) {
        System.out.println("Lavandería: " + prendas.size()
                + " prendas recogidas de la suite " + numero);
    }

    @Override
    public double calcularPrecio(int dias) {
        return precioBase * dias * 1.45;
    }
}
