package web.ihs.acesso;

import javax.servlet.http.HttpSession;

public class LoginForm implements Acesso{

	@Override
	public boolean autorizar(HttpSession sessao) {
		return true;
	}
	
}
