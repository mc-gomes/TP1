import java.util.Scanner;

public class ControleDeCadastro {

	static void linhas() {
		char linha = '=';
		
		for(int i = 0; i < 40; i++) {
			System.out.print(linha);		
		}
	}
	
	static void menu() {
		System.out.println("\nMenu de opções:"
				+ "\n1 - Cadastro de novo cliente"
				+ "\n2 - Busca por cliente"
				+ "\n3 - Cadastro de novo produto"
				+ "\n4 - Busca por produto"
				+ "\n5 - Cadastro de venda"
				+ "\n6 - Verificar produtos em estoque"
				+ "\n7 - Sair do menu");
	}
	
	public static void main(String[] args) {
		int opcao;
		
		linhas();
		System.out.println("\nControle de cadastro"); 
		linhas();
		
		menu();
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("\nDigite sua opção");
		System.out.print(">> ");
		
		opcao = ler.nextInt();

	}

}
