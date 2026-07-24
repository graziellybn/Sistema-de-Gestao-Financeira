package financeiro;

import java.util.ArrayList;
import java.util.HashSet;

public class Conta implements Relatorio {

    private Usuario usuario;

    private ArrayList<Receita> listaReceitas;
    private ArrayList<Despesa> listaDespesas;

    private HashSet<Categoria> categoriasP;

    private double saldo;





    public Conta(Usuario usuario, Categoria categoria) {
        this.usuario = usuario;

        this.categoriasP = new HashSet<>(); //acho justo que o usuário tenha ao menos uma categoria antes de criar a conta! (CONCORDO)
        categoriasP.add(categoria);

        this.listaReceitas = new ArrayList<>();
        this.listaDespesas = new ArrayList<>();

    }

    public double getSaldo() {

        double saldoAtual = 0;

        for(Receita receita : this.listaReceitas) {
            saldoAtual += receita.getValor();
        }
        for(Despesa despesa : this.listaDespesas) {
            saldoAtual += despesa.getValor();
        }

        this.saldo = saldoAtual;
        return saldo;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public ArrayList<Receita> getListaReceitas() {
        return listaReceitas;
    }


    public ArrayList<Despesa> getListaDespesas() {
        return listaDespesas;
    }


    public HashSet<Categoria> getCategoriasP() {
        return categoriasP;
    }


    private void atualizaSaldo() {
        double saldoAtual = 0;

        for(Receita receita : this.listaReceitas) {
            saldoAtual += receita.getValor();
        }
        for(Despesa despesa : this.listaDespesas) {
            saldoAtual += despesa.getValor();
        }

        this.saldo = saldoAtual;
    }



    public boolean addReceita(Receita receita) {
        if(receita.getValor() <= 0) {
            return false;
        }
        else getListaReceitas().add(receita);
        return true;
    }

    public boolean removeReceita(String nome) {
        if(nome == null) return false;
        else {
            for(Despesa d : listaDespesas) {
                if(d.getTitulo().equals(nome)) {
                    listaDespesas.remove(d);
                    return true;
                }
            }
            return false;
        }
    }




    public void getRelatMensal(){

    }





}
