package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuRelatorios implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		
		return "WEB-INF/views/menuRelatorios.jsp";
	}

}
