package web.ihs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.ihs.modelo.PrestadorServico;
import web.ihs.util.ConexaoFactory;



public class PrestadorDAO {
	public void cadastrar(PrestadorServico prestador) throws SQLException {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "insert into prestadores (nome,endereco,documento,telefone,servicoOferecido,valorDiaria,atendeUrgencia) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,prestador.getNome());
			ps.setString(2,prestador.getEndereco());
			ps.setString(3,prestador.getDocumento());
			ps.setString(4,prestador.getTelefone());
			ps.setString(5,prestador.getServicoOferecido());
			ps.setFloat(6,prestador.getValorDiaria());
			ps.setBoolean(7,prestador.getAtendeUrgencia());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw (e);
		} 
	}
	
	public void atualizar(PrestadorServico prestador) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "update prestadores set nome = ?, endereco = ?, documento = ?, telefone = ? , servicoOferecido = ? , valorDiaria = ? , atendeUrgencia = ?  where documento = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,prestador.getNome());
			ps.setString(2,prestador.getEndereco());
			ps.setString(3,prestador.getDocumento());
			ps.setString(4,prestador.getTelefone());
			ps.setString(5,prestador.getServicoOferecido());
			ps.setFloat(6,prestador.getValorDiaria());
			ps.setBoolean(7,prestador.getAtendeUrgencia());
			ps.setString(8,prestador.getDocumento());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public void excluir(String documento) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "delete from prestadores where documento = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,documento);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<PrestadorServico> getPrestadores() {
		try (Connection conn = ConexaoFactory.getConexao();){
			String sql = "select * from prestadores";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<PrestadorServico> prestadores = new ArrayList<PrestadorServico>();
			while(rs.next()) {
				PrestadorServico prestador = new PrestadorServico(
											rs.getString(1),
											rs.getString(2),
											rs.getString(3),
											rs.getString(4),
											rs.getString(5),
											rs.getFloat(6),
											rs.getBoolean(7)
											);
				prestadores.add(prestador);
			}
			return prestadores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
