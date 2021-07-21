package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;

public class GerenciarServicos implements Comando {

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ServicoDAO repositorio = new ServicoDAO();
		
		req.setAttribute("servicos", repositorio.getServicos());
		
		return "WEB-INF/views/gerenciarServicos.jsp";
	}

}
