package tg.controleprojeto.controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) {
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
	}

}
