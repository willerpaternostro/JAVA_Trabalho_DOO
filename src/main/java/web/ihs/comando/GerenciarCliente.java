package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;


public class GerenciarCliente implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ClientesDAO repositorio = new ClientesDAO();
		
		request.setAttribute("clientes", repositorio.getClientes());
		
		return "WEB-INF/views/gerenciarClientes.jsp";
	}
	
}
