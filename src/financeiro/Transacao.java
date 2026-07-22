package financeiro;

public abstract class Transacao {
	private String titulo;
	private double valor;
	private Categoria categoria;
	
	public Transacao(String titulo, double valor, Categoria categoria) {
		this.titulo = titulo;
		this.valor = valor;
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public abstract double getAfetaSaldo();
}
