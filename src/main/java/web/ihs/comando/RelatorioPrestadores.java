package web.ihs.comando;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.PrestadorDAO;
import web.ihs.DAO.ServicoDAO;
import web.ihs.modelo.PrestadorServico;
import web.ihs.modelo.Servico;

public class RelatorioPrestadores implements Comando {

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ServicoDAO  repositorioServico = new ServicoDAO();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos = (ArrayList<Servico>)repositorioServico.getServicos();
		
		PrestadorDAO  repositorioPrestadores = new PrestadorDAO();
		ArrayList<PrestadorServico> prestadores = new ArrayList<PrestadorServico>();
		prestadores = (ArrayList<PrestadorServico>)repositorioPrestadores.getPrestadores();
		
		Map<PrestadorServico,Integer> prestadoresMap = new HashMap<>();
		
		int solicitacoes = 0; 
		
		for(PrestadorServico prestador:prestadores) { 
			for(Servico servico:servicos) {
				if(servico.getDocumentoPrestador().equals(prestador.getDocumento())) {
					solicitacoes+=1;
				}
			}
		
			prestadoresMap.put(prestador, solicitacoes);
			solicitacoes = 0;
		}
		
		ArrayList<PrestadorServico> prestadoresRelatorio = new ArrayList<PrestadorServico>();
		ArrayList<Integer> solicitacoesRelatorio = new ArrayList<Integer>();
		
		Stream<Map.Entry<PrestadorServico, Integer>> sorted =  prestadoresMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sorted.forEach(element -> {
			System.out.println("CHAVE:"+element.getKey().getDocumento());
			System.out.println("VALOR:"+element.getValue());
			prestadoresRelatorio.add((PrestadorServico)element.getKey());
			solicitacoesRelatorio.add(element.getValue());
		});
		
		Collections.reverse(prestadoresRelatorio);
		Collections.reverse(solicitacoesRelatorio);
		req.setAttribute("prestadoresRelatorio", prestadoresRelatorio);
		req.setAttribute("solicitacoesRelatorio", solicitacoesRelatorio);
		
		return "WEB-INF/views/relatorioPrestadoresMaisServico.jsp";
	}
	
}
