package web.ihs.modelo;


public class PrestadorServico {
	private String nome;
	private String endereco;
	private String documento;
	private String telefone;
	private String servicoOferecido;
	private float valorDiaria;
	private boolean atendeUrgencia;
	
	
	public PrestadorServico(String nome,   String endereco,String documento, String telefone, String servicoOferecido,
			float valorDiaria, boolean atendeUrgencia) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.documento = documento;
		this.telefone = telefone;
		this.servicoOferecido = servicoOferecido;
		this.valorDiaria = valorDiaria;
		this.atendeUrgencia = atendeUrgencia;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getServicoOferecido() {
		return servicoOferecido;
	}
	public void setServicoOferecido(String servicoOferecido) {
		this.servicoOferecido = servicoOferecido;
	}
	public float getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public boolean getAtendeUrgencia() {
		return atendeUrgencia;
	}
	public void setAtendeUrgencia(boolean atendeUrgencia) {
		this.atendeUrgencia = atendeUrgencia;
	}
	public void informacoes() {
		System.out.println("Nome:" + getNome());
		System.out.println("Documento:"+getDocumento());
		System.out.println("Endereco:"+getEndereco());
		System.out.println("Telefone:"+ getTelefone());
		System.out.println("Servico oferecido:"+getServicoOferecido());
		System.out.println("Valor diaria:"+getValorDiaria());
		System.out.println("Atende urgencia:"+getAtendeUrgencia()+"\n");
	}

}
