package web.ihs.modelo;

public class Operador {
	private String nome;
	private String email;
	private String senha;
	private boolean permissaoAdmin;
	
	public Operador( String email, String nome, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.permissaoAdmin = false;
	}
	
	public Operador( String email, String nome, String senha, boolean permissao) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.permissaoAdmin = permissao;
	}
	
	public boolean getPermissaoAdmin() {
		return permissaoAdmin;
	}
	public void setPermissaoAdmin(boolean permissaoAdmin) {
		this.permissaoAdmin = permissaoAdmin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
