package web.ihs.modelo;



public class Servico {
	private int id; // sentimos falta de ter um identificador do serviço realizado, portanto, colocamos este atributo
	private String cpfCliente;
	private String documentoPrestador;
	private double tempoGasto; //Poderia ser em dias(int), já que o valor é calculado em diária
	private float valorFinal; // (Valor diaria * dias trabalhados)-porcentagemADM
	private double porcentagemAdm;
	private double avaliacao;
	private String dataRealizacao;
	private boolean status;
	
	private String tipoServico; // Poderia ser um array
	private Cliente cliente;
	private PrestadorServico prestador;
	
	public Servico(String cpfCliente, String documentoPrestador, double tempoGasto, float valorFinal,
			double porcentagemAdm, double avaliacao, String dataRealizacao,  String tipoServico,boolean status) {
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
			double porcentagemAdm, double avaliacao, String dataRealizacao,  String tipoServico, boolean status) {
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
