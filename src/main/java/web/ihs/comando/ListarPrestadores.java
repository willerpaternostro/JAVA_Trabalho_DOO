package web.ihs.comando;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;



public class ListarPrestadores implements Comando{
	@Override
	public String executar (HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrestadorDAO repositorio = new PrestadorDAO ();
		
		request.setAttribute("prestadores", repositorio.getPrestadores());
		
		return"WEB-INF/visao/listarProdutos.jsp";
	}
	
}
