package tg.controleprojeto.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tg.controleprojeto.modelo.negocio.Usuario;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		String parametro = req.getParameter("logica");
		
		if(usuario == null && !parametro.equals("LoginLogic")) {
			req.getRequestDispatcher("login.jsp").forward(req, res);
		} else {
			try {
				String nomeDaClasse = "tg.controleprojeto.modelo.fachada." + parametro;
				
				Class<?> classe = Class.forName(nomeDaClasse);
				Logica logica = (Logica) classe.newInstance();
				
				String pagina = logica.executa(req, res);
				
				// para os casos em que for utilizada chamada ajax
				if(pagina != null) {
					req.getRequestDispatcher(pagina).forward(req, res);
				}
			} catch (Exception e) {
				throw new ServletException("Erro na lógica de negócios", e);
			}
		}	
	}
}
