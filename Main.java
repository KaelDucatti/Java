package application;


import javax.swing.*;

import entities.Aviao;
import entities.Passageiro;
import entities.Voo;

public class Main {
	//Variaveis/Objeto globais
	static Aviao aviao;
	static int qtdVoos = 0; //número de voos criados (0 à 9)
	static Voo[] arrayVoo = new Voo[10]; //Array da classe Voo
	

	
	//ClassePrincipal
	public static void main(String[] args) {
		int escolhaMenu = 0;	
		try {
			do {		
				escolhaMenu = Integer.parseInt(JOptionPane.showInputDialog(
					"MENU PRINCIPAL\n"
					+ "		1 - Parâmetros do Sistema \n"
					+ "		2 - Reserva de Passagens \n"
					+ "		3 - Sair \n"
					+ "\nEscolha uma das opções: ")
				);	
				switch(escolhaMenu) {
				case 1:
					parametrosDoSistema();
					break;
				case 2:
					reservaDePassagens();
					break; 
				case 3:
					sair();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				}//fechamento:SWITCH
			}while(escolhaMenu!=3);
		 }catch(NumberFormatException error) {
             JOptionPane.showMessageDialog(null, "Opção selecionada não é um numero: ");
         }	
	}//fechamento:Main(String[]...)
	
	
	
	//FunçõesDoParametroDoSistema
	public static void parametrosDoSistema() {
		int escolhaMenuSistema = 0; 
		try {
			do {
				escolhaMenuSistema = Integer.parseInt(JOptionPane.showInputDialog(
					"Parâmetros do Sistema \n"
					+ "1 - Cadastrar Aeronave \n"
					+ "2 - Cadastrar Voo \n"
					+ "3 - Voltar \n"
					+ "\nEscolha uma das opções acima:")
				);
				switch(escolhaMenuSistema) {
					
				case 1:
					//ModeloAvião
					String aeronave = JOptionPane.showInputDialog(null, "Digite o modelo da Aeronave:");
						
					//Indica quantos assentos o avião posssui
	                int assentos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantos Assentos a Aeronave terá: "));
						
					//Indica quantas fileiras o avião posssui
					int fileiras = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantas Fileiras a Aeronave terá: "));
												
					//InformaçõesDoAvião
					aviao = new Aviao(aeronave, fileiras, assentos);
					JOptionPane.showMessageDialog(null, aviao.toString());
					break;
						
				case 2:
					//Verifica se o numero de voos cadastrados excedeu o valor de 10 voos
					if(qtdVoos == 10) {
						JOptionPane.showMessageDialog(null,"Você atingiu o limite máximo de voos");
						break;
					}
						
					//Verifica se a aeronave já foi cadastrada, caso não há ele barra acontinuação
					if(aviao == null) {
						JOptionPane.showMessageDialog(null,"A aeronave não foi cadastrada");
						break;
					}
				
					//NumeroDoVoo
					int numeroDoVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do vôo (0 a 9): "));
						
					//DataDoVoo
					String dataDoVoo = JOptionPane.showInputDialog(null, "Data do vôo (ex.: 20/12/2022): ");
						
					//HoraDoVoo
					String horaDoVoo = JOptionPane.showInputDialog(null, "Hora do vôo (ex.: 20:35): ");
						
					//Cadastra os dados na classe Voo da posição numeroDeVoos e armazena.				
					arrayVoo[qtdVoos]= new Voo(aviao, numeroDoVoo, dataDoVoo, horaDoVoo);				
						
					//Mostra as informações armazenadas de cadastrar voo
					String outputInfoCadastroVoo =  "Informações do vôo cadastrado\n"
						+ "\n\nAeronave : " + arrayVoo[qtdVoos].getAeronave()
				        + "\nNúmero   : " + arrayVoo[qtdVoos].getNumero() 
				        + "\nData     : " + arrayVoo[qtdVoos].getData() 
				        + "\nHora     : " + arrayVoo[qtdVoos].getHora();      
					JOptionPane.showMessageDialog(null, outputInfoCadastroVoo);
					qtdVoos++; //Atualiza o número de voos existentes
					break;
						
				case 3:
					//voltandoParaOMenuPrincipal
					break;
						
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida");
					break;
				}//fechamento:SWITCH	
			}while(escolhaMenuSistema!=3);
		}
		catch(NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Opção selecionada não é um numero: ");
        }		
	}//fechamento:ParametroDoSistema
		
	
	
