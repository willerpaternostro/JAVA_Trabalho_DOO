package web.ihs.comando.operador;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;
import web.ihs.comando.Comando;
import web.ihs.modelo.Cliente;



public class CadastrarCliente implements Comando{
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
	
		Cliente cliente = new Cliente(nome,cpf,endereco,telefone);
	
		ClientesDAO repositorio = new ClientesDAO();
		repositorio.cadastrar(cliente);
		
		return "controle?comando=CadastroForm";
		
	}

}
