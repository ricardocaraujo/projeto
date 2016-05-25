package tg.controleprojeto.modelo.fachada;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.negocio.Empregado;
import tg.controleprojeto.persistencia.dao.EmpregadoDAO;


public class AdicionaEmpregadoLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException  {
		Empregado empregado = new Empregado();
		empregado.setNome(req.getParameter("nome"));
		try {
			new EmpregadoDAO().adiciona(empregado);
		} catch (Exception e) {
			
		}
		
		return "lista-empregado.html";
	}
}
