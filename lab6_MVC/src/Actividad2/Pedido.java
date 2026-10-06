package Actividad2;

public class Pedido {
	
	private String nombrePlato;
	private String tipo;
	
	//constructor
	public Pedido(String nombrePlato, String tipo) {
		this.nombrePlato = nombrePlato;
		this.tipo = tipo;
		
	}
    
	
	//Getter del nombre del plato
	
	public String getNombrePlato() {
		return nombrePlato;
		
	}
	
	//Setter del nombre del plato
	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
				
	}
	
	//Getter del tipo
	public String getTipo() {
		return tipo;
	}
	
	//Setter del tipo
	public void setTipo(String tipo) {
		
		this.tipo = tipo;
	}
	
	
	
}
