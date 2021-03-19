package controller;

import connectionBD.ConnectionMySQL;
import model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioController {
	
	public boolean cadastroUsuario(Usuario usuario) {
		
		String sql = "insert into usuarios_ctt (login, nome, senha, data_cadastro) values ('";
		sql += usuario.getLogin() +"', '";
		sql += usuario.getNome() +"', '";
		sql += usuario.getSenha() +"', '";
		sql += usuario.getData_cadastro() +"');";
		
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			statement =  conn.createStatement();
			
			statement.executeUpdate(sql);
			System.out.println("Usuário Cadastrado com Sucesso ");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	} 

	public List<Usuario> selectUsuario() {
		
		String sql = "select * from usuarios_ctt";
		List <Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rset = null;
		
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			statement = conn.createStatement();
			rset = statement.executeQuery(sql);
			
			while(rset.next()) {
				Usuario user = new Usuario();
				
				user.setId(rset.getInt("id"));
				user.setLogin(rset.getString("login"));
				user.setNome(rset.getString("nome"));
				Date date = rset.getDate("data_cadastro");
				LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
				user.setData_cadastro(localDate);
				
				usuarios.add(user);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally{
			
			try {
				if (rset != null) {
					rset.close();
				
				}if(statement != null){
					statement.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
		
	}	
	
	public boolean updateUsuario (Usuario usuario) {
		
		String sql = "update usuarios_ctt set";
		Connection conn = null;
		Statement statement = null;
		
		sql = sql + " nome='" + usuario.getNome() + "',";
		sql = sql + " senha='" + usuario.getSenha() + "'";
		sql = sql + " where login='" + usuario.getLogin() + "';";
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			statement =  conn.createStatement();
			
			statement.executeUpdate(sql);
			System.out.println("Cadastro do usuário atualizado com sucesso.");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean deleteUsuario (Usuario usuario) {
		
		String sql = "delete from usuarios_ctt where login='" + usuario.getLogin() + "';";
		
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			statement =  conn.createStatement();
			
			statement.executeUpdate(sql);
			System.out.println("Usuário deletado com sucesso.");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
				return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

