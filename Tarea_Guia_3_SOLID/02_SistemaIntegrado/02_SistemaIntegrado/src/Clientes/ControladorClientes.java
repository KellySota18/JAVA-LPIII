package Clientes;

import java.util.ArrayList;
import java.util.List;

public class ControladorClientes {

    private final List<Cliente> clientes = new ArrayList<>();

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente);
    }

    public Cliente buscarPorId(String idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
