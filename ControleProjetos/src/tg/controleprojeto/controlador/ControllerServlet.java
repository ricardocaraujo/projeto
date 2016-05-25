package tg.controleprojeto.controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		
		String parametro = req.getParameter("logica");
		String nomeDaClasse = "tg.controleprojeto.modelo.fachada." + parametro;
		
		try {
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
