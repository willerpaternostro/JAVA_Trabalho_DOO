package web.ihs.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.comando.Comando;

@WebServlet("/controle")
public class ControleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("comando");
		String nomeClasse = "web.ihs.comando." + cmd;
		
		try { 
			Class<?> classe = Class.forName(nomeClasse); 
			Comando comando = (Comando) classe.getConstructor().newInstance(); 
			String visao = comando.executar(request,response);
			if(request.getMethod().equalsIgnoreCase("post")) { 
				response.sendRedirect(visao);
			}else {
				request.getRequestDispatcher(visao).forward(request, response);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
