package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaExcluirOperador implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		req.setAttribute("email", email);
		return "WEB-INF/views/excluirOperador.jsp";
	}

}
