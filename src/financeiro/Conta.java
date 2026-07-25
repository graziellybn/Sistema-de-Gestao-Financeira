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

        atualizaSaldo();
        return this.saldo;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }


    public ArrayList<Receita> getListaReceitas() {
        return this.listaReceitas;
    }


    public ArrayList<Despesa> getListaDespesas() {
        return this.listaDespesas;
    }


    public HashSet<Categoria> getCategoriasP() {
        return this.categoriasP;
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



    public boolean criarReceita(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome da nova Receita: ");
        String titulo = sc.nextLine();

        System.out.println("Valor da nova receita: ");
        double valor = sc.nextDouble();
        while (valor <= 0){
            System.out.println("Valores nulos ou negativos são inválidos, digite o valor correto: ");
            valor = sc.nextDouble();
        }
        sc.nextLine();

        System.out.println("Defina a categoria da receita:");
        StringBuilder sb = new StringBuilder();
        for (Categoria c : categoriasP) {                           //nem tente entender chefe
            if (sb.length() > 0) sb.append(" , ");
            sb.append(c.getNome());
        }
        System.out.println(sb.toString());

        System.out.println("Escolha qual categoria da lista acima deseja colocar a nova receita: ");
        String nomecategoria = sc.nextLine();

        Categoria categoria = null;
        for (Categoria c : categoriasP) {
            if (c.getNome().equalsIgnoreCase(nomecategoria)) {
                categoria = c;
                break;
            }
        }

        if (categoria == null){
            System.out.println("Categoria não encontrada! Operação cancelada");
            return false;
        }

        System.out.println("Qual a data que a receita entrará em sua carteira? ");
        String data = sc.nextLine();

        System.out.println("Dê uma breve descrição da receita: ");
        String descricao = sc.nextLine();

        Receita novareceita = new Receita(titulo, valor, categoria, data, descricao);

        return addReceita(novareceita);

    }



    private boolean addReceita(Receita receita) {
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











    public Despesa criarDespesa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome da nova Despesa: ");
        String titulo = sc.nextLine();

        System.out.println("Valor da nova despesa: ");
        double valor = sc.nextDouble();
        while (valor <= 0){
            System.out.println("Valores nulos ou negativos são inválidos, digite o valor correto: ");
            valor = sc.nextDouble();
        }
        sc.nextLine();

        System.out.println("Defina a categoria da despesa:");
        StringBuilder sb = new StringBuilder();
        for (Categoria c : categoriasP) {
            if (sb.length() > 0) sb.append(" , ");           //genuinamente maluquice, é só algo pra imprimir os nomes das categorias em uma linha
            sb.append(c.getNome());
        }
        System.out.println(sb.toString());

        System.out.println("Escolha qual categoria da lista acima deseja colocar a nova despesa: ");
        String nomeCategoria = sc.nextLine();

        Categoria categoria = null;
        for (Categoria c : categoriasP) {
            if (c.getNome().equalsIgnoreCase(nomeCategoria)) {
                categoria = c;
                break;
            }
        }
        if (categoria == null) {
            System.out.println("Categoria não encontrada! Operação cancelada.");
            return null;
        }

        System.out.println("Essa despesa é essencial? \nNão --> Aperte 0\nSim --> Aperte 1");
        int essencialInt = sc.nextInt();
        sc.nextLine();

        while (essencialInt != 0 && essencialInt != 1) {
            System.out.println("!Operação inválida! Essa despesa é essencial? \nNão --> Aperte 0\nSim --> Aperte 1");
            essencialInt = sc.nextInt();
            sc.nextLine();
        }

        boolean essencial = false;

        if (essencialInt == 1){
            essencial = true;
        }

        System.out.println("Qual a data que será necessário pagar essa nova despesa? ");
        String data = sc.nextLine();

        System.out.println("Dê uma breve descrição da despesa: ");
        String descricao = sc.nextLine();

        return new Despesa(titulo, valor, categoria, essencial, data, descricao);
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
