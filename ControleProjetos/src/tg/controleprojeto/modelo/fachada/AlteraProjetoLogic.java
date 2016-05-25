package tg.controleprojeto.modelo.fachada;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.negocio.Projeto;
import tg.controleprojeto.persistencia.dao.ProjetoDAO;

public class AlteraProjetoLogic implements Logica {

	public String executa(HttpServletRequest req, HttpServletResponse res) {
		int idProjeto = Integer.parseInt(req.getParameter("idProjeto"));
		ProjetoDAO projetoDAO = new ProjetoDAO();
		try {
			Projeto projeto = projetoDAO.busca(idProjeto);
			req.setAttribute("projeto", projeto);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "altera-projeto.jsp";
	}
	
}
