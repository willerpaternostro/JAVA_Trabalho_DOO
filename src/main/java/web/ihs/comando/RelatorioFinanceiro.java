package web.ihs.comando;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ServicoDAO;
import web.ihs.modelo.Servico;

public class RelatorioFinanceiro implements Comando {

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ServicoDAO  repositorioServico = new ServicoDAO();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos = (ArrayList<Servico>)repositorioServico.getServicos();
		
		Map<Servico,Double> servicosMap = new HashMap<>();
		double valorADM = 0;
		double valorTotalADM =0;
		for(Servico servico:servicos) {
			valorADM = servico.getValorFinal()*(servico.getPorcentagemAdm()/100);
			valorTotalADM += valorADM;
			servicosMap.put(servico, valorADM);
			valorADM=0;
		}
		ArrayList<Servico> servicosRelatorio = new ArrayList<Servico>();
		ArrayList<Double> faturamentoAdminRelatorio = new ArrayList<Double>();
		
		Stream<Map.Entry<Servico, Double>> sorted =  servicosMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sorted.forEach(element -> {
			servicosRelatorio.add((Servico)element.getKey());
			faturamentoAdminRelatorio.add(element.getValue());
		});
		
		Collections.reverse(servicosRelatorio);
		Collections.reverse(faturamentoAdminRelatorio);
		
		req.setAttribute("servicosRelatorio", servicosRelatorio);
		req.setAttribute("faturamentoAdminRelatorio", faturamentoAdminRelatorio);
		req.setAttribute("faturamentoTotalRelatorio", valorTotalADM);
		
		return "WEB-INF/views/relatorioFinanceiro.jsp";
	}
	
}
