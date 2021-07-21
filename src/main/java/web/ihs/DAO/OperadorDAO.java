package web.ihs.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.ihs.modelo.Operador;
import web.ihs.util.ConexaoFactory;


public class OperadorDAO {
	public void cadastrar(Operador operador) throws SQLException {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "insert into operadores (email,nome,senha) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,operador.getEmail());
			ps.setString(2,operador.getNome());
			ps.setString(3,operador.getSenha());
	
			ps.executeUpdate();
		} catch (SQLException e) {
			throw (e);
		} 
	}
	
	public void atualizar(Operador operador) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "update operadores set email = ?, nome = ?,  senha = ? where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,operador.getEmail());
			ps.setString(2,operador.getNome());
			ps.setString(3,operador.getSenha());
			ps.setString(4,operador.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public void excluir(String email) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "delete from operadores where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,email);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Operador> getOperadores() {
		try (Connection conn = ConexaoFactory.getConexao();){
			String sql = "select * from operadores";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Operador> operadores = new ArrayList<Operador>();
			while(rs.next()) {
				Operador operador = new Operador(rs.getString(1),
											rs.getString(2),
											rs.getString(3)
											);
				operadores.add(operador);
			}
			return operadores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Operador getOperador(String email) {
		try (Connection conn = ConexaoFactory.getConexao();){
			String sql = "select * from operadores where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Operador operador = null;
			while(rs.next()) {
				operador = new Operador(rs.getString(1), rs.getString(2),rs.getString(3));
			}
			return operador;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean autenticar(Operador usuario) {
		String sql = "select * from operadores where email=? and senha=?";
		try(Connection conn = ConexaoFactory.getConexao()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,usuario.getEmail());
			ps.setString(2,usuario.getSenha());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
