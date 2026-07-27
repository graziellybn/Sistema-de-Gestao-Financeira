package financeiro;

import java.time.LocalDate;

public abstract class Transacao {
	private String titulo;
	private double valor;
    private String descricao;
    private LocalDate data;
	
	public Transacao(String titulo, double valor, LocalDate data, String descricao) {
		this.titulo = titulo;
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


    public void setDescricao(String descricao) {this.descricao = descricao;}


}
