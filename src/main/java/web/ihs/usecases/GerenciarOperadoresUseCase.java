package web.ihs.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import web.ihs.modelo.Operador;

public class GerenciarOperadoresUseCase {
	public String executar(Scanner leitor, ArrayList<Operador> repositorioOperadores) {
		System.out.println("*** GERENCIADOR DE OPERADORES *** \n");
		listar(repositorioOperadores);
		String comando = null;
		do {
			comando = menuGerenciar(leitor,repositorioOperadores);
			System.out.println("Comando:"+comando);
			if(comando.equals("V")) {
				return comando;
			}
		}while (comando != "V");
		return null;
	}
	
	public void adicionar(Scanner leitor, ArrayList<Operador> repositorioOperadores) {
		System.out.println("Nome completo:");
		String nome = leitor.next();
		System.out.println("Email:");
		String email = leitor.next();
		System.out.println("Senha:");
		String senha = leitor.next();
		
		Operador operador = new Operador(nome,email,senha);
		repositorioOperadores.add(operador);
	}
	
	public void editar (Scanner leitor, ArrayList<Operador> repositorioOperadores) {
		
		Operador operador = null;
		
		System.out.println("Entre com o Email do operador que deseja editar:");
		String emailEditar = leitor.next();
		
		for(Operador op : repositorioOperadores) {
			if(op.getEmail().equals(emailEditar)) {
				operador = op;
			}
		}
		if(operador == null) {
			System.out.println("Operador não encontrado");
		}else {
			String novoNome = operador.getNome();
			String novoEmail = operador.getEmail();
			String novoSenha = operador.getSenha();
			
			String comando = null;
			
			do {
				System.out.println("\nQual campo deseja alterar?");
				System.out.println("(N)ome:" + novoNome);
				System.out.println("(E)mail:" + novoEmail);
				System.out.println("(S)enha:" + novoSenha);
				System.out.println("(V)oltar");
				comando = leitor.next();
				
				switch (comando) {
					case "N":{
						System.out.println("Insira o novo nome:");
						novoNome = leitor.next();
						break;
					}
					case "E":{
						System.out.println("Insira o novo Email");
						novoEmail = leitor.next();
						break;
					}
					case "S":{
						System.out.println("Insira o novo Endereco:");
						novoSenha = leitor.next();
						break;
					}
					case "V":{
						operador.setNome(novoNome);
						operador.setEmail(novoEmail);
						operador.setSenha(novoSenha);
						return;
					}
					default:{
						System.out.println("Este comando não existe! Insira um comando válido");
					}
				}
			} while (comando != "V");
		}
	}
	
	public void deletar (Scanner leitor, ArrayList<Operador> repositorioOperadores) {
		Operador operadorExcluir = null;
		String comando = null;
	
		System.out.println("Entre com o Email do operador que deseja excluir:");
		String emailExcluir = leitor.next();
		
		for(Operador operador:repositorioOperadores) {
			if(operador.getEmail().equals(emailExcluir)) {
				operadorExcluir = operador;
			}
		}
		if(operadorExcluir == null) {
			System.out.println("Operador não encontrado");
		}else {
			System.out.println("Deseja mesmo excluir o operador "+ operadorExcluir.getNome() +" Email:"+ operadorExcluir.getEmail());
			System.out.println("(S)im");
			System.out.println("(N)ao\n");
			System.out.println("Digite o comando:");
			comando = leitor.next();
		
			if(comando.equals("S")) {
				//System.out.println("Vai excluir");
				repositorioOperadores.remove(operadorExcluir);
				System.out.println("Operador excluído com sucesso!\n");
				
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
	
	public void listar(ArrayList<Operador> repositorioOperadores) {
		if(repositorioOperadores.size() == 0) {
			System.out.println("Nenhum usuario cadastrado");
			return;
		}
		System.out.println("*** Todos Operadores ***");
	
		for(Operador operador: repositorioOperadores) {
			System.out.println( operador.getNome()+", "+ operador.getEmail() + "," +operador.getSenha());
		}
	}
	
	public String menuGerenciar(Scanner leitor, ArrayList<Operador> repositorioOperadores) {
		System.out.println("(A)dicionar");
		System.out.println("(E)ditar");
		System.out.println("(D)eletar");
		System.out.println("(L)istar");
		System.out.println("(V) Voltar");
		
		System.out.println("Digite o comando:");
		String comando = leitor.next();
		
		switch(comando) {
			case "A":{
				adicionar(leitor,repositorioOperadores);
				break;
			}
			case "E":{
				editar(leitor,repositorioOperadores);
				break;
			}
			case "D":{
				deletar(leitor,repositorioOperadores);
				break;
			}
			case "L":{
				listar(repositorioOperadores);
				break;
			}
			case "V":{
				break;
			}
			default:{
				System.out.println("Comando inválido");
			}
		}
		System.out.println("Menu Comando: "+comando);
		return comando;
	}
}
