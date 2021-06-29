package web.ihs.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import web.ihs.modelo.Cliente;

public class GerenciarClienteUseCase {
	public String executar(Scanner leitor, ArrayList<Cliente> repositorioClientes) {
		System.out.println("GERENCIADOR DE CLIENTES\n");
		listar(repositorioClientes);
		String comando = null;
		do {
			comando = menuGerenciar(leitor,repositorioClientes);
			if(comando.equals("V")) {
				return comando;
			}
		}while (comando != "V");
		return null;
	}
	
	public void adicionar(Scanner leitor, ArrayList<Cliente> repositorioClientes) {
		System.out.println("Nome completo:");
		String nome = leitor.next();
		System.out.println("CPF:");
		String cpf = leitor.next();
		System.out.println("Endereco:");
		String endereco = leitor.next();
		System.out.println("Telefone:");
		String telefone = leitor.next();
		
		Cliente cliente = new Cliente(nome,cpf,endereco,telefone);
		repositorioClientes.add(cliente);
	}
	
	public void editar (Scanner leitor, ArrayList<Cliente> repositorioClientes) {
		
		Cliente cliente = null;
		
		System.out.println("Entre com o CPF do cliente que deseja editar:");
		String cpfEditar = leitor.next();
		
		for(Cliente c : repositorioClientes) {
			if(c.getCpf().equals(cpfEditar)) {
				cliente = c;
			}
		}
		if(cliente == null) {
			System.out.println("Cliente não encontrado");
			
		}else {
			String novoNome = cliente.getNome();
			String novoCpf = cliente.getCpf();
			String novoEndereco = cliente.getEndereco();
			String novoTelefone = cliente.getTelefone();
			
			String comando = null;
			
			do {
				System.out.println("\nQual campo deseja alterar?");
				System.out.println("(N)ome:" + novoNome);
				System.out.println("(C)PF:" + novoCpf);
				System.out.println("(E)ndereco:" + novoEndereco);
				System.out.println("(T)elefone:" + novoTelefone);
				System.out.println("(V)oltar");
				comando = leitor.next();
				
				switch (comando) {
					case "N":{
						System.out.println("Insira o novo nome:");
						novoNome = leitor.next();
						break;
					}
					case "C":{
						System.out.println("Insira o novo CPF");
						novoCpf = leitor.next();
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
					}
					case "V":{
						cliente.setNome(novoNome);
						cliente.setCpf(novoCpf);
						cliente.setEndereco(novoEndereco);
						cliente.setTelefone(novoTelefone);
						return;
					}
					default:{
						System.out.println("Este comando não existe! Insira um comando válido");
					}
				}
			} while (comando != "V");
		}
	}
	
	public void deletar (Scanner leitor, ArrayList<Cliente> repositorioClientes) {
		Cliente clienteExcluir = null;
		String comando = null;
	
		System.out.println("Entre com o CPF do cliente que deseja excluir:");
		String cpfExcluir = leitor.next();
		
		for(Cliente cliente:repositorioClientes) {
			if(cliente.getCpf().equals(cpfExcluir)) {
				clienteExcluir = cliente;
			}
		}
		if(clienteExcluir == null) {
			System.out.println("Cliente não encontrado");
		}else {
			System.out.println("Deseja mesmo excluir o cliente "+ clienteExcluir.getNome() +" CPF:"+ clienteExcluir.getCpf());
			System.out.println("(S)im");
			System.out.println("(N)ao\n");
			System.out.println("Digite o comando:");
			comando = leitor.next();
		
			if(comando.equals("S")) {
				repositorioClientes.remove(clienteExcluir);
				System.out.println("Cliente excluído com sucesso!\n");
				
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
	
	public void listar(ArrayList<Cliente> repositorioClientes) {
		if(repositorioClientes.size() == 0) {
			System.out.println("Nenhum usuario cadastrado");
			return;
		}
		System.out.println("*** Todos Clientes ***");
	
		for(Cliente cliente: repositorioClientes) {
			System.out.println( cliente.getNome()+", "+ cliente.getCpf()+ ", "+ cliente.getEndereco()+", "+cliente.getTelefone());
		}
		
		
	}
	
	public String menuGerenciar(Scanner leitor, ArrayList<Cliente> repositorioClientes) {
		
		System.out.println("(A)dicionar");
		System.out.println("(E)ditar");
		System.out.println("(D)eletar");
		System.out.println("(L)istar");
		System.out.println("(V) Voltar\n");
		
		System.out.println("Digite o comando:");
		String comando = leitor.next();
		
		switch(comando) {
			case "A":{
				adicionar(leitor,repositorioClientes);
				break;
			}
			case "E":{
				editar(leitor,repositorioClientes);
				break;
			}
			case "D":{
				deletar(leitor,repositorioClientes);
				break;
			}
			case "L":{
				listar(repositorioClientes);
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
