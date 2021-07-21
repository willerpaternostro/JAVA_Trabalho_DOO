package web.ihs.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.ihs.acesso.Acesso;

/**
 * Servlet Filter implementation class ControleAcesso
 */
@WebFilter("/controle")
public class ControleAcesso implements Filter {

	public void destroy() { //Executado com o filtro é encerrado
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//método executado toda vez que tiver uma requisição para o controle
		HttpServletRequest req =  (HttpServletRequest) request;
		HttpSession sessao = req.getSession(false);
		
		String cmd = request.getParameter("comando");
		String nomeClasse = "web.ihs.acesso." + cmd;
		
		try { 
			Class<?> classe = Class.forName(nomeClasse); 
			Acesso acesso= (Acesso) classe.getConstructor().newInstance(); 
			
			if(acesso.autorizar(sessao)) { 
				chain.doFilter(request, response);
			}else {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect("controle?comando=LoginForm");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { //Executado quando filtro é iniciado
		// TODO Auto-generated method stub
	}

}
