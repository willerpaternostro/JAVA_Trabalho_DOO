package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaEditarPrestador implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String nome = req.getParameter("nome");
		req.setAttribute("nome", nome);
		
		String endereco = req.getParameter("endereco");
		req.setAttribute("endereco", endereco);
		
		String documento = req.getParameter("documento");
		req.setAttribute("documento", documento);
		
		String telefone = req.getParameter("telefone");
		req.setAttribute("telefone", telefone);
		
		String servicoOferecido = req.getParameter("servicoOferecido");
		req.setAttribute("servicoOferecido", servicoOferecido);
		
		String valorDiaria = req.getParameter("valorDiaria");
		req.setAttribute("valorDiaria", valorDiaria);
		
		String atendeUrgencia = req.getParameter("atendeUrgencia");
		req.setAttribute("atendeUrgencia", atendeUrgencia);
		
		return "WEB-INF/views/editarPrestador.jsp";
	}

}
