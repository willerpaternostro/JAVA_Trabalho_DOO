package web.ihs.comando;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;
import web.ihs.modelo.PrestadorServico;



public class EditarPrestador implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String documento = request.getParameter("documento");
		String telefone = request.getParameter("telefone");
		String servicoOferecido = request.getParameter("servicoOferecido");
		if(documento.equals("")||nome.equals("")||servicoOferecido.equals("") || request.getParameter("valorDiaria").equals("")) {
			String msgErro = "Todos os campos sao obrigatorios";
			String campos = "";
			if(!documento.equals(""))
				campos+="&documento="+documento;
			if(!nome.equals(""))
				campos+="&nome="+nome;
			if(!endereco.equals(""))
				campos+="&endereco="+endereco;
			if(!telefone.equals(""))
				campos+="&telefone="+telefone;
			if(!servicoOferecido.equals(""))
				campos+="&servicoOferecido="+servicoOferecido;
			if(!request.getParameter("valorDiaria").equals(""))
				campos+="&valorDiaria="+request.getParameter("valorDiaria");			
					
			return "controle?comando=TelaEditarPrestador&msgErro="+msgErro+campos;
		}
		float valorDiaria = Float.parseFloat(request.getParameter("valorDiaria"));
		boolean atendeUrgencia = Boolean.parseBoolean(request.getParameter("atendeUrgencia"));
		
		PrestadorServico prestador = new PrestadorServico(nome,endereco,documento,telefone,servicoOferecido,valorDiaria,atendeUrgencia);
		PrestadorDAO repositorio = new PrestadorDAO();
		
		repositorio.atualizar(prestador);
		
		return "controle?comando=GerenciarPrestadores";
		
	}
}
