package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaEditarOperador implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String email = req.getParameter("email");
		req.setAttribute("email", email);
		String nome = req.getParameter("nome");
		req.setAttribute("nome", nome);
		String senha = req.getParameter("senha");
		req.setAttribute("senha", senha);
		return "WEB-INF/views/editarOperador.jsp";
	}
}
