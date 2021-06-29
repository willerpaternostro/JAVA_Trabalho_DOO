package web.ihs.comando.operador;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;
import web.ihs.comando.Comando;



public class ListarClientes implements Comando{
	@Override
	public String executar (HttpServletRequest request, HttpServletResponse response) throws Exception{
		ClientesDAO repositorio = new ClientesDAO();
		
		request.setAttribute("clientes", repositorio.getClientes());
		
		return"WEB-INF/visao/listarProdutos.jsp";
	}
}
