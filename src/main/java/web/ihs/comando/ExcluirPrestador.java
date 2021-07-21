package web.ihs.comando;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;


public class ExcluirPrestador implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String documento = request.getParameter("documento");
		System.out.println("DOCUMENTO:"+documento);
		PrestadorDAO repositorio = new PrestadorDAO();
		repositorio.excluir(documento);
		return "controle?comando=GerenciarPrestadores";
	}

}
