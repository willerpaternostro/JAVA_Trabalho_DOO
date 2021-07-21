package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TelaEditarServico implements Comando{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		String cpfCliente = req.getParameter("cpfCliente");
		req.setAttribute("cpfCliente", cpfCliente);
		
		String documentoPrestador = req.getParameter("documentoPrestador");
		req.setAttribute("documentoPrestador", documentoPrestador);
		
		String tempoGasto = req.getParameter("tempoGasto");
		req.setAttribute("tempoGasto", tempoGasto);
		
		String valorFinal = req.getParameter("valorFinal");
		req.setAttribute("valorFinal", valorFinal);
		
		String porcentagemADM = req.getParameter("porcentagemADM");
		req.setAttribute("porcentagemADM", porcentagemADM );
		
		String avaliacao = req.getParameter("avaliacao");
		req.setAttribute("avaliacao", avaliacao);
		
		String dataRealizacao = req.getParameter("dataRealizacao");
		req.setAttribute("dataRealizacao", dataRealizacao);
		
		String tipoServico = req.getParameter("tipoServico");
		req.setAttribute("tipoServico", tipoServico);
		
		String status = req.getParameter("status");
		req.setAttribute("status", status);
		
		return "WEB-INF/views/editarServico.jsp";
	}
}
