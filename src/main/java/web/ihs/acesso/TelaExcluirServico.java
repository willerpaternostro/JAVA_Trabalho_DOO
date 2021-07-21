package web.ihs.acesso;

import javax.servlet.http.HttpSession;

import web.ihs.modelo.Operador;

public class TelaExcluirServico implements Acesso{

	@Override
	public boolean autorizar(HttpSession sessao) {
		if(sessao == null)return false;
		Operador usuario = (Operador) sessao.getAttribute("usuario");
		if(usuario != null ) return true;
		
		return false;
	}

}