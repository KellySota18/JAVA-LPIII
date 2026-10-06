package Actividad2;
import java.util.ArrayList;
import java.util.List;


public class PedidoModelo {
   
	private List<Pedido> pedido;
	
	//Contructor
	public PedidoModelo() {
		pedido = new ArrayList<> ();
	}
	
	//Agregar pedido
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
		
	}
	
	//obtener todos los pedidos
	public List<Pedido> getPedidos(){
		return pedidos;
	}
	
	//Eliminar pedido por nombre
	public boolean eliminarPedido(String nombrePlato) {
		
		for(int i=0; i < pedidos.size(); i++) {
			
			if (pedido.get(i).getNombrePlato().equalsIgnoreCase(nombrePlato)) {
				
				pedidos.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	//Actualizar los nombre de los pedidos
	//actualizarPedido es el nombre del metodo
	public boolean actualizarPedido{String nombreActual, String nuevoNombre){
	
	//Recorre todos los objetos pedido q estan almacenados en pedidos
	  for (Pedido pedido : pedidos) {
		  
		  //.equalsIgnoreCase(nombreActual) compara el nombre del plato con nombreActual ignorando mayuscula y minusculas
		  if (pedido.getNombrePlato().equalsIgnoreCase(nombreActual)){
			  
			  pedido.setNombrePlato(nuevoNombre);
			  return true;
		  }
	  }
	  
	  return false;
	}
	
	//Buscar pedidos por nombre
	public List<Pedido> buscarPorNombre(String nombre){
		
		List<Pedido> resultados = new ArrayList<>();
		
		for(Pedido pedido : pedido) {
			
			if (pedido.getNombrePlato().toLowerCase().contains(nombre.toLowerCase())) {
			    resultados.add(pedido);
			}
		}
		
		return resultados;
		
		//Buscar pedidos por tipo
		public List<Pedido> buscarPorTipo(String tipo){
			
			 List<Pedido> resultados = new ArrayList<>();

		        for (Pedido pedido : pedidos) {

		            if (pedido.getTipo()
		                    .equalsIgnoreCase(tipo)) {

		                resultados.add(pedido);
		            }
		        }

		        return resultados;
		    }

		    // Contar todos los pedidos
		    public int contarPedidos() {
		        return pedidos.size();
		    }

		    // Contar pedidos según el tipo
		    public int contarPorTipo(String tipo) {
		        int contador = 0;
		        for (Pedido pedido : pedidos) {
		            if (pedido.getTipo()
		                    .equalsIgnoreCase(tipo)) {

		                contador++;
		            }
		        }

		        return contador;
		    }
		
}

