package web.ihs.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import web.ihs.modelo.Servico;

public class GerenciarServicosUseCase {
	public String executar(Scanner leitor, ArrayList<Servico> repositorioServicos){
		System.out.println("*** GERENCIADOR DE PRESTADORES DE SERVICOS ***\n");
		listar(repositorioServicos);
		String comando = null;
		do {
			comando = menuGerenciar(leitor,repositorioServicos);
			if(comando.equals("V")) {
				return comando;
			}
		}while (comando != "V");
		return null;
	}
	
	public void adicionar(Scanner leitor, ArrayList<Servico> repositorioServicos) {
		System.out.println("codigo de identificacao:");
		int codigo = leitor.nextInt();
		System.out.println("Documento Cliente:");
		String documentoCliente = leitor.next();
		System.out.println("Documento Prestador de Servico:");
		String documentoPrestador = leitor.next();
		System.out.println("Duracao servico:");
		double tempoGasto = leitor.nextDouble();
		System.out.println("Valor total:");
		float valorFinal = leitor.nextFloat();
		System.out.println("Porcentagem Administrador:");
		double porcentagemAdm = leitor.nextDouble();
		System.out.println("Avaliacao:");
		double avaliacao = leitor.nextDouble();
		System.out.println("Tipo Servico:");
		String tipoServico = leitor.next();
		System.out.println("Data realizacao:");
		String dataRealizacao = leitor.next();
		System.out.println("Status do servico (1) Concluido (0)Nao concluido:");
		int escolha = leitor.nextInt();
		boolean status = escolha == 1?true:false;
		
		Servico servico = new Servico( codigo,documentoCliente,  documentoPrestador,  tempoGasto,  valorFinal,
				 porcentagemAdm,  avaliacao,  dataRealizacao, tipoServico, status  );
		repositorioServicos.add(servico);
	}
	
