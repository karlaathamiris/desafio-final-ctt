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
		
		Usuario usuario = new Usuario();
		
		String login = sc.next();
		String nome = sc.next();
		String senha = sc.next();
		sc.close();
		
		LocalDate dataCadastro = LocalDate.now();
		
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setData_cadastro(dataCadastro);
		usuarioController.cadastroUsuario(usuario);
		
		List <Usuario> usuarios = usuarioController.selectUsuario();
		for(Usuario usuarioElemento : usuarios) {
			System.out.println("\tId: " + usuarioElemento.getId());
			System.out.println("\tLogin: " + usuarioElemento.getLogin());
			System.out.println("\tNome: " + usuarioElemento.getNome());
			System.out.println("\tData de cadastro: " + usuarioElemento.getData_cadastro());
			System.out.println("\n---------------------------------------------------------\n");
		}
	}

}
