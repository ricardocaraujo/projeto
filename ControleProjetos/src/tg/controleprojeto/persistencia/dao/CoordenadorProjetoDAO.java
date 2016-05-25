package tg.controleprojeto.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tg.controleprojeto.modelo.negocio.Empregado;
import tg.controleprojeto.modelo.negocio.Projeto;

public class CoordenadorProjetoDAO {
	
	public void inserir(Projeto projeto) throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		List<Empregado> coordenadores = projeto.getCoordenador();
		String sql = "insert into coordenador_projeto(projeto, coordenador) values (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		for(Empregado coordenador:coordenadores) {
			stmt.setInt(1, projeto.getIdProjeto());
			stmt.setInt(2, coordenador.getId());
			stmt.execute();
		}
		stmt.close();
		con.close();
	}
	
	public List<Empregado> getLista() throws ClassNotFoundException, SQLException {
		Connection con = BDConnectionFactory.getConnection();
		List<Empregado> coordenadores = new ArrayList<Empregado>();
		PreparedStatement stmt = con.prepareStatement("select * from coordenador_projeto");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Empregado coordenador = new Empregado();
			coordenador.setId(rs.getInt("idcoordenador_projeto"));
			coordenador.setNome(rs.getString("coordenador"));
			coordenadores.add(coordenador);
		}
		return coordenadores;
	}	
}
