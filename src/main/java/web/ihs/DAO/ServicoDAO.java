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
			String sql = "insert into servicos (cpfCliente,documentoPrestador,tempoGasto,valorFinal,porcentagemAdm,avaliacao,dataRealizacao,tipoServico,status) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,servico.getCpfCliente());
			ps.setString(2,servico.getDocumentoPrestador());
			ps.setDouble(3,servico.getTempoGasto());
			ps.setFloat(4,servico.getValorFinal());
			ps.setDouble(5,servico.getPorcentagemAdm());
			ps.setDouble(6,servico.getAvaliacao());
			ps.setString(7,servico.getDataRealizacao());
			ps.setString(8,servico.getTipoServico());
			ps.setBoolean(9,servico.getStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw (e);
		} 
	}
	
	public void atualizar(Servico servico) {
		try(Connection conn = ConexaoFactory.getConexao();) { //try with resources
			String sql = "update servicos set cpfCliente = ?, documentoPrestador= ?, tempoGasto= ?, valorFinal= ? ,porcentagemAdm =?, avaliacao= ?, dataRealizacao= ?, tipoServico= ?, status = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(servico.getId());
			System.out.println(servico.getTipoServico());
			ps.setString(1,servico.getCpfCliente());
			ps.setString(2,servico.getDocumentoPrestador());
			ps.setDouble(3,servico.getTempoGasto());
			ps.setFloat(4,servico.getValorFinal());
			ps.setDouble(5,servico.getPorcentagemAdm());
			ps.setDouble(6,servico.getAvaliacao());
			ps.setString(7,servico.getDataRealizacao());
			ps.setString(8,servico.getTipoServico());
			ps.setBoolean(9,servico.getStatus());
			ps.setInt(10,servico.getId());
			
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
											rs.getString(9),
											rs.getBoolean(10)
											);
				servicos.add(servico);
			}
			return servicos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
