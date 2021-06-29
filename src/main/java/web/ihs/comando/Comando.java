package web.ihs.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comando {
	public String executar (HttpServletRequest req, HttpServletResponse response) throws Exception;
}
