package web.ihs.usecases;


import java.util.ArrayList;

import java.util.Scanner;

import web.ihs.modelo.Cliente;
import web.ihs.modelo.PrestadorServico;
import web.ihs.modelo.Servico;

public class EmitirRelatoriosUseCase {
	public  String executar(Scanner leitor,ArrayList<Cliente> clientes,ArrayList<PrestadorServico> prestadores,ArrayList<Servico> servicos) {
		String comando = null;
		do {
			comando = menuGerenciar(leitor,clientes,prestadores,servicos);
			if(comando.equals("V")) {
				return comando;
			}
		}while (comando != "V");
		return null;
	}
	public void profissionaisBemAvaliados(ArrayList<Servico> repositorioServicos, ArrayList<PrestadorServico> repositorioPrestadores) {
		
		System.out.println("*** Melhores Avaliações dos Profissionais ***");
		double avaliacao = 0;
		String documento = null;
		ArrayList<String> profissionais = new ArrayList<String>();
		
		//Criando um vetor com todos os profissionais que realizaram servico
		for(Servico servico:repositorioServicos) {
			if(!profissionais.contains(servico.getDocumentoPrestador()))
				profissionais.add(servico.getDocumentoPrestador());
		}
		//Somando todas avaliacoes de cada profissional
		ArrayList<Double> medias = new ArrayList<Double>();
		for(String profissional:profissionais) {
			double nota = 0;
			int qtd = 0;
			double media = 0;
			for(Servico servico: repositorioServicos) {
				if(servico.getDocumentoPrestador().equals(profissional)) {
					nota +=  servico.getAvaliacao();
					qtd++;
				}
			}
			media = nota/qtd;
			medias.add(media);
		}
		//Verificando qual media é maior
		double maior = medias.get(0);
		int posicao = 0;
		int i = 0;
		for(double media:medias) {
			if(maior < media) {
				maior = media;
				posicao = i;
			}
			i++;
		}
		String cpfPrestador = profissionais.get(posicao);
		PrestadorServico prestador = null;
		for(PrestadorServico ps:repositorioPrestadores) {
			if(ps.getDocumento().equals(cpfPrestador)) {
				prestador = ps;
				break;
			}
		}
		if(prestador != null) {
			System.out.println("O profissional mais bem avaliado:\n");
			System.out.println("Avaliacao:"+maior);
			prestador.informacoes();
		}
		
	}
	public void profissionaisMaisRequisitados(ArrayList<Servico> repositorioServicos, ArrayList<PrestadorServico> repositorioPrestadores) {
		System.out.println("*** Profissional que mais realizou servicos ***");	
		ArrayList<String> profissionais = new ArrayList<String>();
		
		String documento = null;
	
		for(Servico servico:repositorioServicos) {
			if(!profissionais.contains(servico.getDocumentoPrestador()))
				profissionais.add(servico.getDocumentoPrestador());
		}
		ArrayList<Integer> qtdServico = new ArrayList<Integer>();
		
		for(String cpfPrestador:profissionais) {
			int qtd = 0;
			for(Servico servico:repositorioServicos) {
				if(servico.getDocumentoPrestador().equals(cpfPrestador)) {
					qtd ++;
				}
			}
			qtdServico.add(qtd);
		}
		int maior = -1;
		int pos = 0;
		int i = 0;
		for(int m:qtdServico) {
			if(m> maior) {
				maior = m;
				pos=i;
			}
			i++;
		}
		PrestadorServico profissional = null;
		for(PrestadorServico prestador:repositorioPrestadores) {
			if(prestador.getDocumento().equals(profissionais.get(pos))) {
				profissional = prestador;
			}
		}
		if(profissional != null) {
			System.out.println("O profissional que mais realizou servicos foi:");
			profissional.informacoes();
			System.out.println("Realizou "+ maior + " servicos");
		}
		
	}
	public void clientesPrincipais(ArrayList<Servico> repositorioServicos,ArrayList<Cliente> repositorioClientes) {
		System.out.println("*** Principais Clientes ***");
		
		ArrayList<Integer> qtdSolicitacoes = new ArrayList<Integer>();
		int solicitacoes = 0; 
		//Verificando quantas solicitacoes cada cliente fez
		for(Cliente cliente:repositorioClientes) { 
			for(Servico servico:repositorioServicos) {
				if(servico.getCpfCliente().equals(cliente.getCpf())) {
					solicitacoes+=1;
				}
			}
			qtdSolicitacoes.add(solicitacoes);
			solicitacoes = 0;
		}
		// Localizando o cliente que fez mais requisiçoes de servico
		int i = 0;
		int maior = qtdSolicitacoes.get(0);
		int pos = 0;
		for(int n:qtdSolicitacoes) {
			if(n > maior) {
				maior = n;
				pos = i;
			}
			i++;
		}
		System.out.println("O cliente que fez mais solicitacoes foi:");
		System.out.println("Nome:" + repositorioClientes.get(pos).getNome());
		System.out.println("CPF:" + repositorioClientes.get(pos).getCpf());
		System.out.println("Endereco:"+ repositorioClientes.get(pos).getEndereco());
		System.out.println("Telefone:"+ repositorioClientes.get(pos).getTelefone());
		System.out.println("Solicitacoes:"+ maior);
	}
	public void servicosRealizados(ArrayList<Servico> repositorioServicos) {
		System.out.println("*** Servicos realizados neste periodo ***");
	}
	public  String menuGerenciar(Scanner leitor, ArrayList<Cliente> clientes,ArrayList<PrestadorServico> prestadores,ArrayList<Servico> servicos) {
		if(servicos.size() == 0) {
			System.out.println("*** Nenhum relatorio gerado ***");
			return "V";
		}else {
			System.out.println("Escolha um comando:\n");
			System.out.println("(P)rofissionais bem (A)valiados");
			System.out.println("(P)rofissionais mais (R)equisitados");
			System.out.println("(P)rincipais (C)lientes");
			System.out.println("(S)ervicos");
			System.out.println("(V) Voltar\n");
		}
		
		System.out.println("Digite o comando:");
		String comando = leitor.next();
		
		switch(comando) {
			case "PA":{
				profissionaisBemAvaliados(servicos,prestadores);
				break;
			}
			case "PR":{
				profissionaisMaisRequisitados(servicos,prestadores);
				break;
			}
			case "PC":{
				clientesPrincipais(servicos,clientes);
				break;
			}
			case "S":{
				//servicosRealizados();
				break;
			}
			case "V":{
				return "V";
			}
			default:{
				System.out.println("Comando inválido");
			}
		}
		return comando;
	}
}
