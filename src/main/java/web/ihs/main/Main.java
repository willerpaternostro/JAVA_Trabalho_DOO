package web.ihs.main;

import java.util.ArrayList;
import java.util.Scanner;

import web.ihs.modelo.Administrador;
import web.ihs.modelo.Cliente;
import web.ihs.modelo.Operador;
import web.ihs.modelo.PrestadorServico;
import web.ihs.modelo.Servico;
import web.ihs.usecases.EmitirRelatoriosUseCase;
import web.ihs.usecases.GerenciarClienteUseCase;
import web.ihs.usecases.GerenciarOperadoresUseCase;
import web.ihs.usecases.GerenciarPrestadoresUseCase;
import web.ihs.usecases.GerenciarServicosUseCase;
import web.ihs.usecases.LogarUseCase;

public class Main {
	private static LogarUseCase logarUseCase = new LogarUseCase();
	private static GerenciarClienteUseCase gerenciarClienteUsecase = new GerenciarClienteUseCase();
	private static GerenciarOperadoresUseCase gerenciarOperadoresUseCase = new GerenciarOperadoresUseCase();
	private static GerenciarPrestadoresUseCase gerenciarPrestadoresUseCase = new GerenciarPrestadoresUseCase();
	private static GerenciarServicosUseCase gerenciarServicosUseCase = new GerenciarServicosUseCase();
	private static EmitirRelatoriosUseCase emitirRelatorioUseCase = new EmitirRelatoriosUseCase();
	
	private static ArrayList<Operador> repositorioOperadores = new ArrayList<Operador>();
	private static ArrayList<Cliente> repositorioClientes = new ArrayList<Cliente>();
	private static ArrayList<PrestadorServico> repositorioPrestadorServicos = new ArrayList<PrestadorServico>();
	private static ArrayList<Servico> repositorioServicos = new ArrayList<Servico>();
	
	
	public static void main(String[] args) {
		Administrador admin = new Administrador("admin","admin@ihomeservices.br","123456");
		
		repositorioOperadores.add(admin);
		
		Operador op1 = new Operador("Leonardo","leo@ihomeservices.br","1234");
		Operador op2 = new Operador("Lucas","lucas@ihomeservices.br","12345");
		repositorioOperadores.add(op1);
		repositorioOperadores.add(op2);
		
		Cliente c1 = new Cliente("Jorge","123456789","R.Chile,1960","(16)99998888");
		Cliente c2 = new Cliente("Valter","123456788","R.Bolivia,60","(16)99997777");
		repositorioClientes.add(c1);
		repositorioClientes.add(c2);
		
		PrestadorServico p1 = new PrestadorServico("Willer","98745612399","R.Amazonas,2000","(11)94959887","Eletricista",200,true);
		PrestadorServico p2 = new PrestadorServico("Gustavo","98745612388","R.Amazonas,2000","(11)94959887","Encanador",200,true);
		repositorioPrestadorServicos.add(p1);
		repositorioPrestadorServicos.add(p2);
		
		Servico s1 = new Servico (1,"123456789","98745612399",5,500,10,5,"28-06-2021","Eletricista",true);
		Servico s2 = new Servico (2,"123456789","98745612388",5,500,10,5,"26-06-2021","Mecanico",false);
		Servico s3 = new Servico (3,"123456789","98745612399",5,500,10,9,"25-06-2021","Eletricista",true);
		Servico s4 = new Servico (4,"123456788","98745612388",5,500,10,4,"20-06-2021","Mecanico",false);
		Servico s5 = new Servico (5,"123456788","98745612388",5,500,10,6,"20-06-2021","Mecanico",true);
		repositorioServicos.add(s1);
		repositorioServicos.add(s2);
		repositorioServicos.add(s3);
		repositorioServicos.add(s4);
		repositorioServicos.add(s5);
		
		Scanner leitor = new Scanner(System.in);
		Operador usuario = null;
		String comando = "S";
		
		do {
			if(comando.equals("S")) {
				do usuario = logarUseCase.executar(leitor,repositorioOperadores);
				while (usuario == null);
			}
			comando = menuPrincipal(leitor,usuario);
		}
		while (comando != "loopInfinito");
		
		leitor.close();
	}
	public static String menuPrincipal(Scanner leitor, Operador usuario) {
		System.out.println("*** Menu Principal *** \n");
	
		if(usuario.getPermissaoAdmin())
			System.out.println("(G)erenciar (O)perador");
		
		System.out.println("(G)erenciar (C)liente");
		System.out.println("(G)erenciar (P)restador");
		System.out.println("(G)erenciar (S)ervicos");
		System.out.println("(V)er (R)elatorios");
		System.out.println("(S)air\n");
		
		System.out.println("Digite o comando:");
		String comando = leitor.next();
		
		switch(comando) {
			case "GO":{
				if(usuario.getPermissaoAdmin()) {
					gerenciarOperadoresUseCase.executar(leitor,repositorioOperadores);
				}else {
					System.out.println("Comando inválido!");
				}
				break;
			}
			case "GC":{
				gerenciarClienteUsecase.executar(leitor, repositorioClientes);
				break;
			}
			case "GP":{
				gerenciarPrestadoresUseCase.executar(leitor, repositorioPrestadorServicos);
				break;
			}
			case "GS":{
				gerenciarServicosUseCase.executar(leitor, repositorioServicos);
				break;
			}
			case "VR":{
				emitirRelatorioUseCase.executar(leitor, repositorioClientes, repositorioPrestadorServicos,repositorioServicos);
				break;
			}
			case "S":{
				usuario = null;
				return "S";
			}
			default:{
				System.out.println("Comando inválido!");
			}
		}
		return comando; 
	}
}
