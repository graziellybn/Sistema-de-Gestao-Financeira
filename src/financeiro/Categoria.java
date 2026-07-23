package financeiro;

public class Categoria {
	private String nome;
	private boolean essencial;
	private double limiteOrcamento;

	public Categoria(String nome, boolean essencial, double limiteOrcamento){

		this.nome = nome;
		this.essencial = essencial;
		this.limiteOrcamento = limiteOrcamento;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isEssencial() {
		return this.essencial;
	}
	public void setEssencial(boolean essencial) {
		this.essencial = essencial;
	}
	public double getLimiteOrcamento() {
		return limiteOrcamento;
	}
	public void setLimiteOrcamento(double limiteOrcamento) {
		this.limiteOrcamento = limiteOrcamento;
	}
	
	public boolean ehIgual(Categoria outraCategoria) {
		if(this.nome.equals(outraCategoria.getNome())) return true;
		else return false;
	}
	
	public String printa() {
		if(this.essencial == true) {
			return "[Essencial] " + this.nome;
		}
		else {
			return "[Normal] " + this.nome;
		}
	}
}
