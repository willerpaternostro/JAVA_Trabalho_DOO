package web.ihs.comando.operador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.comando.Comando;

public class GerenciarCliente implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "WEB-INF/gerenciarCliente.jsp";
	}
	
}
