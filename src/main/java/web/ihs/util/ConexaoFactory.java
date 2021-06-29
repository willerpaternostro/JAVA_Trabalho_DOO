package web.ihs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConexao() {
		try {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ihomeservicedb","sa","");
		} catch (ClassNotFoundException | SQLException e) {
			throw new  RuntimeException(e);
		}
	}
}
