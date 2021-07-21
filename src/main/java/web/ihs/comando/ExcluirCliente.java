package web.ihs.comando;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;





public class ExcluirCliente implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String cpf = request.getParameter("cpf");
		ClientesDAO repositorio = new ClientesDAO();
		repositorio.excluir(cpf);
		return "controle?comando=GerenciarCliente";
	}
	
}
