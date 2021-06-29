package web.ihs.comando.operador;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;
import web.ihs.comando.Comando;


public class ExcluirPrestador implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String documento = request.getParameter("documento");
		PrestadorDAO repositorio = new PrestadorDAO();
		repositorio.excluir(documento);
		return "controle?comando=ListarProdutos";
	}

}
