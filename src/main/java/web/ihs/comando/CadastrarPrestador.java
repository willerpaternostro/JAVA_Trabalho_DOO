package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;
import web.ihs.modelo.PrestadorServico;


public class CadastrarPrestador implements Comando{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String documento = request.getParameter("documento");
		String telefone = request.getParameter("telefone");
		String servicoOferecido = request.getParameter("servicoOferecido");
		String valor = request.getParameter("valorDiaria");
		
		if(documento.equals("")||nome.equals("")||servicoOferecido.equals("") || valor.equals("")) {
			String msgErro = "documento, nome, servico Oferecido e valor sao obrigatorios";
			return "controle?comando=TelaCadastroPrestador&msgErro="+msgErro;
		}else {
		float valorDiaria = Float.parseFloat(request.getParameter("valorDiaria"));
		boolean atendeUrgencia = Boolean.parseBoolean(request.getParameter("atendeUrgencia"));
		PrestadorServico prestador = new PrestadorServico(nome,endereco,documento,telefone,servicoOferecido,valorDiaria,atendeUrgencia);
		PrestadorDAO repositorio = new PrestadorDAO();
		
		repositorio.cadastrar(prestador);
		
		return "controle?comando=GerenciarPrestadores";
		}
	}
}
