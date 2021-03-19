package view;

import controller.UsuarioController;
import java.util.Scanner;
import model.Usuario;

public class Delete {
	
	public void deleteUsuario() {
		
		Scanner sc = new Scanner(System.in);
		UsuarioController usuarioController = new UsuarioController();
		
		Usuario userDelete = new Usuario();
		
		System.out.println("Para deletar um usuário, digite o login dele: ");
		String login = sc.nextLine();
		
		userDelete.setLogin(login);
		usuarioController.deleteUsuario(userDelete);
	}
}