	public void editar (Scanner leitor, ArrayList<Servico> repositorioServicos) {
		
		Servico servico = null;
		
		System.out.println("Entre com o id do servico que deseja editar:");
		int idEditar = leitor.nextInt();
		
		for(Servico s : repositorioServicos) {
			if(s.getId() == idEditar) {
				servico = s;
			}
		}
		if(servico == null) {
			System.out.println("Servico não encontrado");
			
		}else {
			String novoDocCliente = servico.getCpfCliente();
			String novoDocPrestador = servico.getDocumentoPrestador();
			double novoTempoGasto = servico.getTempoGasto();
			float  novoValorFinal = servico.getValorFinal();
			double novoPorcentagemAdm= servico.getPorcentagemAdm();
			double novoAvaliacao = servico.getAvaliacao();
			String novoDataRealizacao = servico.getDataRealizacao();
			String novoTipoServico= servico.getTipoServico();
			boolean novoStatus = servico.getStatus();
			
			String comando = null;
			
			do {
				System.out.println("\nQual campo deseja alterar?");
				System.out.println("(D)ocumento (C)liente:" + novoDocCliente);
				System.out.println("(D)ocumento (P)restador:" + novoDocPrestador);
				System.out.println("(T)empo (G)asto:" + novoTempoGasto);
				System.out.println("(V)alor (T)otal:" + novoValorFinal);
				System.out.println("(P)orcentagem (A)dministrador:" + novoPorcentagemAdm);
				System.out.println("(A)valiacao (P)restador:" + novoAvaliacao);
				System.out.println("(D)ata (T)ermino do servico:" + novoDataRealizacao);
				System.out.println("(T)ipo de (S)ervico:" + novoTipoServico);
				System.out.println("(S)tatus (S)ervico:" + novoStatus);
				System.out.println("(V)oltar");
				
				comando = leitor.next();
				
				switch (comando) {
					case "DC":{
						System.out.println("Insira o documento do cliente:");
						novoDocCliente = leitor.next();
						break;
					}
					case "DP":{
						System.out.println("Insira o  documento do prestador:");
						novoDocPrestador = leitor.next();
						break;
					}
					case "TG":{
						System.out.println("Insira o tempo gasto para completar o servico:");
						novoTempoGasto = leitor.nextDouble();
						break;
					}
					case "VT":{
						System.out.println("Insira o valor total do servico:");
						novoValorFinal = leitor.nextFloat();
						break;
					}
					case "PA":{
						System.out.println("Insira a porcentagem do Administrador:");
						novoPorcentagemAdm = leitor.nextDouble();
						break;
					}
					case "AP":{
						System.out.println("Insira a avaliacao do profissional:");
						novoAvaliacao = leitor.nextDouble();
						break;
					}
					case "DT":{
						System.out.println("Insira a data de conclusao do servico:");
						novoDataRealizacao = leitor.next();
						break;
					}
					case "TS":{
						System.out.println("Insira o tipo de servico prestado:");
						novoTipoServico = leitor.next();
						break;
					}
					case "SS":{
						System.out.println("Insira (1) para servico concluido (0) para nao concluido:");
						int escolha = leitor.nextInt();
						novoStatus = escolha == 1?true:false;
						break;
					}
					case "V":{
						servico.setCpfCliente(novoDocCliente);
						servico.setDocumentoPrestador(novoDocPrestador);
						servico.setTempoGasto(novoTempoGasto);
						servico.setValorFinal(novoValorFinal);
						servico.setPorcentagemAdm(novoPorcentagemAdm);
						servico.setAvaliacao(novoAvaliacao);
						servico.setDataRealizacao(novoDataRealizacao);
						servico.setTipoServico(novoTipoServico);
						servico.setStatus(novoStatus);
						return;
					}
					default:{
						System.out.println("Este comando não existe! Insira um comando válido");
					}
				}
			} while (comando != "V");
		}
	}
	public void deletar (Scanner leitor, ArrayList<Servico> repositorioServicos) {
		Servico servicoExcluir = null;
		String comando = null;
	
		System.out.println("Entre com o ID do servico que deseja excluir:");
		int idExcluir = leitor.nextInt();
		
		for(Servico servico:repositorioServicos) {
			if(servico.getId() == idExcluir) {
				servicoExcluir = servico;
			}
		}
		if(servicoExcluir == null) {
			System.out.println("Servico não encontrado");
		}else {
			System.out.println("Deseja mesmo excluir o cliente de ID:"+ servicoExcluir.getId() + "?");
			System.out.println("(S)im");
			System.out.println("(N)ao\n");
			System.out.println("Digite o comando:");
			comando = leitor.next();
		
			if(comando.equals("S")) {
				repositorioServicos.remove(servicoExcluir);
				System.out.println("Servico excluído com sucesso!\n");
				
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
	
	public void listar(ArrayList<Servico> repositorioServicos) {
		if(repositorioServicos.size() == 0) {
			System.out.println("Nenhum servico cadastrado");
			return;
		}
		System.out.println("*** Todos Servicos ***");
	
		for(Servico servico: repositorioServicos) {
			System.out.println("Id:"+servico.getId());
			System.out.println("Documento cliente:"+servico.getCpfCliente());
			System.out.println("Documento profissional:"+servico.getDocumentoPrestador());
			System.out.println("Tempo Gasto: "+servico.getTempoGasto());
			System.out.println("Valor total: "+ servico.getValorFinal());
			System.out.println("Porcentagem ADM: "+servico.getPorcentagemAdm());
			System.out.println("Avaliacao:"+servico.getAvaliacao());
			System.out.println("Data Realizacao: "+ servico.getDataRealizacao());
			System.out.println("Tipo Servico"+servico.getTipoServico());
			System.out.println("Status:"+servico.getStatus());
		}
	}
	
	public String menuGerenciar(Scanner leitor, ArrayList<Servico> repositorioServicos) {
		
		System.out.println("(A)dicionar");
		System.out.println("(E)ditar");
		System.out.println("(D)eletar");
		System.out.println("(L)istar");
		System.out.println("(V) Voltar\n");
		
		System.out.println("Digite o comando:");
		String comando = leitor.next();
		
		switch(comando) {
			case "A":{
				adicionar(leitor,repositorioServicos);
				break;
			}
			case "E":{
				editar(leitor,repositorioServicos);
				break;
			}
			case "D":{
				deletar(leitor,repositorioServicos);
				break;
			}
			case "L":{
				listar(repositorioServicos);
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

