package testesJUnit;

import connectionBD.ConnectionMySQL;
import controller.UsuarioController;
import model.Usuario;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TestesDesafioCTT {
	
	@Test
	public void testeConnectionIsValid() throws SQLException {
		Connection conn = ConnectionMySQL.createConnectionMySQL();
		assertEquals(true, conn.isValid(0));
	}
	
	@Test
	public void testeCadastraUsuario() {
		UsuarioController usuarioController = new UsuarioController();
		Usuario usuario = new Usuario();
		LocalDate dataCadastro = LocalDate.now();
		usuario.setLogin("login@teste.com.br");
		usuario.setNome("Usuario Teste da Silva");
		usuario.setSenha("1234");
		usuario.setData_cadastro(dataCadastro);
		assertEquals(true, usuarioController.cadastroUsuario(usuario));
	}
	
	@Test
	public void testeReadUsuario() {
		List <Usuario> usuarios = new ArrayList<Usuario>();
		UsuarioController usuarioController = new UsuarioController();
		assertThat(usuarioController.selectUsuario(), instanceOf(usuarios.getClass()));
	}
	
	@Test
	public void testeUpdateUsuario() {
		UsuarioController usuarioController = new UsuarioController();
		Usuario usuario = new Usuario();
		LocalDate dataCadastro = LocalDate.now();
		usuario.setLogin("login@teste.com.br");
		usuario.setNome("Usuario Silva");
		usuario.setSenha("4251");
		usuario.setData_cadastro(dataCadastro);
		assertEquals(true, usuarioController.updateUsuario(usuario));
	}
	
	@Test
	public void testeDeleteUsuario() {
		UsuarioController usuarioController = new UsuarioController();
		Usuario usuario = new Usuario();
		usuario.setLogin("login@teste.com.br");
		assertEquals(true, usuarioController.deleteUsuario(usuario));
	}
}
