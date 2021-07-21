package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;
import web.ihs.modelo.Servico;

public class CadastrarServico implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cpfCliente = request.getParameter("cpfCliente");
		String documentoPrestador = request.getParameter("documentoPrestador");
		String dataRealizacao = request.getParameter("dataRealizacao");
		String tipoServico = request.getParameter("tipoServico");
		
		if(cpfCliente.equals("")||documentoPrestador.equals("")||dataRealizacao.equals("")||
		request.getParameter("valorFinal").equals("") || request.getParameter("porcentagemADM").equals("")) {
			String msgErro = "cpf Cliente, documento Prestador, data Realizacao, valor Final, porcentagem ADM sao obrigatorios ";
			return "controle?comando=TelaCadastroServico&msgErro="+msgErro;
		}
		double tempoGasto = 0;
		if(!request.getParameter("tempoGasto").equals(""))
			Double.parseDouble(request.getParameter("tempoGasto"));
		float valorFinal = Float.parseFloat(request.getParameter("valorFinal"));
		double porcentagemAdm = Double.parseDouble(request.getParameter("porcentagemADM"));
		double avaliacao = Double.parseDouble(request.getParameter("avaliacao"));
		boolean status = Boolean.parseBoolean(request.getParameter("statusServico"));
		Servico servico = new Servico(cpfCliente,documentoPrestador,tempoGasto,valorFinal,porcentagemAdm,avaliacao,dataRealizacao,tipoServico,status);
		ServicoDAO repositorio = new ServicoDAO();
		
		repositorio.cadastrar(servico);
		
		return "controle?comando=GerenciarServicos";
		
	}
}
