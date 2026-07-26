package financeiro;

import java.time.LocalDate;

public abstract class Transacao {
	private String titulo;
	private double valor;
    private String descricao;
    private LocalDate data;
    private Categoria categoria;
	
	public Transacao(String titulo, double valor, Categoria categoria, LocalDate data, String descricao) {
		this.titulo = titulo;
		this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
		setValor(valor);
	}

	public Transacao(){

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

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	protected void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

    public void setDescricao(String descricao) {this.descricao = descricao;}


}
