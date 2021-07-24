import java.util.Scanner;
import java.util.ArrayList;


public class ControleDeCadastro {
	
	static void sleep(int seg) {
		try { Thread.sleep(seg); } catch (InterruptedException ex) {}
	}

	static void linhas(char linha) {
		
		for(int i = 0; i < 50; i++) {
			System.out.print(linha);		
		}
		System.out.println();
	}
	
	static void menu() {
		titulo("Controle de cadastro");
		
		System.out.println("Menu de opções:"
				+ "\n1 - Cadastro de novo cliente"
				+ "\n2 - Busca por cliente"
				+ "\n3 - Cadastro de novo produto"
				+ "\n4 - Busca por produto"
				+ "\n5 - Cadastro de venda"
				+ "\n6 - Verificar produtos em estoque"
				+ "\n7 - Sair do programa");
	}
	
	static void titulo(String titulo) {
		int tam = 50 - titulo.length();
		
		linhas('=');
		for(int i = 0; i < (tam/2); i++) {
			System.out.print(" ");
		}
		System.out.println(titulo); 
		linhas('=');
	}
	
	
	public static ArrayList<ArrayList<String>> clientes = new ArrayList<ArrayList<String>>();
	public static ArrayList<String> cliente = new ArrayList<>();
	
	
	public static ArrayList<ArrayList<String>> preListaDeClientes() {
		String[] nomesAleat = {"João", "Maria", "Matheus", "Regina", "Monica",
				"Fred Flintstone", "Naruto Uzumaki", "Neymar Junior", "Lionel Messi", "Cristiano Ronaldo"};
		
		String[] enderecoAleat = {"Rua das Flores 86", "Av. São Bernardo 50", "Rua Tupinambá casa 2",
				"Beco Lira Nunes n° 25", "Bairro do Limoeiro","Bedrock casa 10" , "Aldeia da Folha",
				"24 rue du Commandant Guilbaud", "Carrer d´Aristides Maillol, entrance n° 7", "Corso Gaetano Scirea, 50"};
		
		String[] telefoneAleat = {"992434155", "984125627", "972115540", "999901234",
				"40028922", "33213030", "31364217", "967248266", "953663774", "997626926"};
		
		
		for (int i = 0; i < nomesAleat.length; i++) {
			cliente.add(nomesAleat[i]);
			cliente.add(enderecoAleat[i]);
			cliente.add(telefoneAleat[i]);
			
			clientes.add((ArrayList<String>) cliente.clone());
			cliente.removeAll(cliente);
		}
		
		return clientes;
	}
	
	
	public static void main(String[] args) {
		int opcao = 0, qtd;
		String nome;
		String endereco;
		String telefone;
		
		clientes = preListaDeClientes();

		Scanner ler = new Scanner(System.in);
		
		do {
			menu();
			linhas('-');
			
			System.out.println("Digite sua opção");
			System.out.print(">> ");
			
			opcao = ler.nextInt();
			ler.nextLine();
			
			switch (opcao) {
			case 1: {
				titulo("Cadastro de Cliente");
				System.out.print("Quantos clientes deseja cadastrar? ");
				qtd = ler.nextInt();
				ler.nextLine();
				
				for(int i = 0; i< qtd; i++) {
					System.out.print("\nInforme o nome do novo cliente: ");
					nome = ler.nextLine();
					cliente.add(nome);
					
					System.out.print("Informe o endereço do cliente: ");
					endereco = ler.nextLine();
					cliente.add(endereco);
					
					System.out.print("Informe o telefone do cliente (apenas números): ");
					telefone = ler.nextLine();
					cliente.add(telefone);
					
					clientes.add((ArrayList<String>) cliente.clone());
					cliente.removeAll(cliente);
				}
				System.out.println("Voltando ao menu inicial...");
				sleep(1500);
				
				break;
			}
			case 2: {
				titulo("Busca por cliente");
				boolean check = false;
				int pos = 0, son, opc;
				String alteraNome, alteraEnd, alteraTel;

				System.out.print("Nome completo do cliente que deseja encontrar: ");
				nome = ler.nextLine();
				
				for (int i = 0; i < clientes.size(); i++) {
					if (nome.equals(clientes.get(i).get(0))) {
						check = true;
						pos = i;
						break;
					}else {
						if(i == clientes.size()-1) {
							sleep(1500);
							System.out.println("\nCliente não encontrado!");
							check = false;
						}
					}
				}
				sleep(1000);
				
				if (check) {
					System.out.println("\n-> Dados do cliente:");
					System.out.println("- Nome do cliente: " + clientes.get(pos).get(0));
					System.out.println("- Endereço: " + clientes.get(pos).get(1));
					System.out.println("- Telefone: " + clientes.get(pos).get(2));
					do {
						linhas('-');
						System.out.print("Deseja alterar algum dado? [1-SIM | 2-NÃO]: ");
						son = ler.nextInt();
						
						if(son == 2) {
							sleep(1000);
						}
						else if (son == 1) {
							System.out.printf("\n-> Alterar dados de %s:"
									+ "\n1- Nome"
									+ "\n2- Endereço"
									+ "\n3- Telefone", clientes.get(pos).get(0));
							System.out.print("\n>> ");
							opc = ler.nextInt();
							ler.nextLine();
							
							if(opc == 1) {
								System.out.print("\nNovo nome do cliente: ");
								alteraNome = ler.nextLine();
								
								clientes.get(pos).set(0, alteraNome);
							}
							else if(opc == 2) {
								System.out.print("\nNovo endereço do cliente: ");
								alteraEnd = ler.nextLine();
			
								clientes.get(pos).set(1, alteraEnd);
							}
							else if(opc == 3) {
								System.out.print("\nNovo telefone do cliente: ");
								alteraTel = ler.nextLine();
								
								clientes.get(pos).set(2, alteraTel);
							}
							
						}
					}while(son == 1);
				}
				System.out.println("Voltando ao menu inicial...");
				sleep(1500);
				
				break;
			}
			case 7: {				
				System.out.println("\nEncerrando o programa...");
				sleep(1500);
				System.out.println("FIM");
				break;
			}
			
			default: {
				System.out.println("Opção inválida!");
				sleep(1500);
				break;
			}
			
			}
			
		}while(opcao != 7);

	}

}
