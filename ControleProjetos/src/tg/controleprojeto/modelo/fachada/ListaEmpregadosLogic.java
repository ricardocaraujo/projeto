package tg.controleprojeto.modelo.fachada;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.negocio.Empregado;
import tg.controleprojeto.persistencia.dao.EmpregadoDAO;

public class ListaEmpregadosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<Empregado> empregados = new ArrayList<Empregado>();
		empregados = new EmpregadoDAO().getLista();
		req.setAttribute("empregados", empregados);
		return "lista-empregados.jsp";
	}

}
