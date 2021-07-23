import java.util.Scanner;
import java.util.ArrayList;


public class ControleDeCadastro {

	static void linhas() {
		char linha = '=';
		
		for(int i = 0; i < 40; i++) {
			System.out.print(linha);		
		}
	}
	
	static void menu() {
		linhas();
		System.out.print("\n          ");
		System.out.println("Controle de cadastro"); 
		linhas();
		
		System.out.println("\nMenu de opções:"
				+ "\n1 - Cadastro de novo cliente"
				+ "\n2 - Busca por cliente"
				+ "\n3 - Cadastro de novo produto"
				+ "\n4 - Busca por produto"
				+ "\n5 - Cadastro de venda"
				+ "\n6 - Verificar produtos em estoque"
				+ "\n7 - Sair do programa");
	}
	
	
	
	public static void main(String[] args) {
		int opcao;
		
		Scanner ler = new Scanner(System.in);
		
		do {
			menu();
			
			
			System.out.println("\nDigite sua opção");
			System.out.print(">> ");
			
			opcao = ler.nextInt();
			
			switch (opcao) {
			case 7: System.out.println("\nEncerrando o programa...");
					try { Thread.sleep (1500); } catch (InterruptedException ex) {}
					System.out.println("FIM");
					break;
			
			default: System.out.println("Opção inválida!");
					 break;
			}
			
		}while(opcao != 7);

	}

}
