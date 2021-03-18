package aplicacao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.Usuario;
import usuarioController.UsuarioController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UsuarioController usuarioController = new UsuarioController();
		
		//inicio cadastro
		
		Usuario usuario = new Usuario();
		
		System.out.println("Insira seu login (seu e-mail): ");
		String login = sc.next();
		System.out.println("Seu nome: ");
		String nome = sc.next();
		System.out.println("Agora sua senha: ");
		String senha = sc.next();
	
		
		LocalDate dataCadastro = LocalDate.now();
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setData_cadastro(dataCadastro);
		usuarioController.cadastroUsuario(usuario);
//		fim cadastro
		
		
		//inicio select
		List <Usuario> usuarios = usuarioController.selectUsuario();
		for(Usuario usuarioElemento : usuarios) {
			System.out.println("\tId: " + usuarioElemento.getId());
			System.out.println("\tLogin: " + usuarioElemento.getLogin());
			System.out.println("\tNome: " + usuarioElemento.getNome());
			System.out.println("\tData de cadastro: " + usuarioElemento.getData_cadastro());
			System.out.println("\n---------------------------------------------------------\n");
		}
		//fim select
		
		//inicio update
		Usuario user = new Usuario();
		System.out.println("Informe o ID do usuário que deseja alterar os dados: ");
		int id = sc.nextInt();
		
		System.out.println("Digite o novo login: ");
		String loginUpdate = sc.next();
		
		System.out.println("Digite o novo nome: ");
		String nomeUpdate = sc.next();
	
		System.out.println("Digite a nova senha: ");
		String senhaUpdate = sc.next();
	
		LocalDate dataCadastroUpdate = LocalDate.now();
		
		user.setId(id);
		user.setLogin(loginUpdate);
		user.setNome(nomeUpdate);
		user.setSenha(senhaUpdate);
		user.setData_cadastro(dataCadastroUpdate);
		usuarioController.updateUsuario(user);
		//fim update
		
		//inicio delete
		Usuario userDelete = new Usuario();
		System.out.println("Para deletar um usuário, digite o ID dele: ");
		int idDelete = sc.nextInt();
		
		userDelete.setId(idDelete);
		usuarioController.deleteUsuario(userDelete);
		
		sc.close();
	}		
}
