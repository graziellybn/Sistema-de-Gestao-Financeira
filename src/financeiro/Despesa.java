package financeiro;

public class Despesa extends Transacao{
	public Despesa(String titulo, double valor, Categoria categoria) {
		super(titulo, valor, categoria);
	}
	
	@Override
	public double getAfetaSaldo() {
		return this.getValor()*-1;
	}
}