	//FunçãoReservaDePassagens
	public static void reservaDePassagens() {
		int escolhaMenuReserva = 0; 
		try {
			do {
				escolhaMenuReserva = Integer.parseInt(JOptionPane.showInputDialog(
						"Reserva de Passagens \n"
						+ "1 - Fazer Reserva \n"
						+ "2 - Lugares disponíveis \n"
						+ "3 - Reservas realizadas \n"
						+ "4 - Voltar \n"
						+ "\nEscolha uma das opções acima:")
				);
					
			switch(escolhaMenuReserva) {
			case 1:
				//Valida se existe um voo cadastrado caso não haja ele apresenta essa mensagem.
				if(arrayVoo[0] == null) {
					JOptionPane.showMessageDialog(null, "Você não cadastrou um vôo");
					break;
				}
				//Solicita o numero do Voo
				String numeroDoVoo = JOptionPane.showInputDialog(null, "Digite o número do vôo cadastrado (0 a 9): ");
						
				//Valida se existe o numero do voo
				Aviao aeronave =  arrayVoo[Integer.parseInt(numeroDoVoo)].getAeronave();
						
				if(aeronave.verificaExistenciaDeLugaresDisponiveis()) {
					//Solicita o nome 
					String nomeDoPassageiro = JOptionPane.showInputDialog(null, "Digite seu Nome: ");
					//Solicita o cpf 
					String cpfDoPassageiro = JOptionPane.showInputDialog(null, "Digite seu CPF: ");
							
					//Armazena e mostra os dados solicitados nome e cpf
					Passageiro passageiro = new Passageiro(nomeDoPassageiro, cpfDoPassageiro); 
					JOptionPane.showMessageDialog(null, passageiro.toString());
							
					//Realiza a escolha do assento e fileira, valida se o o assento e fileira estão vazio e se estiver armazena
					String fileira = JOptionPane.showInputDialog(null,  aeronave.getFileirasVazias() + " \n Digite o número da Fileira: ");
					String assento = JOptionPane.showInputDialog(null,  aeronave.getLugaresVazios(Integer.parseInt(fileira)) + " \n Digite o número do assento: "); //Mostra os assentos da fileira "Integer.parseInt(fileira)"
					if (aeronave.verificaLugarOcupado( Integer.parseInt(fileira), Integer.parseInt(assento))) {
						JOptionPane.showMessageDialog(null, "Assento indisponível");
					}else{
						//Estando tudo certo na reserva devolve a mensagem
						arrayVoo[Integer.parseInt(numeroDoVoo)].getAeronave().setPassageiro(Integer.parseInt(fileira), Integer.parseInt(assento), passageiro);
								
						//Mostra que a reserva foi realizada e mostra a informação de nome, fileira e assento ao usuario.
						JOptionPane.showMessageDialog(null, "Sua reserva foi realizada \n Nome: " + passageiro.getNome() + "\n Fileira: " + fileira + "\n Assento: " + assento );
					}
					}else{
						//Informa o cliente a mensagem caso não exista mais lugares
						JOptionPane.showMessageDialog(null, "Não existem mais lugares disponiveis nesse vôo");
					}
					break; 
						
				case 2:
					//Valida se existe um voo cadastrado caso não haja ele apresenta essa mensagem.
					if(arrayVoo[0] == null) {
						JOptionPane.showMessageDialog(null, "Nenhum vôo cadastrado");
						break;
					}
						
					//Solicita a posição do voo cadastrado
					int voo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do vôo cadastrado (0 a 9): "));
												
					//Mostra os lugares vazios
					JOptionPane.showMessageDialog(null, "Modelo da aeronave: \n" + arrayVoo[voo].getAeronave().getModelo() + "\n\nLugares Vazios: \n" + arrayVoo[voo].getAeronave().mostraLugaresVazios());
					break;
						
				case 3:						
					//Valida se existe um voo cadastrado caso não haja ele apresenta essa mensagem.
					if(arrayVoo[0] == null) {
						JOptionPane.showMessageDialog(null, "Nenhum vôo cadastrado");
						break;
					}
						
					//Solicita a posição do voo cadastrado
					int aviaoVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do vôo cadastrado (0 a 9): "));
						
					//Mostra os lugares reservados
					JOptionPane.showMessageDialog(null, "Modelo da aeronave: \n" + arrayVoo[aviaoVoo].getAeronave().getModelo() + "\n\nReservas Realizadas\n"+ arrayVoo[aviaoVoo].getAeronave().mostraLugaresOcupados());										
					break;
						
				case 4:
					//voltandoParaOMenuPrincipal
					break;
						
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida");
					break;
				}
					
			}while(escolhaMenuReserva != 4);
		}catch(NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Opção selecionada não é um numero: ");
        }
	}
	
	
	
	public static void sair() {
		JOptionPane.showMessageDialog(null, "Volte sempre!");
	}	
	
}//fechamento:MenuPrincipal
