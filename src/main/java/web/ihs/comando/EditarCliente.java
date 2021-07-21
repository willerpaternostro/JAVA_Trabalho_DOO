package web.ihs.comando;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;
import web.ihs.modelo.Cliente;


public class EditarCliente implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		if(nome.equals("")||cpf.equals("")||endereco.equals("")||telefone.equals("")) {
			String msgErro = "Todos os campos sao obrigatorios";
			String campos="";
			if(!nome.equals(""))campos += "&nome="+nome;
			if(!cpf.equals(""))campos += "&cpf="+cpf;
			if(!endereco.equals(""))campos += "&endereco="+endereco;
			if(!telefone.equals(""))campos += "&telefone="+telefone;
			
			return "controle?comando=TelaEditarCliente&msgErro="+msgErro+campos;
		}
		
		Cliente cliente = new Cliente(nome,cpf,endereco,telefone);
	
		ClientesDAO repositorio = new ClientesDAO();
		repositorio.atualizar(cliente);
		
		return "controle?comando=GerenciarCliente";
		
	}

}
