package web.ihs.acesso;

import javax.servlet.http.HttpSession;

public interface Acesso {
	
	public boolean autorizar(HttpSession sessao);

}
