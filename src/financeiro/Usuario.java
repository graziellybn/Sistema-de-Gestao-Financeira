package financeiro;

public class Usuario{
	private String nome;
	private String email;
	private int senha;
	
	public Usuario(String nome, String email, int senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getSenha() {
		return this.senha;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
