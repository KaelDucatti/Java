package entities;

public class Aeronave {
	
protected String modelo;
	
	
	//ConstrutorAeronave
	public Aeronave(String modelo) {
		this.modelo = modelo; 
	}
	

	//get Modelo - retorna o modelo da aeronave
	public String getModelo() {
		 
		return modelo;
	}
	
	//set Modelo - atribui novo modelo ao atributo modelo
	public void setModelo(String modelo) {
		
		this.modelo = modelo;
	}

	
	public String toString() {
		return    "Aeronave Cadastrada\n" 
				+ "\n" + modelo;
		
	}

}
