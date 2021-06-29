package web.ihs.modelo;



public class Servico {
	private int id;
	private Cliente cliente;
	private String cpfCliente;
	private PrestadorServico prestador;
	private String documentoPrestador;
	private double tempoGasto;
	private float valorFinal;
	private double porcentagemAdm;
	private double avaliacao;
	private String dataRealizacao;
	private boolean status;
	private String tipoServico;
	
	public Servico(String cpfCliente, String documentoPrestador, double tempoGasto, float valorFinal,
			double porcentagemAdm, double avaliacao, String dataRealizacao, boolean status, String tipoServico) {
		super();

		this.cpfCliente = cpfCliente;
		this.documentoPrestador = documentoPrestador;
		this.tempoGasto = tempoGasto;
		this.valorFinal = valorFinal;
		this.porcentagemAdm = porcentagemAdm;
		this.avaliacao = avaliacao;
		this.dataRealizacao = dataRealizacao;
		this.status = status;
		this.tipoServico = tipoServico;
	}
	// Criei este segundo para ServicoDAO reconhecer quando for listar servicos
	public Servico(int id, String cpfCliente, String documentoPrestador, double tempoGasto, float valorFinal,
			double porcentagemAdm, double avaliacao, String dataRealizacao, boolean status, String tipoServico) {
		super();
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.documentoPrestador = documentoPrestador;
		this.tempoGasto = tempoGasto;
		this.valorFinal = valorFinal;
		this.porcentagemAdm = porcentagemAdm;
		this.avaliacao = avaliacao;
		this.dataRealizacao = dataRealizacao;
		this.status = status;
		this.tipoServico = tipoServico;
	}
	public int getId() {
		return id;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getDocumentoPrestador() {
		return documentoPrestador;
	}
	public void setDocumentoPrestador(String documentoPrestador) {
		this.documentoPrestador = documentoPrestador;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PrestadorServico getPrestador() {
		return prestador;
	}
	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}
	public double getTempoGasto() {
		return tempoGasto;
	}
	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	public float getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	public double getPorcentagemAdm() {
		return porcentagemAdm;
	}
	public void setPorcentagemAdm(double porcentagemAdm) {
		this.porcentagemAdm = porcentagemAdm;
	}
	public double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
	
}
