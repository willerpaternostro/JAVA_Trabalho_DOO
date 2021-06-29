package web.ihs.comando.operador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.comando.Comando;

public class LoginForm implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return "WEB-INF/views/login.jsp";
	}
}
