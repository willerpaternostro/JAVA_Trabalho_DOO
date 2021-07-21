package web.ihs.comando;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;
import web.ihs.modelo.Cliente;



public class CadastrarCliente implements Comando{
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		if(nome.equals("")||cpf.equals("")) {
			String msgErro = "Nome e CPF sao obrigatorios";
			String campos="";
			if(!nome.equals(""))campos += "&nome="+nome;
			if(!cpf.equals(""))campos += "&cpf="+cpf;
			return "controle?comando=TelaCadastroCliente&msgErro="+msgErro+campos;
		}
		
		Cliente cliente = new Cliente(nome,cpf,endereco,telefone);
	
		ClientesDAO repositorio = new ClientesDAO();
		repositorio.cadastrar(cliente);
		
		return "controle?comando=GerenciarCliente";
	}
}
