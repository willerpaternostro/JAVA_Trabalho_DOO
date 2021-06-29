package web.ihs.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.ihs.modelo.Servico;
import web.ihs.util.ConexaoFactory;



public class ServicoDAO {
	public void cadastrar(Servico servico) throws SQLException {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "insert into servicos (id,cpfCliente,documentoPrestador,tempoGasto,valorFinal,avaliacao,dataRealizacao,status,tipoServico) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,servico.getId());
			ps.setString(2,servico.getCliente().getCpf());
			ps.setString(3,servico.getPrestador().getDocumento());
			ps.setDouble(4,servico.getTempoGasto());
			ps.setFloat(5,servico.getValorFinal());
			ps.setDouble(6,servico.getAvaliacao());
			ps.setString(7,servico.getDataRealizacao());
			ps.setBoolean(8,servico.getStatus());
			ps.setString(9,servico.getTipoServico());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw (e);
		} 
	}
	
	public void atualizar(Servico servico) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "update servicos set cpfCliente = ?, documentoPrestador= ?, tempoGasto= ?, valorFinal= ? , avaliacao= ?, dataRealizacao= ?  , status = ? , tipoServico= ?  where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1,servico.getCliente().getCpf());
			ps.setString(2,servico.getPrestador().getDocumento());
			ps.setDouble(3,servico.getTempoGasto());
			ps.setFloat(4,servico.getValorFinal());
			ps.setDouble(5,servico.getAvaliacao());
			ps.setString(6,servico.getDataRealizacao());
			ps.setBoolean(7,servico.getStatus());
			ps.setString(8,servico.getTipoServico());
			ps.setInt(9,servico.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public void excluir(int id) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "delete from servicos where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	
	public List<Servico> getServicos() {
		try (Connection conn = ConexaoFactory.getConexao();){
			String sql = "select * from servicos";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Servico> servicos = new ArrayList<Servico>();
			while(rs.next()) {
				Servico servico = new Servico(
											rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getDouble(4),
											rs.getFloat(5),
											rs.getDouble(6),
											rs.getDouble(7),
											rs.getString(8),
											rs.getBoolean(9),
											rs.getString(10)
											);
				servicos.add(servico);
			}
			return servicos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
