package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String erro =req.getParameter("erro");
		String msgErro =req.getParameter("msgErro");
		req.setAttribute("erro", erro);
		req.setAttribute("msgErro", msgErro);
		return "WEB-INF/views/login.jsp";
	}
}
