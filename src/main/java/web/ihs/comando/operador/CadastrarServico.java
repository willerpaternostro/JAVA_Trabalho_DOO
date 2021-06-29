package web.ihs.comando.operador;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;
import web.ihs.comando.Comando;
import web.ihs.modelo.Servico;




public class CadastrarServico implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cpfCliente = request.getParameter("cpfCliente");
		String documentoPrestador = request.getParameter("documentoPrestador");
		double tempoGasto = Double.parseDouble(request.getParameter("tempoGasto"));
		float valorFinal = Float.parseFloat(request.getParameter("valorFinal"));
		double porcentagemAdm = Double.parseDouble(request.getParameter("porcentagemAdm"));
		double avaliacao = Double.parseDouble(request.getParameter("avaliacao"));
		String dataRealizacao = request.getParameter("dataRealizacao");
		String tipoServico = request.getParameter("tipoServico");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		Servico servico = new Servico(cpfCliente,documentoPrestador,tempoGasto,valorFinal,porcentagemAdm,avaliacao,dataRealizacao,status,tipoServico);
		ServicoDAO repositorio = new ServicoDAO();
		
		repositorio.cadastrar(servico);
		
		return "controle?comando=CadastroForm";
		
	}
}
