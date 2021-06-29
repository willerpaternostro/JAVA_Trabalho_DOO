package web.ihs.comando.operador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.ihs.DAO.OperadorDAO;
import web.ihs.comando.Comando;
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
			HttpSession sessao = request.getSession(true); // se a sessaão existir ela será recuperada, senão será criada uma nova
			sessao.setAttribute("usuario", usuario);
			
			if(usuario.getEmail().equals("admin")) {
				return "controle?comando=ListarProdutos";
			}else {
				return "controle?comando=Vitrine";
			}
		}else {
			return "controle?comando=LoginForm";
		}
	}
}
