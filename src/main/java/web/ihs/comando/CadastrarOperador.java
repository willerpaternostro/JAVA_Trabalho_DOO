package web.ihs.comando;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.OperadorDAO;
import web.ihs.modelo.Operador;


public class CadastrarOperador implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(email.equals("") || senha.equals("")) {
			String msgErro = "Email e senha sao obrigatorios";
			return "controle?comando=TelaCadastroOperador&msgErro="+msgErro;
		}
	
		Operador operador = new Operador(email,nome,senha);
		OperadorDAO repositorio = new OperadorDAO();
		
		repositorio.cadastrar(operador);
		
		return "controle?comando=GerenciarOperadores";
		
	}
}
