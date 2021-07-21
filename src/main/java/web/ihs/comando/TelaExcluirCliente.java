package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaExcluirCliente implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String cpf = req.getParameter("cpf");
		req.setAttribute("cpf", cpf);
		return "WEB-INF/views/excluirCliente.jsp";
	}
	
}
