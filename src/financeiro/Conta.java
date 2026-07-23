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

        this.categoriasP = new HashSet<>(); //acho justo que o usuário tenha ao menos uma categoria antes de criar a conta!
        categoriasP.add(categoria);

        this.listaReceitas = new ArrayList<>();
        this.listaDespesas = new ArrayList<>();

    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
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








    public void getRelatMensal(){

    }





}
