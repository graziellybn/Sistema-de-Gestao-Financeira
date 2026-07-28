package financeiro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Conta implements Relatorio {

    private ArrayList<Usuario> usuarios;

    private ArrayList<Receita> listaReceitas;
    private ArrayList<Despesa> listaDespesas;

    private HashSet<Categoria> categoriasP;

    private double saldo;





    public Conta(Usuario usuario) {

        this.usuarios = new ArrayList<>();
        this.usuarios.add(usuario);

        this.categoriasP = new HashSet<>();

        this.listaReceitas = new ArrayList<>();
        this.listaDespesas = new ArrayList<>();

        usuario.setConta(this);

    }

    public Conta(Usuario usuario, Usuario usuario2) {

        this.usuarios = new ArrayList<>();
        this.usuarios.add(usuario);
        this.usuarios.add(usuario2);

        this.categoriasP = new HashSet<>();

        this.listaReceitas = new ArrayList<>();
        this.listaDespesas = new ArrayList<>();

        usuario.setConta(this);

    }



    public double getSaldo() {

        atualizaSaldo();
        return this.saldo;
    }


    public ArrayList<Usuario> getUsuario() {
        return this.usuarios;
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






    public int mostrarListaUsuarios(){
        int count = 1;
        for (Usuario u : usuarios){
            System.out.println("\n=================-"+ count + "-===================\n");
            System.out.println("-> Nome: " + u.getNome());
            System.out.println("-> Email:" + u.getEmail());
            count++;
        }
        return count;
    }






    public void mostrarUsuarioAtual(Usuario usuario){

        System.out.println("Usuário Atual: " + usuario.getNome());
        System.out.println("Email: " + usuario.getEmail());

    }







    public Usuario buscarUsuarioPorNome(String nome){

        Scanner sc = new Scanner(System.in);

        for (Usuario u : usuarios){

            if (u.getNome().equalsIgnoreCase(nome)){

                System.out.println("digite a senha do usuário "+ u.getNome());
                int senha = sc.nextInt();

                if (u.getSenha() == senha){

                    return u;

                }
                else {
                    System.out.println("Senha Incorreta! Cancelando operação.");
                    return null;
                }

            }

        }

        System.out.println("Usuário não encontrado\n");

        return null;

    }






    public Usuario buscarUsuarioPorEmail(String email){

        Scanner sc = new Scanner(System.in);

        for (Usuario u : usuarios){

            if (u.getEmail().equalsIgnoreCase(email)){

                System.out.println("digite a senha do usuário "+ u.getNome());
                int senha = sc.nextInt();

                if (u.getSenha() == senha){

                    return u;

                }
                else {
                    System.out.println("Senha Incorreta! Cancelando operação.");
                    return null;
                }

            }

        }

        System.out.println("Usuário não encontrado\n");

        return null;


    }





    public Usuario buscarUsuarioPorCPF(String cpf) {


        Scanner sc = new Scanner(System.in);

        for (Usuario u : usuarios) {

            if (u.getCpf().equalsIgnoreCase(cpf)) {

                System.out.println("digite a senha do usuário " + u.getNome());
                int senha = sc.nextInt();

                if (u.getSenha() == senha) {

                    return u;

                } else {
                    System.out.println("Senha Incorreta! Cancelando operação.");
                    return null;
                }

            }

        }

        System.out.println("Usuário não encontrado\n");

        return null;

    }







    public boolean conferirSeEContaFamilia(){


        if (usuarios.size() > 1){

            return true;

        }

        return false;

    }






    public boolean adicionarUsuario(){

        if (usuarios.size() == 1){
            System.out.println("\nContas Individuais não podem ter mais de um usuário\n");
            return false;

        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos adicionar um novo usuário para sua conta família!\n");

        System.out.println("Qual o nome do usuário novo?");
        String nome = sc.nextLine();

        System.out.println("Adicione um email para este usuário: ");
        String email = sc.nextLine();

        System.out.println("Adicione o Cpf novo");
        String cpf = sc.nextLine();

        for (Usuario u : usuarios){

            if (u.getCpf().equalsIgnoreCase(cpf)){

                System.out.println("CPF já existe em outro usuário! Cancelando operação.\n");
                return false;

            }
        }

        System.out.println("Digite a senha do usuário:");
        int senha = sc.nextInt();

        Usuario novoUsuario = new Usuario(nome, email, senha, cpf);

        novoUsuario.setConta(this);

        usuarios.add(novoUsuario);

        return true;

    }








    public void mostrarReceitas(){

        for(Receita r : listaReceitas){

            System.out.println("\n==============================\n");
            System.out.println("[Nome da Receita]: " + r.getTitulo());
            System.out.println("[Valor da Receita]: " + r.getValor());
            System.out.println("[Data da Receita]: " + r.getData());
            System.out.println("[Descrição da Receita]: " + r.getDescricao());

        }

    }





    public void mostrarDespesas(){

        for(Despesa d : listaDespesas){

            System.out.println("\n==============================\n");
            System.out.println("[Nome da Despesa]: " + d.getTitulo());
            System.out.println("[Categoria da Despesa]: " + d.getCategoria().getNome());
            System.out.println("[Valor da Despesa]: " + d.getValor());
            System.out.println("[Data da Despesa]: " + d.getData());
            System.out.println("[Prioridade da Despesa]: " + d.getPrioridade());
            System.out.println("[Descrição da Despesa]: " + d.getDescricao());

        }

    }



    public void mostrarDespesasPorCategoria(String nome){

        boolean tem = false;
        Categoria ctg = new Categoria();

        for (Categoria c : categoriasP){
            if (c.getNome().equalsIgnoreCase(nome)){
                tem = true;
                ctg = c;
            }
        }

        if (tem){

            for(Despesa d : listaDespesas){

                if (d.getCategoria().equals(ctg)) {

                    System.out.println("\n==============================\n");
                    System.out.println("[Nome da Despesa]: " + d.getTitulo());
                    System.out.println("[Categoria da Despesa]: " + d.getCategoria().getNome());
                    System.out.println("[Valor da Despesa]: " + d.getValor());
                    System.out.println("[Descrição da Despesa]: " + d.getDescricao());
                }
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

        System.out.println("====================================");
        System.out.println("Nome da nova Receita: ");
        String titulo = sc.nextLine();

        System.out.println("Valor da nova receita: ");
        double valor = sc.nextDouble();
        while (valor <= 0){
            System.out.println("Valores nulos ou negativos são inválidos, digite o valor correto: ");
            valor = sc.nextDouble();
        }
        sc.nextLine();


        System.out.println("Qual a data que a receita entrará em sua carteira? (dd/mm/aaaa)");
        boolean valido = false;
        LocalDate data = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (!valido) {
            String texto = sc.next();

            try {
                data = LocalDate.parse(texto, formato);
                valido = true;
                sc.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
            }
        }

        System.out.println("Dê uma breve descrição da receita: ");
        String descricao = sc.nextLine();

        Receita novareceita = new Receita(titulo, valor, data, descricao);

        return addReceita(novareceita);

    }



    private boolean addReceita(Receita receita) {
        if(receita.getValor() <= 0) {
            return false;
        }
        else getListaReceitas().add(receita);
        this.atualizaSaldo();
        return true;
    }





    public boolean removeReceita(String nome) {
        if(nome == null) return false;
        else {
            for(Receita r : listaReceitas) {
                if(r.getTitulo().equals(nome)) {
                    listaReceitas.remove(r);
                    this.atualizaSaldo();
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
            System.out.println("Categoria não encontrada! Crie uma nova categoria que se adeque a essa nova despesa ou coloque-a em uma categoria já existente! Operação cancelada.");
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

        System.out.println("Qual a data que a despesa será paga? (dd/MM/yyyy)");
        boolean valido = false;
        LocalDate data = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (!valido) {
            String texto = sc.next();

            try {
                data = LocalDate.parse(texto, formato);
                valido = true;
                sc.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
            }
        }

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
                    despesa.getCategoria().setOrçamentoAtual(despesa.getCategoria().getOrçamentoAtual() + Math.abs(despesa.getValor()));
                    listaDespesas.add(despesa);
                    this.atualizaSaldo();
                    return true;
                }
            }

            despesa.getCategoria().setOrçamentoAtual(despesa.getCategoria().getOrçamentoAtual() + Math.abs(despesa.getValor()));
            listaDespesas.add(despesa);
            this.atualizaSaldo();
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
            despesaAlvo.getCategoria().setOrçamentoAtual(despesaAlvo.getCategoria().getOrçamentoAtual() - Math.abs(despesaAlvo.getValor()));
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
        despesaAlvo.getCategoria().setOrçamentoAtual(despesaAlvo.getCategoria().getOrçamentoAtual() - Math.abs(despesaAlvo.getValor()));
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
        sc.nextLine();

        if (conf == 3){
            return false;
        }

        if (conf == 1){

            System.out.println("toda despesa que você lança precisa estar ligada a uma categoria — " +
                    "\né assim que o sistema organiza seus gastos em grupos como \"Alimentação\", \"Moradia\", \"Lazer\", \"Transporte\", " +
                    "e assim por diante.\nColoque suas despesas nas categorias de acordo. Além disso, toda categoria tem um limite de orçamento, " +
                    "esse limite vale para toda despesa que for adicionada,\nTenha sempre em mente seus gastos com cada categoria");

            System.out.println("Toda vez que você for registrar uma nova receita ou despesa,\n o sistema mostrará a" +
                    " lista de categorias que você já tem disponíveis e pedirá pra você escolher uma delas pelo nome.");

        }



        System.out.println("Qual o nome da categoria nova?");
        String nome = sc.nextLine();

        for (Categoria c : categoriasP){
            if (c.getNome().equalsIgnoreCase(nome)){
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







    public boolean removeCategoria(String nome) {
        if (nome == null) return false;

        Categoria categoriaAlvo = null;

        for (Categoria c : categoriasP) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                categoriaAlvo = c;
                break;
            }
        }

        if (categoriaAlvo == null) {
            System.out.println("Categoria não encontrada! Cancelando Operaçap!");
            return false;
        }

        ArrayList<Despesa> despesasVinculadas = new ArrayList<>();

        for (Despesa d : listaDespesas) {
            if (d.getCategoria().equals(categoriaAlvo)) {
                despesasVinculadas.add(d);
            }
        }

        if (!despesasVinculadas.isEmpty()) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Existem " + despesasVinculadas.size() + " despesa(s) na categoria \"" + categoriaAlvo.getNome() + "\".");
            System.out.println("O que deseja fazer?");
            System.out.println("0 --> Cancelar remoção");
            System.out.println("1 --> Mover essas despesas para outra categoria existente");
            System.out.println("2 --> Remover a categoria e todas as despesas vinculadas a ela");

            int conf = sc.nextInt();
            sc.nextLine();

            while (conf != 0 && conf != 1 && conf != 2) {
                System.out.println("!Opção inválida! Escolha uma das três opções: ");
                conf = sc.nextInt();
                sc.nextLine();
            }

            if (conf == 0) {
                System.out.println("Operação cancelada.");
                return false;
            }

            if (conf == 1) {
                if (categoriasP.size() <= 1) {
                    System.out.println("Não há outra categoria disponível para mover as despesas. Operação cancelada.");
                    return false;
                }

                System.out.println("Categorias disponíveis:");
                StringBuilder sb = new StringBuilder();
                for (Categoria c : categoriasP) {
                    if (c.equals(categoriaAlvo)) continue;
                    if (sb.length() > 0) sb.append(" , ");
                    sb.append(c.getNome());
                }
                System.out.println(sb.toString());

                System.out.println("\nPara qual categoria da lista deseja mover as despesas?");
                String nomeDestino = sc.nextLine();

                Categoria categoriaDestino = null;
                for (Categoria c : categoriasP) {
                    if (!c.equals(categoriaAlvo) && c.getNome().equalsIgnoreCase(nomeDestino)) {
                        categoriaDestino = c;
                        break;
                    }
                }

                if (categoriaDestino == null) {
                    System.out.println("Categoria de destino não encontrada! Operação cancelada.");
                    return false;
                }

                double totalAMover = 0;
                for (Despesa d : despesasVinculadas) {
                    totalAMover += Math.abs(d.getValor());
                }

                if (categoriaDestino.getOrçamentoAtual() + totalAMover > categoriaDestino.getLimiteOrcamento()) {
                    System.out.println("Atencão!\nMover essas despesas ultrapassaria o limite de orçamento de \"" + categoriaDestino.getNome() + "\". Operação cancelada.");
                    return false;

                }

                for (Despesa d : despesasVinculadas) {
                    d.setCategoria(categoriaDestino);
                    categoriaDestino.setOrçamentoAtual(categoriaDestino.getOrçamentoAtual() + Math.abs(d.getValor()));
                }

            } else { // conf == 2
                listaDespesas.removeAll(despesasVinculadas);
                atualizaSaldo();
            }
        }

        categoriasP.remove(categoriaAlvo);
        System.out.println("Categoria Removida!\n");
        return true;
    }












    public void listarCategoriasEasDespesas(){

        double disp = 0;
        for (Categoria c : categoriasP){
            disp = c.getLimiteOrcamento() - c.getOrçamentoAtual();
            System.out.println("\n======================\n");
            System.out.println("[Nome da categoria]: " + c.getNome());
            System.out.println("[Orçamento disponível]: " + disp);
            System.out.println("Despesas da categoria: ");

            for (Despesa d : listaDespesas){
                if (d.getCategoria().equals(c)){

                    System.out.println("--> " + d.getTitulo() + " : " + d.getValor());

                }

            }
        }

    }




    public void mostrarCategorias() {
        if(categoriasP.isEmpty()){
            System.out.println("Não há nenhuma categoria disponível.");
        }
        else{
            for(Categoria c : categoriasP) {
                System.out.println("====================");
                System.out.println("[Nome]: " + c.getNome());
                System.out.println("[Limite]: " + c.getLimiteOrcamento());
                System.out.println("[Gastos]: " + c.getOrçamentoAtual());
            }
        }
    }



    @Override
    public void getRelatorio() {

        if (listaDespesas.isEmpty()){
            System.out.println("Impossível ter um relatório efetivo se não se possuem despesas! Crie e gerencie despesas antes de buscar um relatório\n");
            return;
        }

        System.out.println("---->  Relatório Geral  <----");

        double totalR = 0, totalD = 0;

        for (Receita r : listaReceitas){
            totalR = totalR + r.getValor();
        }

        for (Despesa d : listaDespesas){
            totalD = totalD + Math.abs(d.getValor());
        }

        System.out.println("- Com um saldo atual de ---> " + this.getSaldo() + " R$\n");

        System.out.println("- Seu total de receitas resulta em: "+ totalR + " R$");
        System.out.println("- Seu total de despesas resulta em: "+ totalD + " R$\n");

        System.out.println("- Lista de despesas por categoria: ");

        int cont = 1;
        for (Categoria c : categoriasP){

            System.out.println("Categoria " + cont + ": " + c.getNome());
            System.out.println("Valor gasto nessa categoria: " + c.getOrçamentoAtual());
            System.out.println("\n");
            cont++;
        }

    }


    @Override
    public void getAnalise() {


        if (listaReceitas.isEmpty() || listaDespesas.isEmpty()){
            System.out.println("Não é possível haver uma análise sem ao menos uma receita e uma despesa!");
            return;

        }

        Scanner sc = new Scanner(System.in);

        System.out.println("---->  Análise Da Conta  <----\n");

        this.atualizaSaldo();

        System.out.println("- Atualmente, contabilizando todas as despesas e receitas, seu saldo é de: " + this.saldo + " R$");

        Receita maiorReceita = new Receita();

        for (Receita r : listaReceitas){

            if (r.getValor() > maiorReceita.getValor()){
                maiorReceita = r;
            }
        }

        Despesa maiorDespesa = null;
        double totalDespesas = 0;

        for (Despesa d : listaDespesas){
            totalDespesas = totalDespesas + d.getValor();

            if (maiorDespesa == null || Math.abs(d.getValor()) > Math.abs(maiorDespesa.getValor())){
                maiorDespesa = d;
            }
        }


        System.out.println("- Sua maior despesa é: " + maiorDespesa.getTitulo() + ", com um gasto de: " + maiorDespesa.getValor() + " R$");
        System.out.println("Ela está na categoria: " + "[" + maiorDespesa.getCategoria().getNome() + "]");

        double mediaDespesa = totalDespesas / listaDespesas.size();
        System.out.println("- Valor médio por despesa: " + mediaDespesa + " R$");

        System.out.println("- Sua maior receita é: " + maiorReceita.getTitulo() + ", com um ganho de: " + maiorReceita.getValor() + " R$");


        Categoria categoriaMaior = null;
        double categoriaMaiorValor = 0;

        for (Categoria c : categoriasP){
            if (c.getOrçamentoAtual() > categoriaMaiorValor){
                categoriaMaior = c;
                categoriaMaiorValor = c.getOrçamentoAtual();
            }
        }

        System.out.println("- A sua categoria com maior volume de gastos é: [" + categoriaMaior.getNome() + "], totalizando " + categoriaMaiorValor + " R$\n");

        System.out.println("Gostaria de saber quais despesas seria interessante cortar para minimizar seus gastos?\nSim --> Aperte 1\nNão --> Aperte 0");
        int conf = sc.nextInt();

        while (conf != 1 && conf != 0){
            System.out.println("!Reposta Inválida! Deseja receber uma lista de despesas que podem ser cortáveis?\nSim --> Aperte 1\nNão --> Aperte 0");
            conf = sc.nextInt();
        }

        if (conf == 1){

            System.out.println("Listas de despesas baseadas em prioridade: \n");
            for (Despesa d : listaDespesas){
                if (d.getPrioridade().equals(Prioridade.OPCIONAL)){
                    System.out.println("- [" + d.getTitulo() + "] é classificada como uma despesa 'Opcional' , portanto, considere cortá-la de seus gastos");
                }
            }

            System.out.println("\n");

            for (Despesa d : listaDespesas){
                if (d.getPrioridade().equals(Prioridade.IMPORTANTE)){
                    System.out.println("- [" + d.getTitulo() + "] é classificada como uma despesa 'Importante' , portanto, eu não recomendaria removê-la");
                }
            }

            System.out.println("\n");

            for (Despesa d : listaDespesas){
                if (d.getPrioridade().equals(Prioridade.ESSENCIAL)){
                    System.out.println("- [" + d.getTitulo() + "] é classificada como uma despesa 'Essencial' , portanto, ela é um gasto indispensável, remoção não recomendada!");
                }
            }

        }


    }
}