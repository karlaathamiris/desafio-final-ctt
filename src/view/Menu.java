package view;

import java.util.Scanner;

public class Menu {
	
	public void exibirMenu() {
		
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println("Bem vindo ao sistema de cadastro de usuários.");
		
		do {
			System.out.println("Por favor, escolha abaixo qual comando deseja afetuar:");
			System.out.println("\t1- Cadastrar\n\t2- Buscar\n\t3- Alterar\n\t4- Excluir\n\t0- SAIR DO PROGRAMA");
			opcao = sc.nextInt();
			
				switch(opcao) {
				
				case 0: 
					break;
				
				case 1:
					Create create = new Create();
					create.createUsuario();
				break;
				
				case 2: 
					Read read = new Read();
					read.lerUsuario();
				break;
				
				case 3: 
					Update update = new Update();
					update.alterarUsuario();
				break;
				
				case 4:
					Delete delete = new Delete();
					delete.deleteUsuario();
				break;
				
				default:
					System.out.println("ERRO: Comando inválido.");
				}  
		
		} while (opcao != 0);
	
		sc.close();
		System.out.println("Programa encerrado.");
	}
}
