package financeiro;

public class Receita extends Transacao{


    public Receita(String titulo, double valor, Categoria categoria, String data, String descricao){

        super(titulo, valor, categoria, data,  descricao);
    }


    @Override
    public void setValor(double valor) {
        super.setValor(Math.abs(valor));
    }

}
