package tg.controleprojeto.persistencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import tg.controleprojeto.modelo.excecao.ProjetoJaExiste;
import tg.controleprojeto.modelo.negocio.Empregado;
import tg.controleprojeto.modelo.negocio.Gerencia;
import tg.controleprojeto.modelo.negocio.Projeto;

public class ProjetoDAO {
	
	/*private Connection con;
	
	public ProjetoDAO() throws ClassNotFoundException {
		this.con = BDConnectionFactory.getConnection();
	}*/
	
	public void inserir(Projeto projeto) throws ClassNotFoundException, ProjetoJaExiste, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		if(this.busca(projeto.getNomeProjeto()) == null) {
			String sql = "insert into projeto(nome, objetivo, justificativa,"
					+ "data_inicio, data_fim, responsavel_tecnico, gerencia_cliente,"
					+ "gerencia_executante) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, projeto.getNomeProjeto());
			stmt.setString(2, projeto.getObjetivo());
			stmt.setString(3, projeto.getJustificativa());
			stmt.setDate(4, new java.sql.Date(projeto.getDataInicio().getTimeInMillis()));
			stmt.setDate(5, new java.sql.Date(projeto.getDataFim().getTimeInMillis()));
			stmt.setInt(6, projeto.getResponsavelTecnico().getId());
			stmt.setInt(7, projeto.getGerenciaCliente().getId());
			stmt.setInt(8, projeto.getGerenciaExecutora().getId());
			stmt.execute();
			stmt.close();
		} else {
			throw new ProjetoJaExiste("Já existe projeto com este nome");
		}
	}
	
	public List<Projeto> getLista() throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		/*PreparedStatement stmt = con.prepareStatement("SELECT projeto.*, empregado.* FROM projeto "
				+ "JOIN coordenador_projeto ON projeto.idprojeto = coordenador_projeto.projeto JOIN empregado "
				+ "ON coordenador_projeto.coordenador = empregado.idempregado");*/
		PreparedStatement stmt = con.prepareStatement("SELECT * from projeto");
		ResultSet rs = stmt.executeQuery();
		List<Projeto> projetos = this.constroiListaProjetos(rs);
		rs.close();
		stmt.close();
		return projetos;
	}
	
	public void remove(int id) throws SQLException, ClassNotFoundException  {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("delete from projeto where idprojeto = ?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();	
	}
	
	public Projeto busca(int idProjeto) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from projeto where idprojeto = ?");
		stmt.setInt(1, idProjeto);
		ResultSet rs = stmt.executeQuery();
		Projeto projeto = this.constroiProjeto(rs);
		stmt.close();
		con.close();
		return projeto;
	}
	
	public Projeto busca(String nome) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from projeto where nome = ?");
		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();
		Projeto projeto = this.constroiProjeto(rs);
		stmt.close();
		con.close();
		return projeto;
	}
	
	private Projeto constroiProjeto(ResultSet rs) throws SQLException, ClassNotFoundException {
		Projeto projeto = null;
		if(rs.next()) {
			projeto = new Projeto();
			int idProjeto = rs.getInt("idprojeto");
			projeto.setIdProjeto(idProjeto);
			projeto.setNomeProjeto(rs.getString("nome"));
			projeto.setObjetivo(rs.getString("objetivo"));
			projeto.setJustificativa(rs.getString("justificativa"));
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(rs.getDate("data_inicio"));
			projeto.setDataInicio(dataInicio);
			Calendar dataFim = Calendar.getInstance();
			dataFim.setTime(rs.getDate("data_fim"));
			projeto.setDataFim(dataFim);
			int idResponsavelTecnico = rs.getInt("responsavel_tecnico");
			projeto.setResponsavelTecnico(new EmpregadoDAO().busca(idResponsavelTecnico));
			int idGerenciaCliente = rs.getInt("gerencia_cliente");
			projeto.setGerenciaCliente(new GerenciaDAO().busca(idGerenciaCliente));
			int idGerenciaExecutora = rs.getInt("gerencia_executante");
			projeto.setGerenciaExecutora(new GerenciaDAO().busca(idGerenciaExecutora));
			List<Empregado> coordenadores = new EmpregadoDAO().getCoordenadores(idProjeto);
			projeto.setCoordenador(coordenadores);
		}
		return projeto;
	}
	
	private List<Projeto> constroiListaProjetos(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Projeto> projetos = new ArrayList<Projeto>();
		while(rs.next()) {
			Projeto projeto = new Projeto();
			int idProjeto = rs.getInt("idprojeto");
			projeto.setIdProjeto(idProjeto);
			projeto.setNomeProjeto(rs.getString("nome"));
			projeto.setObjetivo(rs.getString("objetivo"));
			projeto.setJustificativa(rs.getString("justificativa"));
			Calendar dataInicio = Calendar.getInstance();
			dataInicio.setTime(rs.getDate("data_inicio"));
			projeto.setDataInicio(dataInicio);
			Calendar dataFim = Calendar.getInstance();
			dataFim.setTime(rs.getDate("data_fim"));
			projeto.setDataFim(dataFim);
			int idResponsavelTecnico = rs.getInt("responsavel_tecnico");
			projeto.setResponsavelTecnico(new EmpregadoDAO().busca(idResponsavelTecnico));
			int idGerenciaCliente = rs.getInt("gerencia_cliente");
			projeto.setGerenciaCliente(new GerenciaDAO().busca(idGerenciaCliente));
			int idGerenciaExecutora = rs.getInt("gerencia_executante");
			projeto.setGerenciaExecutora(new GerenciaDAO().busca(idGerenciaExecutora));
			List<Empregado> coordenadores = new EmpregadoDAO().getCoordenadores(idProjeto);
			projeto.setCoordenador(coordenadores);
			projetos.add(projeto);
		}
		return projetos;
	}
	
	/*public void altera(Projeto projeto) {
		
	}*/

}
