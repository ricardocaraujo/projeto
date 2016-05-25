package tg.controleprojeto.modelo.fachada;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import sun.java2d.pipe.SolidTextRenderer;
import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.excecao.ProjetoJaExiste;
import tg.controleprojeto.modelo.negocio.Empregado;
import tg.controleprojeto.modelo.negocio.Gerencia;
import tg.controleprojeto.modelo.negocio.Projeto;
import tg.controleprojeto.persistencia.dao.CoordenadorProjetoDAO;
import tg.controleprojeto.persistencia.dao.EmpregadoDAO;
import tg.controleprojeto.persistencia.dao.GerenciaDAO;
import tg.controleprojeto.persistencia.dao.ProjetoDAO;

public class AdicionaProjetoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Projeto projeto = new Projeto();
		projeto.setNomeProjeto(req.getParameter("nomeProjeto"));
		projeto.setObjetivo(req.getParameter("objetivo"));
		projeto.setJustificativa(req.getParameter("justificativa"));
		//projeto.setCoordenador(new EmpregadoDAO().busca(req.getParameter("coordenador")));
		projeto.setResponsavelTecnico(new EmpregadoDAO().busca(req.getParameter("responsavelTecnico")));
		projeto.setGerenciaCliente(new GerenciaDAO().busca(req.getParameter("gerenciaCliente")));
		projeto.setGerenciaExecutora(new GerenciaDAO().busca(req.getParameter("gerenciaExecutante")));
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendarInicio = Calendar.getInstance();
			calendarInicio.setTime(sdf.parse(req.getParameter("dataInicio")));
			projeto.setDataInicio(calendarInicio);
			Calendar calendarFim = Calendar.getInstance();
			calendarFim.setTime(sdf.parse(req.getParameter("dataTermino")));
			projeto.setDataFim(calendarFim);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String[] arrayCoordenadores = req.getParameterValues("coordenador");
		List<Empregado> coordenadores = new EmpregadoDAO().busca(arrayCoordenadores);
		projeto.setCoordenador(coordenadores);
		ProjetoDAO projetoDAO = new ProjetoDAO();
		try {
			projetoDAO.inserir(projeto);
		} catch (ClassNotFoundException e) {
			return "erro-inserir-projeto.jsp";
		} catch (ProjetoJaExiste e) {
			return "projeto-ja-existe.jsp";
		}
		Projeto projetoInserido = projetoDAO.busca(projeto.getNomeProjeto());
		int idProjeto = projetoInserido.getIdProjeto();
		projeto.setIdProjeto(idProjeto);
		new CoordenadorProjetoDAO().inserir(projeto);
		return "lista-projetos.jsp";
	}
}
