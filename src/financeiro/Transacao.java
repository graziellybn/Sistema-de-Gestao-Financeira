package financeiro;

public abstract class Transacao {
	private String titulo;
	private double valor;
    private String descricao;
    private String data;
    private Categoria categoria;
	
	public Transacao(String titulo, double valor, Categoria categoria, String data, String descricao) {
		this.titulo = titulo;
		this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
		setValor(valor);
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

	public String getDescricao() {
		return descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
