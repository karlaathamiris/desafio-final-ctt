package connectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	
	
	public static Connection createConnectionMySQL() throws SQLException {
		Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo_base_dados", "root", "1234567r");
		System.out.println("Conectado ao banco de dados.");
		return conexao;		
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection con = createConnectionMySQL();
		if(con != null) {
			con.close();
		}
	}


}
