package web.ihs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.ihs.modelo.Cliente;
import web.ihs.util.ConexaoFactory;



public class ClientesDAO {
	public void cadastrar(Cliente cliente) throws SQLException {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "insert into clientes (nome,cpf,endereco,telefone) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cliente.getNome());
			ps.setString(2,cliente.getCpf());
			ps.setString(3,cliente.getEndereco());
			ps.setString(4,cliente.getTelefone());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw (e);
		} 
	}
	
	public void atualizar(Cliente cliente) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "update clientes set nome = ?, cpf = ?, endereco = ?, telefone = ? where cpf = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cliente.getNome());
			ps.setString(2,cliente.getCpf());
			ps.setString(3,cliente.getEndereco());
			ps.setString(4,cliente.getTelefone());
			ps.setString(5,cliente.getCpf());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public void excluir(String cpf) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "delete from clientes where cpf = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cpf);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Cliente> getClientes() {
		try (Connection conn = ConexaoFactory.getConexao();){
			String sql = "select * from clientes";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Cliente> clientes = new ArrayList<Cliente>();
			while(rs.next()) {
				Cliente cliente = new Cliente(rs.getString(1),
											rs.getString(2),
											rs.getString(3),
											rs.getString(4)
											);
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
