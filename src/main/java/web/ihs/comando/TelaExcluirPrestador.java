package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaExcluirPrestador implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String documento = req.getParameter("documento");
		req.setAttribute("documento", documento);
		return "WEB-INF/views/excluirPrestador.jsp";
	}
	
}
