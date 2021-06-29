package web.ihs.comando.operador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.ihs.comando.Comando;

public class Deslogar implements Comando{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sessao = request.getSession();
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		return "controle?comando=LoginForm";
	}
}
