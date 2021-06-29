package web.ihs.acesso;

import javax.servlet.http.HttpSession;

public class Deslogar implements Acesso{

	@Override
	public boolean autorizar(HttpSession sessao) {
		if(sessao != null)return true;
		
		return false;
	}
}
