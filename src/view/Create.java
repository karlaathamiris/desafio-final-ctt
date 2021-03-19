package view;

import java.time.LocalDate;
import java.util.Scanner;

import controller.UsuarioController;
import model.Usuario;

public class Create {
	public void createUsuario() {
		
		Scanner sc = new Scanner(System.in);
		
		UsuarioController usuarioController = new UsuarioController();
		
		Usuario usuario = new Usuario();
		
		System.out.println("Insira seu login (seu e-mail): ");
		String login = sc.nextLine();
		System.out.println("Seu nome: ");
		String nome = sc.nextLine();
		System.out.println("Agora sua senha: ");
		String senha = sc.nextLine();
		
	
		
		LocalDate dataCadastro = LocalDate.now();
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setData_cadastro(dataCadastro);
		usuarioController.cadastroUsuario(usuario);
	}
}
