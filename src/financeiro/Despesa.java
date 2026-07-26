package financeiro;

import java.time.LocalDate;

public class Despesa extends Transacao{

    private Prioridade prioridade;

    public Despesa(String titulo, double valor, Categoria categoria, Prioridade prioridade, LocalDate data, String descricao){

        super(titulo, valor, categoria, data,  descricao);
        this.prioridade = prioridade;

    }

    public Despesa() {

    }







    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public void setValor(double valor) {
        super.setValor(-Math.abs(valor));
    }

    public boolean isPotencialmenteReduzivel() {
        return this.prioridade.isPotencialmenteReduzivel();
    }

}
