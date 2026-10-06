package Actividad3;

import java.util.ArrayList;
import java.util.List;

public class PedidoModeloEstado {

    // Lista de pedidos actuales
    private List<PedidoEstado> pedidos;

    // Historial de pedidos
    private List<PedidoEstado> historial;

    // Constructor
    public PedidoModeloEstado() {

        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    // AGREGAR PEDIDO
    public void agregarPedido(PedidoEstado pedido) {

        pedidos.add(pedido);
    }

    // OBTENER TODOS LOS PEDIDOS
    public List<PedidoEstado> getPedidos() {

        return pedidos;
    }

    // MARCAR PEDIDO COMO COMPLETO
    public boolean marcarComoCompleto(String nombrePlato) {

        for (PedidoEstado pedido : pedidos) {

            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {

                // Cambiar estado
                pedido.setEstado("COMPLETO");

                // Agregar al historial
                historial.add(pedido);

                return true;
            }
        }

        return false;
    }

    // BUSCAR PEDIDOS POR ESTADO
    public List<PedidoEstado> buscarPorEstado(String estado) {

        List<PedidoEstado> resultados = new ArrayList<>();

        for (PedidoEstado pedido : pedidos) {

            if (pedido.getEstado().equalsIgnoreCase(estado)) {

                resultados.add(pedido);
            }
        }

        return resultados;
    }

   // CONTAR PEDIDOS PENDIENTES

    public int contarPendientes() {

        int contador = 0;

        for (PedidoEstado pedido : pedidos) {

            if (pedido.getEstado().equalsIgnoreCase("PENDIENTE")) {

                contador++;
            }
        }

        return contador;
    }

    // ELIMINAR PEDIDO
    public boolean eliminarPedido(String nombrePlato) {

        for (int i = 0; i < pedidos.size(); i++) {

            PedidoEstado pedido = pedidos.get(i);

            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) {

                // Cambiar estado a eliminado
                pedido.setEstado("ELIMINADO");

                // Guardar en historial
                historial.add(pedido);

                // Eliminar de la lista actual
                pedidos.remove(i);

                return true;
            }
        }

        return false;
    }

    // OBTENER HISTORIAL

    public List<PedidoEstado> getHistorial() {

        return historial;
    }
}