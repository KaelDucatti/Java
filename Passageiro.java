package entities;

public class Passageiro {
	
	private String nome;
	private String cpf;
	
	//ConstrutorPassageiro
	public Passageiro(String nome, String cpf) {
		this.cpf = cpf;
		this.nome = nome; 
	}
	
	//GET
	//RetornaOAtributoNome
	public String getNome() {
		return nome;
	}

	//RetornaOAtributoCpf
	public String getCpf() {
		return cpf;
	}
	
	//SET
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf; 
	}

	@Override
	public String toString() {
		return 	"---Passageiro---"
				+ "\nNome = " + nome 
				+ "\nCPF 	= " + cpf;
	}

}
