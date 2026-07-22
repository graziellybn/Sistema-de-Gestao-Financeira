package financeiro;

public class Receita extends Transacao {
	public Receita(String titulo, double valor, Categoria categoria) {
		super(titulo, valor, categoria);
	}
	
	@Override
	public double getAfetaSaldo() {
		return this.getValor();
	}
}
