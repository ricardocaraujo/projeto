package tg.controleprojeto.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost/projetos_tg", "postgres", "r1card0a");
	}

/*	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection conexao = DriverManager.getConnection(
				"jdbc:postgresql://localhost/controle_projetos", "postgres", "r1card0a");
		System.out.println("Conectado");
		conexao.close();
	}*/
}
