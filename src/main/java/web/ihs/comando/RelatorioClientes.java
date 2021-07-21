package web.ihs.comando;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ihs.DAO.ClientesDAO;
import web.ihs.DAO.ServicoDAO;
import web.ihs.modelo.Cliente;
import web.ihs.modelo.Servico;

public class RelatorioClientes implements Comando {

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse response) throws Exception {
		ClientesDAO repositorioCliente = new ClientesDAO();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = (ArrayList<Cliente>)repositorioCliente.getClientes();
		
		ServicoDAO  repositorioServico = new ServicoDAO();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos = (ArrayList<Servico>)repositorioServico.getServicos();
		
		Map<Cliente,Integer> clientesMap = new HashMap<>();
		ArrayList<Integer> qtdSolicitacoes = new ArrayList<Integer>();
		
		int solicitacoes = 0; 
		//Verificando quantas solicitacoes cada cliente fez
		for(Cliente cliente:clientes) { 
			for(Servico servico:servicos) {
				if(servico.getCpfCliente().equals(cliente.getCpf())) {
					solicitacoes+=1;
				}
			}
			qtdSolicitacoes.add(solicitacoes); // Alinhado com a ordem Array Clientes
			clientesMap.put(cliente, solicitacoes);
			solicitacoes = 0;
		}
		ArrayList<Cliente> clientesRelatorio = new ArrayList<Cliente>();
		ArrayList<Integer> solicitacoesRelatorio = new ArrayList<Integer>();
		
		Stream<Map.Entry<Cliente, Integer>> sorted =  clientesMap.entrySet().stream().sorted(Map.Entry.comparingByValue());
		sorted.forEach(element -> {
			//System.out.println("CHAVE:"+element.getKey().getCpf());
			//System.out.println("VALOR:"+element.getValue());
			clientesRelatorio.add((Cliente)element.getKey());
			solicitacoesRelatorio.add(element.getValue());
		});
		
		Collections.reverse(clientesRelatorio);
		Collections.reverse(solicitacoesRelatorio);
		req.setAttribute("clientesRelatorio", clientesRelatorio);
		req.setAttribute("solicitacoesRelatorio", solicitacoesRelatorio);
		
		return "WEB-INF/views/relatorioClientes.jsp";
	}

}