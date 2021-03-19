package view;

import java.util.List;

import controller.UsuarioController;
import model.Usuario;

public class Read {
	
	public void lerUsuario () {
		UsuarioController usuarioController = new UsuarioController();
		
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
