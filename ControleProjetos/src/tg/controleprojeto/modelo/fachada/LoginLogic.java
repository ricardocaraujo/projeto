package tg.controleprojeto.modelo.fachada;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tg.controleprojeto.controlador.Logica;
import tg.controleprojeto.modelo.negocio.Usuario;
import tg.controleprojeto.persistencia.dao.UsuarioDAO;

public class LoginLogic implements Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws ClassNotFoundException, SQLException {
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().busca(nome, senha);
		if(usuario == null) {
			return "login.jsp";
		} else {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuario", usuario);
			return "lista-projetos.jsp";
		}	
	}

}
