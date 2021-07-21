package web.ihs.comando;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.OperadorDAO;


public class ExcluirOperador implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String email = request.getParameter("email");
		OperadorDAO repositorio = new OperadorDAO();
		repositorio.excluir(email);
		return "controle?comando=GerenciarOperadores";
	}
}
