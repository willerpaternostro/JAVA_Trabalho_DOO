package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaCadastroPrestador implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String msgErro =req.getParameter("msgErro");
		req.setAttribute("msgErro", msgErro);
		return "WEB-INF/views/cadastrarPrestador.jsp";
	}

}
