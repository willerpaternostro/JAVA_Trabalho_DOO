package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.ihs.DAO.OperadorDAO;
import web.ihs.modelo.Operador;



public class Logar implements Comando{
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Operador usuario = new Operador(null,email,senha);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		OperadorDAO repositorio = new OperadorDAO();
		if(repositorio.autenticar(usuario)) {
			HttpSession sessao = request.getSession(true); 
			usuario = repositorio.getOperador(email);
			sessao.setAttribute("usuario", usuario);
			request.setAttribute("usuario",usuario);
			return "controle?comando=MenuAdmin";
		}else {
			String msgErro = "Login invalido. Tente novamente";
			return "controle?comando=LoginForm&erro=erro&msgErro="+msgErro;
		}
	}
}
