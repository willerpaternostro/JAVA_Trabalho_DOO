package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaCadastroServico implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String msgErro =req.getParameter("msgErro");
		req.setAttribute("msgErro", msgErro);

		return "WEB-INF/views/cadastrarServico.jsp";
	}

}
