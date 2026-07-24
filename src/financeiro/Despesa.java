package financeiro;

public class Despesa extends Transacao{

    private boolean essencial;

    public Despesa(String titulo, double valor, Categoria categoria, boolean essencial, String data, String descricao){

        super(titulo, valor, categoria, data,  descricao);
        this.essencial = essencial;

    }

    public boolean isEssencial() {
        return essencial;
    }

    public void setEssencial(boolean essencial) {
        this.essencial = essencial;
    }

    @Override
    public void setValor(double valor) {
        super.setValor(-Math.abs(valor));
    }

}
