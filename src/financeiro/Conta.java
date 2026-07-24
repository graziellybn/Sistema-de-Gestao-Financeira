package financeiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

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

        usuario.setConta(this);

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
            for(Receita d : listaReceitas) {
                if(d.getTitulo().equals(nome)) {
                    listaReceitas.remove(d);
                    return true;
                }
            }
            return false;
        }
    }




    public boolean addDespesa (Despesa despesa){
        if (despesa.getValor() >= 0){
            return false;

        }
        else {
            if (this.saldo + despesa.getValor() < 0){
                Scanner sc = new Scanner(System.in);

                System.out.println("Adicionar essa Despesa em seu orçamento vai causar prejuízo em seu saldo atual!\nDeseja colocar essa despesa mesmo assim?");
                System.out.println("Sim, desejo colocar mesmo assim --> Aperte 1\nNão, Quero cancelar a operação --> Aperte 0");

                int conf = sc.nextInt();

                while (conf != 1 && conf != 0){
                    System.out.println("!Operação inválida! Deseja adicionar a Despesa? \nNão --> Aperte 0\nSim -- Aperte 1");
                    conf = sc.nextInt();
                }

                if (conf == 0){
                    System.out.println("Compreendido, Finalizando Operação");
                    return false;
                }
                else if (conf == 1){
                    System.out.println("Compreendido, adicionando despesa a sua lista de despesas!");
                    listaDespesas.add(despesa);
                    return true;
                }
            }

            listaDespesas.add(despesa);
            return true;
        }
    }




    public void getRelatMensal(){

    }





}
