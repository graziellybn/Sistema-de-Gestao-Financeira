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





    public void mostrarReceitas(){

        for(Receita r : listaReceitas){

            System.out.println("-----------------------\n");
            System.out.println("[Nome da Receita]: " + r.getTitulo());
            System.out.println("[Categoria da Receita]: " + r.getCategoria().getNome());
            System.out.println("[Valor da Receita]: " + r.getValor());
            System.out.println("[Descrição da Receita]: " + r.getDescricao());

        }

    }


    public void mostrarReceitasPorCategoria(String nome){

        boolean tem = false;
        Categoria ctg = new Categoria();

        for (Categoria c : categoriasP){
            if (c.getNome().equals(nome)){
                tem = true;
                ctg = c;
            }
        }

        if (tem){

            for (Receita r : listaReceitas){

                if (r.getCategoria().getNome().equals(nome)){
                    System.out.println("-----------------------\n");
                    System.out.println("[Nome da Receita]: " + r.getTitulo());
                    System.out.println("[Categoria da Receita]: " + r.getCategoria().getNome());
                    System.out.println("[Valor da Receita]: " + r.getValor());
                    System.out.println("[Descrição da Receita]: " + r.getDescricao());

                }

            }

        }

    }





    public void mostrarDespesas(){

        for(Despesa d : listaDespesas){

            System.out.println("-----------------------\n");
            System.out.println("[Nome da Despesa]: " + d.getTitulo());
            System.out.println("[Categoria da Despesa]: " + d.getCategoria().getNome());
            System.out.println("[Valor da Despesa]: " + d.getValor());
            System.out.println("[Descrição da Despesa]: " + d.getDescricao());

        }

    }



    public void mostrarDespesasPorCategoria(String nome){

        boolean tem = false;
        Categoria ctg = new Categoria();

        for (Categoria c : categoriasP){
            if (c.getNome().equals(nome)){
                tem = true;
                ctg = c;
            }
        }

        if (tem){

            for(Despesa d : listaDespesas){

                System.out.println("-----------------------\n");
                System.out.println("[Nome da Despesa]: " + d.getTitulo());
                System.out.println("[Categoria da Despesa]: " + d.getCategoria().getNome());
                System.out.println("[Valor da Despesa]: " + d.getValor());
                System.out.println("[Descrição da Despesa]: " + d.getDescricao());

            }

        }

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











    public boolean criarDespesa() {
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
            return false;
        }

        if (valor + categoria.getOrçamentoAtual() > categoria.getLimiteOrcamento()){
            System.out.println("O valor irá ultrapassar o limite financeiro estabelecido na categoria\nMude o valor limite da categoria " + categoria.getNome() + " ou crie uma nova categoria");
            return false;
        }

        System.out.println("Qual a prioridade dessa despesa?");
        System.out.println("Aperte 1 --> Essencial");
        System.out.println("Aperte 2 --> Importante");
        System.out.println("Aperte 3 --> Opcional");

        int prioridadeInt = sc.nextInt();
        sc.nextLine();

        while (prioridadeInt < 1 || prioridadeInt > 3) {
            System.out.println("!Opção inválida! Escolha um número de 1 a 3: ");
            prioridadeInt = sc.nextInt();
            sc.nextLine();
        }

        Prioridade prioridade;

        switch (prioridadeInt) {
            case 1:
                prioridade = Prioridade.ESSENCIAL;
                break;
            case 2:
                prioridade = Prioridade.IMPORTANTE;
                break;
            default:
                prioridade = Prioridade.OPCIONAL;
        }

        System.out.println("Qual a data que será necessário pagar essa nova despesa? ");
        String data = sc.nextLine();

        System.out.println("Dê uma breve descrição da despesa: ");
        String descricao = sc.nextLine();

        Despesa novaDespesa = new Despesa(titulo, valor, categoria, prioridade, data, descricao);

        return addDespesa(novaDespesa);
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
                    despesa.getCategoria().setOrçamentoAtual( despesa.getCategoria().getOrçamentoAtual() + despesa.getValor() );
                    listaDespesas.add(despesa);
                    return true;
                }
            }

            despesa.getCategoria().setOrçamentoAtual( despesa.getCategoria().getOrçamentoAtual() + despesa.getValor() );
            listaDespesas.add(despesa);
            return true;
        }
    }





    public boolean removeDespesa(String nome) {

        if (nome == null) {
            return false;
        }

        Despesa despesaAlvo = null;

        for (Despesa d : listaDespesas) {
            if (d.getTitulo().equals(nome)) {
                despesaAlvo = d;
                break;
            }
        }

        if (despesaAlvo == null) {
            System.out.println("Despesa não encontrada!");
            return false;
        }

        Scanner sc = new Scanner(System.in);

        if (despesaAlvo.isPotencialmenteReduzivel()) {

            if (despesaAlvo.getPrioridade() == Prioridade.IMPORTANTE){

                System.out.println("Essa despesa é classificada como Importante, tem certeza que deseja removê-la?\nAperte 1 --> Sim\nAperte 0 --> Não");
                int conf = sc.nextInt();

                while (conf != 1 && conf != 0){
                    System.out.println("!Resposta Inválida! Tem certeza que deseja remover essa despesa importante?\nAperte 1 --> Sim\nAperte 0 --> Não");
                    conf = sc.nextInt();
                }

                if (conf == 0){
                    System.out.println("Entendido! Cancelando operação...");
                    return false;
                }

            }

            listaDespesas.remove(despesaAlvo);
            atualizaSaldo();
            return true;
        }

        // só chega aqui se for ESSENCIAL

        System.out.println("Esta é uma despesa ESSENCIAL!! Tem certeza absoluta que deseja remover?");
        System.out.println("Aperte 1 --> Sim\nAperte 0 --> Não");

        int conf = sc.nextInt();
        sc.nextLine();

        while (conf != 1 && conf != 0) {
            System.out.println("!Opção inválida! Deseja remover a despesa?\nAperte 1 --> Sim\nAperte 0 --> Não");
            conf = sc.nextInt();
            sc.nextLine();
        }

        if (conf == 0) {
            return false;
        }

        listaDespesas.remove(despesaAlvo);
        atualizaSaldo();
        return true;
    }












    public boolean criarCategoria(){

        Scanner sc = new Scanner(System.in);

        System.out.println("--> Definição de Categoria de Transação Nova!\nGostaria de saber como funciona antes de criar uma categoria nova?");
        System.out.println("Aperte 1 --> Sim \tAperte 2 --> Pular Explicação \tAperte 3 --> Cancelar Processo!");
        int conf = sc.nextInt();

        while(conf != 1 && conf != 2 && conf != 3){
            System.out.println("!Reposta Inválida! Gostaria de saber como funciona antes de criar uma categoria nova?");
            conf = sc.nextInt();
        }

        if (conf == 3){
            return false;
        }

        if (conf == 1){

            System.out.println("toda receita ou despesa que você lança precisa estar ligada a uma categoria — " +
                    "\né assim que o sistema organiza seus lançamentos em grupos como \"Alimentação\", \"Moradia\", \"Lazer\", \"Transporte\", " +
                    "e assim por diante.\n Coloque suas despesas e receitas nas categorias de acordo. Além disso, toda categoria tem um limite de orçamento, " +
                    "esse limite vale para toda despesa que for adicionada,\n ou seja, toda categoria terá um limite de despesas");

            System.out.println("Toda vez que você for registrar uma nova receita ou despesa,\n o sistema mostrará a" +
                    " lista de categorias que você já tem disponíveis e pedirá pra você escolher uma delas pelo nome.");

        }


        System.out.println("Qual o nome da categoria nova?");
        String nome = sc.nextLine();

        for (Categoria c : categoriasP){
            if (c.getNome() == nome){
                System.out.println("Essa categoria já existe!");
                return false;
            }
        }

        System.out.println("Defina um limite de orçamento para essa categoria");
        double limiteOrçamento = sc.nextDouble();

        while (limiteOrçamento <= 0){
            System.out.println("Valores nulos ou negativos são inválidos, defina um limite de orçamento para essa categoria: ");
            limiteOrçamento = sc.nextDouble();
        }

        Categoria novacategoria = new Categoria(nome, limiteOrçamento);

        categoriasP.add(novacategoria);

        return true;


    }





    public void getRelatMensal(){

    }





}
