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

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() { //Executado com o filtro � encerrado
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//m�todo executado toda vez que tiver uma requisi��o para o controle
		HttpServletRequest req =  (HttpServletRequest) request;
		HttpSession sessao = req.getSession(false);
		
		String cmd = request.getParameter("comando");
		String nomeClasse = "web.loja.acesso." + cmd;
		
		try { //Feito esse bloco, n�o precisamos mais alter�-lo quando add novos comandos
			Class<?> classe = Class.forName(nomeClasse); //Conceito Reflection -> 'importa' uma classe
			Acesso acesso= (Acesso) classe.getConstructor().newInstance(); // instancia a classe
			
			if(acesso.autorizar(sessao)) { //Vimos aula passada que em alguns casos fazemos repasse e redirect
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

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException { //Executado quando filtro � iniciado
		// TODO Auto-generated method stub
	}

}
