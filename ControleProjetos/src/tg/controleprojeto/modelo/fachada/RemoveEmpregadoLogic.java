package tg.controleprojeto.modelo.fachada;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.negocio.Empregado;
import tg.controleprojeto.persistencia.dao.EmpregadoDAO;

public class RemoveEmpregadoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Empregado emp = new Empregado(req.getParameter("nome"));
		new EmpregadoDAO().remove(emp);
		return "mvc?logica=ListaEmpregadosLogic";
	}

}
