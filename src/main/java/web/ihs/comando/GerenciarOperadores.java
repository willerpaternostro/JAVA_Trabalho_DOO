package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.OperadorDAO;

public class GerenciarOperadores implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {

		OperadorDAO repositorio = new OperadorDAO();
		
		req.setAttribute("operadores", repositorio.getOperadores());
		
		return "WEB-INF/views/gerenciarOperadores.jsp";
	}

}
