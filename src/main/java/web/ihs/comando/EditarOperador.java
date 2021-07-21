package web.ihs.comando;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.OperadorDAO;
import web.ihs.modelo.Operador;



public class EditarOperador implements Comando {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		if(email.equals("") || senha.equals("") || nome.equals("")) {
			String msgErro = "Todos os campos sao obrigatorios";
			String campos = "";
			if(!nome.equals(""))campos += "&nome="+nome;
			if(!email.equals(""))campos += "&email="+email;
			if(!senha.equals(""))campos += "&senha="+senha;
			return "controle?comando=TelaEditarOperador&msgErro="+msgErro+campos;
		}
	
		Operador operador = new Operador(email,nome,senha);
		OperadorDAO repositorio = new OperadorDAO();
		
		repositorio.atualizar(operador);
		  
		return "controle?comando=GerenciarOperadores";
	}
}
