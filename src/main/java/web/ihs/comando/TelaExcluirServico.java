package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaExcluirServico implements Comando {
	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "WEB-INF/views/excluirServico.jsp";
	}

}
