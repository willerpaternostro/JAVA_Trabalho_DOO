package web.ihs.comando;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;

public class ExcluirServico implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		ServicoDAO repositorio = new ServicoDAO();
		repositorio.excluir(id);
		return "controle?comando=GerenciarServicos";
	}


}
