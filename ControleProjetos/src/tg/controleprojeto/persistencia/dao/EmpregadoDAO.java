package tg.controleprojeto.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;














import tg.controleprojeto.modelo.negocio.Empregado;

public class EmpregadoDAO {
	
	/*private Connection con;
	
	public EmpregadoDAO() throws ClassNotFoundException  {
		con = BDConnectionFactory.getConnection();
	}*/
	
	public void adiciona(Empregado empregado) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		String sql = "insert into empregado(nome)"
				+ "values (?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, empregado.getNome());
		stmt.execute();
		stmt.close();
	}
	
	public List<Empregado> busca(String[] empregados) throws ClassNotFoundException, SQLException {
		List<Empregado> listaEmpregados = new ArrayList<Empregado>();
		for(String empregado:empregados) {
			listaEmpregados.add(this.busca(empregado));
		}
		return listaEmpregados;
	}
	
	public Empregado busca(String nome) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from empregado where nome=?");			
		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();
		Empregado empregado = this.constroiEmpregado(rs);
		rs.close();
		stmt.close();
		return empregado;
	}
	
	public Empregado busca(int id) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from empregado where idempregado=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		Empregado empregado = this.constroiEmpregado(rs);
		rs.close();
		stmt.close();
		return empregado;
	}
	
	public List<Empregado> getLista() throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		List<Empregado> empregados = new ArrayList<Empregado>();
		PreparedStatement stmt = con.prepareStatement("select * from empregado");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Empregado empregado = new Empregado();
			empregado.setId(rs.getInt("idempregado"));
			empregado.setNome(rs.getString("nome"));
			empregados.add(empregado);
		}
		rs.close();
		stmt.close();
		return empregados;
	}
	
	public List<Empregado> getCoordenadores(int idProjeto) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("select empregado.* from empregado join coordenador_projeto "
				+ "on empregado.idempregado = coordenador_projeto.coordenador join projeto on "
				+ "coordenador_projeto.projeto = projeto.idprojeto and projeto.idprojeto = ?");
		stmt.setInt(1, idProjeto);
		ResultSet rs = stmt.executeQuery();
		List<Empregado> coordenadores = this.constroiListaEmpregados(rs);
		rs.close();
		stmt.close();
		return coordenadores;
	}
	
	public void remove(Empregado empregado) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("delete from empregado where nome = ?");
		stmt.setString(1, empregado.getNome());
		stmt.execute();
		stmt.close();
	}
	
	private Empregado constroiEmpregado(ResultSet rs) throws SQLException {
		Empregado empregado = new Empregado();
		if(rs.next()) {			
			empregado.setId(rs.getInt("idempregado"));
			empregado.setNome(rs.getString("nome"));
		}
		return empregado;
	}
	
	private List<Empregado> constroiListaEmpregados(ResultSet rs) throws SQLException {
		List<Empregado> empregados = new ArrayList<Empregado>();
		while(rs.next()) {
			Empregado empregado = new Empregado();
			empregado.setId(rs.getInt("idempregado"));
			empregado.setNome(rs.getString("nome"));
			empregados.add(empregado);
		}
		return empregados;
	}
	
	/*public void altera(Empregado empregado) throws ClassNotFoundException {
		Connection con = BDConnectionFactory.getConnection();
	}*/
	
}
