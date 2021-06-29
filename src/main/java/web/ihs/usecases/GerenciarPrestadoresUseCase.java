package web.ihs.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import web.ihs.modelo.PrestadorServico;

public class GerenciarPrestadoresUseCase {
	public String executar(Scanner leitor, ArrayList<PrestadorServico> repositorioPrestadores) {
		System.out.println("*** GERENCIADOR DE PRESTADORES DE SERVICOS ***\n");
		listar(repositorioPrestadores);
		String comando = null;
		do {
			comando = menuGerenciar(leitor,repositorioPrestadores);
			if(comando.equals("V")) {
				return comando;
			}
		}while (comando != "V");
		return null;
	}
	
	public void adicionar(Scanner leitor, ArrayList<PrestadorServico> repositorioPrestadores) {
		System.out.println("Nome completo:");
		String nome = leitor.next();
		System.out.println("Endereco:");
		String endereco = leitor.next();
		System.out.println("Documento:");
		String documento = leitor.next();
		System.out.println("Telefone:");
		String telefone = leitor.next();
		System.out.println("Servico oferecido:");
		String servico = leitor.next();
		System.out.println("Valor diaria:");
		float valorDiaria = leitor.nextFloat();
		System.out.println("Atende urgencia (1) sim (0) nao:");
		int urgencia = leitor.nextInt();
		boolean atendeUrgencia = urgencia == 1?true:false;
		
		PrestadorServico prestador = new PrestadorServico(nome,endereco,documento,telefone,servico,valorDiaria,atendeUrgencia);
		repositorioPrestadores.add(prestador);
	}
	
	public void editar (Scanner leitor, ArrayList<PrestadorServico> repositorioPrestadores) {
		
		PrestadorServico prestador = null;
		
		System.out.println("Entre com o numero do documento do prestador que deseja editar:");
		String documentoEditar = leitor.next();
		
		for(PrestadorServico p : repositorioPrestadores) {
			if(p.getDocumento().equals(documentoEditar)) {
				prestador = p;
			}
		}
		if(prestador == null) {
			System.out.println("Prestador não encontrado");
			
		}else {
			String novoNome = prestador.getNome();
			String novoDocumento = prestador.getDocumento();
			String novoEndereco = prestador.getEndereco();
			String novoTelefone = prestador.getTelefone();
			String novoServico = prestador.getServicoOferecido();
			float novoValorDiaria = prestador.getValorDiaria();
			boolean novoAtendimentoUrgencia = prestador.getAtendeUrgencia();
			
			String comando = null;
			
			do {
				System.out.println("\nQual campo deseja alterar?");
				System.out.println("(N)ome:" + novoNome);
				System.out.println("(D)ocumento:" + novoDocumento);
				System.out.println("(E)ndereco:" + novoEndereco);
				System.out.println("(T)elefone:" + novoTelefone);
				System.out.println("(S)ervico:" + novoServico);
				System.out.println("(V)alor (D)iaria:" + novoValorDiaria);
				System.out.println("(A)tendimento (U)rgencia:" + novoAtendimentoUrgencia);
				System.out.println("(S)alvar (A)lteracoes");
				comando = leitor.next();
				
				switch (comando) {
					case "N":{
						System.out.println("Insira o novo nome:");
						novoNome = leitor.next();
						break;
					}
					case "D":{
						System.out.println("Insira o novo documento");
						novoDocumento = leitor.next();
						break;
					}
					case "E":{
						System.out.println("Insira o novo Endereco:");
						novoEndereco = leitor.next();
						break;
					}
					case "T":{
						System.out.println("Insira o novo telefone:");
						novoTelefone = leitor.next();
						break;
					}
					case "S":{
						System.out.println("Insira o novo servico oferecido:");
						novoServico = leitor.next();
						break;
					}
					case "VD":{
						System.out.println("Insira o novo valor da diaria:");
						novoValorDiaria = leitor.nextFloat();
						break;
					}
					case "AU":{
						System.out.println("Insira o novo status de atendimento de urgencia (1) Disponivel (0) Nao disponivel:");
						int opcao = leitor.nextInt();
						novoAtendimentoUrgencia = opcao == 1?true:false;
						break;
					}
					case "SA":{
						prestador.setNome(novoNome);
						prestador.setDocumento(novoDocumento);
						prestador.setEndereco(novoEndereco);
						prestador.setTelefone(novoTelefone);
						prestador.setServicoOferecido(novoServico);
						prestador.setValorDiaria(novoValorDiaria);
						prestador.setAtendeUrgencia(novoAtendimentoUrgencia);
						return;
					}
					default:{
						System.out.println("Este comando não existe! Insira um comando válido");
					}
				}
			} while (comando != "SA");
		}
	}
	
	public void deletar (Scanner leitor, ArrayList<PrestadorServico> repositorioPrestadores) {
		PrestadorServico prestadorExcluir = null;
		String comando = null;
	
		System.out.println("Entre com o CPF do cliente que deseja excluir:");
		String documentoExcluir = leitor.next();
		
		for(PrestadorServico prestador:repositorioPrestadores) {
			if(prestador.getDocumento().equals(documentoExcluir)) {
				prestadorExcluir = prestador;
			}
		}
		if(prestadorExcluir == null) {
			System.out.println("Cliente não encontrado");
		}else {
			System.out.println("Deseja mesmo excluir o cliente:\n ");
			prestadorExcluir.informacoes();
			System.out.println("\n(S)im");
			System.out.println("(N)ao\n");
			System.out.println("Digite o comando:");
			comando = leitor.next();
		
			if(comando.equals("S")) {
				repositorioPrestadores.remove(prestadorExcluir);
				System.out.println("Prestador excluído com sucesso!\n");
				
			}else{
				if(comando.equals("N")) {
					System.out.println("Operacao cancelada.");
				}else {
					System.out.println("Este comando nao existe!");
					System.out.println("Operacao cancelada");
				}
			}
		}
	}
	
	public void listar(ArrayList<PrestadorServico> repositorioPrestadores) {
		if(repositorioPrestadores.size() == 0) {
			System.out.println("Nenhum usuario cadastrado");
			return;
		}
		System.out.println("*** Todos Prestadores Cadastrados ***");
	
		for(PrestadorServico prestador: repositorioPrestadores) {
			prestador.informacoes();
		}
	}
	
	
	public String menuGerenciar(Scanner leitor, ArrayList<PrestadorServico> repositorioPrestadores) {
		
		System.out.println("(A)dicionar");
		System.out.println("(E)ditar");
		System.out.println("(D)eletar");
		System.out.println("(L)istar");
		System.out.println("(V) Voltar\n");
		
		System.out.println("Digite o comando:");
		String comando = leitor.next();
		
		switch(comando) {
			case "A":{
				adicionar(leitor,repositorioPrestadores);
				break;
			}
			case "E":{
				editar(leitor,repositorioPrestadores);
				break;
			}
			case "D":{
				deletar(leitor,repositorioPrestadores);
				break;
			}
			case "L":{
				listar(repositorioPrestadores);
				break;
			}
			case "V":{
				break;
			}
			default:{
				System.out.println("Comando inválido");
			}
		}
		return comando;
	}
}
