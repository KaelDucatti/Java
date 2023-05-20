package entities;

public class Voo {
	
	private Aviao aeronave; 
	private int numero;
	private String data;
	private String hora; 

	//Construct
	public Voo(Aviao aeronave, int numero, String data, String hora) {
		this.aeronave = aeronave;
		this.numero = numero;
		this.data = data;
		this.hora = hora; 	
	}
	
	//getters
	public int getNumero() {
		return numero;
	}
	
	public String getData() {
		return data;
	}
	
	public String getHora() {
		return hora;
	}

	public Aviao getAeronave() {
		return aeronave;
	}


	//setters
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void setAeronave(Aviao aeronave) {
		this.aeronave = aeronave;
	}
	

	//Retorno
	public String toString() {
		return 	  "*Vôo Cadastrado*\n"
				+ "\nNúmero: "	+ numero 
				+ "\nData:    " + data 
				+ "\nHora:    " + hora
				+ "\n\nAeronave: " + aeronave;
	}

}
