package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaEditarCliente implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {

		String nome = req.getParameter("nome");
		req.setAttribute("nome", nome);
		String cpf = req.getParameter("cpf");
		req.setAttribute("cpf", cpf);
		System.out.println("CPF:"+cpf);
		String endereco = req.getParameter("endereco");
		req.setAttribute("endereco", endereco);
		
		
		String telefone = req.getParameter("telefone");
		req.setAttribute("telefone", telefone);
		
		return "WEB-INF/views/editarCliente.jsp";
	}
	
}
