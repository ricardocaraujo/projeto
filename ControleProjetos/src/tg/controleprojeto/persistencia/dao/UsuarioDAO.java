package tg.controleprojeto.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tg.controleprojeto.modelo.negocio.Usuario;

public class UsuarioDAO {
	
	public Usuario busca(String nome, String senha) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from usuario where nome = ? and senha = ?");
		stmt.setString(1, nome);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			return usuario;
		}
		return null;
	}

}
