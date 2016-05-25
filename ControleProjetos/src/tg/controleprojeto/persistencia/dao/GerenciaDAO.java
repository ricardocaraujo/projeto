package tg.controleprojeto.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tg.controleprojeto.modelo.negocio.Gerencia;

public class GerenciaDAO {
	
	/*private Connection con;
	
	public GerenciaDAO() throws ClassNotFoundException {
		this.con = BDConnectionFactory.getConnection();
	}*/
	
	public void insere(Gerencia gerencia) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		String sql = "insert into gerencia(nome) values (?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, gerencia.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Gerencia busca(String nome) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from gerencia where nome = ?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			Gerencia gerencia = new Gerencia();
			if(rs.next()) {
				gerencia.setId(rs.getInt("idgerencia"));
				gerencia.setNome(rs.getString("nome"));
			}
			rs.close();
			stmt.close();
			return gerencia;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); 
		}
	}
	
	public Gerencia busca(int id) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from gerencia where idgerencia = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Gerencia gerencia = new Gerencia();
			if(rs.next()) {
				gerencia.setId(rs.getInt("idgerencia"));
				gerencia.setNome(rs.getString("nome"));
			}
			rs.close();
			stmt.close();
			return gerencia;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Gerencia> getLista() throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from gerencia");
			ResultSet rs = stmt.executeQuery();
			List<Gerencia> gerencias = new ArrayList<Gerencia>();
			while(rs.next()) {
				Gerencia gerencia = new Gerencia();
				gerencia.setId(rs.getInt("idgerencia"));
				gerencia.setNome(rs.getString("nome"));
				gerencias.add(gerencia);
			}
			rs.close();
			stmt.close();
			return gerencias;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e); 
		}
	}
	

}
