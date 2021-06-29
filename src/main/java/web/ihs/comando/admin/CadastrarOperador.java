package web.ihs.comando.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.OperadorDAO;
import web.ihs.comando.Comando;
import web.ihs.modelo.Operador;


public class CadastrarOperador implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Operador operador = new Operador(nome,email,senha);
		OperadorDAO repositorio = new OperadorDAO();
		
		repositorio.cadastrar(operador);
		
		return "controle?comando=CadastroForm";
		
	}
}
