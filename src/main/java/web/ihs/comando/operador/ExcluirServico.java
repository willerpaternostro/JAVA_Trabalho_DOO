package web.ihs.comando.operador;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;
import web.ihs.comando.Comando;

public class ExcluirServico implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("documento"));
		ServicoDAO repositorio = new ServicoDAO();
		repositorio.excluir(id);
		return "controle?comando=ListarProdutos";
	}


}
