package financeiro;

public class Transacao {
	private String titulo;
	private double valor;
	private Categoria categoria;
    private String data;
    private int tipo;
	
	public Transacao(String titulo, double valor, Categoria categoria, String data, int tipo) {
		this.titulo = titulo;
		this.valor = valor;
		this.categoria = categoria;
        this.data = data;
        this.tipo = tipo;
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


}
