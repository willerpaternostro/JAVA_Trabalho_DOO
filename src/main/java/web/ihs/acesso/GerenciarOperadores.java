package web.ihs.acesso;

import javax.servlet.http.HttpSession;

import web.ihs.modelo.Operador;

public class GerenciarOperadores implements Acesso {

	@Override
	public boolean autorizar(HttpSession sessao) {
		if(sessao == null)return false;
		Operador usuario = (Operador) sessao.getAttribute("usuario");
		if(usuario != null && usuario.getEmail().equals("admin@ihomeservices.br"))return true;
		
		return false;
	}

}
