package web.ihs.acesso;

import javax.servlet.http.HttpSession;


public class Logar implements Acesso{

	@Override
	public boolean autorizar(HttpSession sessao) {
		return true;
	}
}
