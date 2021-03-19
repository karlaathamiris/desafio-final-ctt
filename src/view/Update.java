package view;

import java.time.LocalDate;
import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;

public class Update {

	public void alterarUsuario() {
		
		Scanner sc = new Scanner(System.in);
		
		UsuarioController usuarioController = new UsuarioController();
		
		Usuario user = new Usuario();
		System.out.println("Informe o Login do usuário que deseja alterar os dados: ");
		String loginUpdate = sc.nextLine();
//		int id = sc.nextInt();
//		sc.nextLine();
//		System.out.println("Digite o novo login: ");
		
		System.out.println("Digite o novo nome: ");
		String nomeUpdate = sc.nextLine();
	
		System.out.println("Digite a nova senha: ");
		String senhaUpdate = sc.nextLine();
	
		LocalDate dataCadastroUpdate = LocalDate.now();
		
		// user.setId(id);
		user.setLogin(loginUpdate);
		user.setNome(nomeUpdate);
		user.setSenha(senhaUpdate);
		user.setData_cadastro(dataCadastroUpdate);
		usuarioController.updateUsuario(user);
	}
}
