package financeiro;

public class Despesa extends Transacao{

    private boolean essencial;

    public Despesa(String titulo, double valor, Categoria categoria, boolean essencial){

        super(titulo, valor, categoria);
        this.essencial = essencial;

        super.setValor(super.getValor()*(-1));

    }

    //Almir, dá uma olhada em uma estrutura chamada "enum", eu vi que era muito interessante para definir coisas como "prioridade alta,
    //prioridade baixa, prioridade MÁXIMA", acho que seria interessante e deixaria o projeto mais "complexo", caso não, deixamos em booleano o "essencial" mesmo!




}
