package tg.controleprojeto.modelo.fachada;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.persistencia.dao.ProjetoDAO;


public class RemoveProjetoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		int idProjeto = Integer.parseInt(req.getParameter("projetoId"));
		try {
			new ProjetoDAO().remove(idProjeto);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
