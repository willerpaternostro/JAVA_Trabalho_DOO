package web.ihs.comando.operador;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;
import web.ihs.comando.Comando;
import web.ihs.modelo.PrestadorServico;


public class CadastrarPrestador implements Comando{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String documento = request.getParameter("documento");
		String telefone = request.getParameter("telefone");
		String servicoOferecido = request.getParameter("servicoOferecido");
		float valorDiaria = Float.parseFloat(request.getParameter("valorDiaria"));
		boolean atendeUrgencia = Boolean.parseBoolean(request.getParameter("atendeUrgencia"));
		
		PrestadorServico prestador = new PrestadorServico(nome,endereco,documento,telefone,servicoOferecido,valorDiaria,atendeUrgencia);
		PrestadorDAO repositorio = new PrestadorDAO();
		
		repositorio.cadastrar(prestador);
		
		return "controle?comando=CadastroForm";
		
	}
}
