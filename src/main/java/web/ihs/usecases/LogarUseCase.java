package web.ihs.usecases;

import java.util.ArrayList;
import java.util.Scanner;

import web.ihs.modelo.Operador;

public class LogarUseCase {
	public Operador executar(Scanner leitor, ArrayList<Operador> repositorioOperadores) {
		System.out.println("*** Tela Login *** \n");
		System.out.println("Entre com o email:");
		String email = leitor.next();
		System.out.println("Entre com a senha:");
		String senha = leitor.next();
		
		for(Operador operador:repositorioOperadores) {
			if(operador.getEmail().equals(email)  && operador.getSenha().equals(senha)) {
				System.out.println("Bem-vindo, "+ operador.getNome() + "!\n");
				return operador;
			}
		}
		System.out.println("Login inválido! Tente novamente");
		return null;
	}
}
