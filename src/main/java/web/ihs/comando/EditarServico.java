package web.ihs.comando;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;
import web.ihs.modelo.Servico;


public class EditarServico implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cpfCliente = request.getParameter("cpfCliente");
		String documentoPrestador = request.getParameter("documentoPrestador");
		String dataRealizacao = request.getParameter("dataRealizacao");
		String tipoServico = request.getParameter("tipoServico");

		boolean status = Boolean.parseBoolean(request.getParameter("statusServico"));
		if(	cpfCliente.equals("")||documentoPrestador.equals("")||dataRealizacao.equals("")||
			request.getParameter("valorFinal").equals("")||request.getParameter("porcentagemADM").equals("") || 
			request.getParameter("avaliacao").equals("")) {
				String msgErro = "Todos os campos sao obrigatorios";
				String campos ="";
				campos +="&id="+request.getParameter("id"); 
				if(!cpfCliente.equals(""))campos+="&cpfCliente="+cpfCliente;
				if(!documentoPrestador.equals(""))campos+="&documentoPrestador="+documentoPrestador;
				if(!dataRealizacao.equals(""))campos+="&dataRealizacao="+dataRealizacao;
				if(!tipoServico.equals(""))campos+="&tipoServico="+tipoServico;
				if(!request.getParameter("tempoGasto").equals(""))campos+="&tempoGasto="+request.getParameter("tempoGasto");
				if(!request.getParameter("valorFinal").equals(""))campos+="&valorFinal="+request.getParameter("valorFinal");
				if(!request.getParameter("porcentagemADM").equals(""))campos+="&porcentagemADM="+request.getParameter("porcentagemADM");
				if(!request.getParameter("avaliacao").equals(""))campos+="&avaliacao="+request.getParameter("avaliacao");
				
			return "controle?comando=TelaEditarServico&msgErro="+msgErro+campos;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		double tempoGasto = Double.parseDouble(request.getParameter("tempoGasto"));
		float valorFinal = Float.parseFloat(request.getParameter("valorFinal"));
		double porcentagemADM = Double.parseDouble(request.getParameter("porcentagemADM"));
		double avaliacao = Double.parseDouble(request.getParameter("avaliacao"));
		Servico servico = new Servico(id,cpfCliente,documentoPrestador,tempoGasto,valorFinal,porcentagemADM,avaliacao,dataRealizacao,tipoServico,status);
		ServicoDAO repositorio = new ServicoDAO();

		repositorio.atualizar(servico);
		
		return "controle?comando=GerenciarServicos";
		
	}
}
