package tg.controleprojeto.modelo.fachada;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.negocio.Projeto;
import tg.controleprojeto.persistencia.dao.ProjetoDAO;

public class ListaProjetosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// TODO Auto-generated method stub
		ProjetoDAO proj = new ProjetoDAO();
		List<Projeto> listaProjetos = proj.getLista();
		req.setAttribute("projetos", listaProjetos);
		return "lista-projetos.jsp";
	}
}	
