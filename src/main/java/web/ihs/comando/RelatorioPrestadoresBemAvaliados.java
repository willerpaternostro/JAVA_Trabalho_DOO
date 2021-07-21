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

public class RelatorioPrestadoresBemAvaliados implements Comando {

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ServicoDAO  repositorioServico = new ServicoDAO();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos = (ArrayList<Servico>)repositorioServico.getServicos();
		
		PrestadorDAO  repositorioPrestadores = new PrestadorDAO();
		ArrayList<PrestadorServico> prestadores = new ArrayList<PrestadorServico>();
		prestadores = (ArrayList<PrestadorServico>)repositorioPrestadores.getPrestadores();
		
		Map<PrestadorServico,Double> prestadoresMap = new HashMap<>();

		double media = 0;
		double avaliacao = 0;
		int qtd = 0;
		
		for(PrestadorServico prestador:prestadores) { 
			for(Servico servico:servicos) {
				if(servico.getDocumentoPrestador().equals(prestador.getDocumento())) {
					qtd +=1;
					avaliacao += servico.getAvaliacao();
				}
			}
			media = avaliacao/qtd;
			prestadoresMap.put(prestador, media);
			qtd = 0;
			avaliacao = 0;
		}
		ArrayList<PrestadorServico> prestadoresRelatorio = new ArrayList<PrestadorServico>();
		ArrayList<Double> avaliacaoRelatorio = new ArrayList<Double>();
		
		Stream<Map.Entry<PrestadorServico, Double>> sorted =  prestadoresMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sorted.forEach(element -> {
			System.out.println("CHAVE:"+element.getKey().getDocumento());
			System.out.println("VALOR:"+element.getValue());
			prestadoresRelatorio.add((PrestadorServico)element.getKey());
			avaliacaoRelatorio.add(element.getValue());
		});
		
		Collections.reverse(prestadoresRelatorio);
		Collections.reverse(avaliacaoRelatorio);
		req.setAttribute("prestadoresRelatorio", prestadoresRelatorio);
		req.setAttribute("solicitacoesRelatorio", avaliacaoRelatorio);
		
		return "WEB-INF/views/relatorioPrestadoresBemAvaliados.jsp";
	}
}