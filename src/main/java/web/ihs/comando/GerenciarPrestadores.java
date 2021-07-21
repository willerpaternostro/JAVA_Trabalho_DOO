package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;

public class GerenciarPrestadores implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		PrestadorDAO repositorio = new PrestadorDAO();
		
		req.setAttribute("prestadores", repositorio.getPrestadores());
		
		return "WEB-INF/views/gerenciarPrestadores.jsp";
	}
	

}
