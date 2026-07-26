package financeiro;

public class Categoria {
	private String nome;
	private double limiteOrcamento;
	private double orçamentoAtual;

	public Categoria(String nome, double limiteOrcamento){

		this.nome = nome;
		this.limiteOrcamento = limiteOrcamento;
		this.orçamentoAtual = 0;
	}

	public Categoria(){

	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getOrçamentoAtual() {
		return orçamentoAtual;
	}

	public void setOrçamentoAtual(double orçamentoAtual) {
		this.orçamentoAtual = orçamentoAtual;
	}

	public double getLimiteOrcamento() {
		return limiteOrcamento;
	}

	
	public boolean ehIgual(Categoria outraCategoria) {
		if(this.nome.equals(outraCategoria.getNome())) return true;
		else return false;
	}
	
	public void mostraInformaçoesCategoria() {
		System.out.println("Categoria: " + this.getNome());
		System.out.println("Valor atual de gastos: " + this.getOrçamentoAtual());
		System.out.println("limite de orçamento:" + this.getLimiteOrcamento());
	}
}
