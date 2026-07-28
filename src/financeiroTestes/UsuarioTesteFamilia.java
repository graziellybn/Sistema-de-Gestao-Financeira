package financeiroTestes;

import financeiro.*;

import java.util.Scanner;

public class UsuarioTesteFamilia {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Almir", "email@gmail", 1234, "12345678");
        Usuario usuario2 = new Usuario("Joao", "gmail@email", 4321, "87654321");
        Conta conta = new Conta(usuario, usuario2);
        conta.adicionarUsuario();
        Usuario usuarioAtual = usuario;
        int ESTADO = 1;
        int operacao = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n");

            //Saldo
            System.out.println("==================================");
            System.out.println("Seu saldo atual é de R$ " + conta.getSaldo());
            System.out.println("==================================");

            System.out.println("\nQual operação deseja realizar?");
            //Sair do sistema
            System.out.println("\n0 ---> Sair do sistema");
            //criar transação
            System.out.println("1 ---> Gerenciar Transação");
            //ver transação
            System.out.println("2 ---> Ver Transações");
            //criar categoria
            System.out.println("3 ---> Gerenciar Categoria");
            //ver categorias
            System.out.println("4 ---> Ver categorias");
            //Gerar relatorio
            System.out.println("5 ---> Gerar relatório");
            //Gerar análise
            System.out.println("6 ---> Gerar análise");

            System.out.println("7 ---> Trocar usuário");

            System.out.println("\n");
            System.out.println("Usuário atual: " + usuarioAtual.getNome());
            System.out.println();

            operacao = sc.nextInt();
            sc.nextLine();
            switch (operacao) {
                case 0:
                    ESTADO = 0;
                    break;
                case 1:
                    int opcode1 = 0;
                    do{
                        System.out.println("\n");
                        System.out.println("Deseja gerenciar uma receita ou despesa?");
                        System.out.println("1 ---> Receita");
                        System.out.println("2 ---> Despesa");
                        opcode1 =  sc.nextInt();
                        sc.nextLine();
                    }while(opcode1 < 0 || opcode1 > 2);
                    switch (opcode1) {
                        case 0:
                            System.out.println("Finalizando operação...");
                            break;
                        case 1:
                            int o = 0;
                            do{
                                System.out.println("Deseja criar, editar ou remover receitas?");
                                System.out.println("1 ---> Criar");
                                System.out.println("2 ---> Editar");
                                System.out.println("3 ---> Remover");
                                o = sc.nextInt();
                                sc.nextLine();
                            }while(o < 0 || o > 3);
                            switch(o) {
                                case 0:
                                    System.out.println("Finalizando operação...");
                                    break;
                                case 1:
                                    conta.criarReceita();
                                    break;
                                case 2:
                                    System.out.println("Digite o nome da receita: ");
                                    String nome1 = sc.nextLine();
                                    for(Receita r : conta.getListaReceitas()) {
                                        if(r.getTitulo().equals(nome1)) {
                                            r.editReceita();
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Digite o nome da receita: ");
                                    String nome2 = sc.nextLine();
                                    conta.removeReceita(nome2);
                            }
                            break;
                        case 2:
                            o = 0;
                            do{
                                System.out.println("Deseja criar, editar ou remover despesas?");
                                System.out.println("1 ---> Criar");
                                System.out.println("2 ---> Editar");
                                System.out.println("3 ---> Remover");
                                o = sc.nextInt();
                                sc.nextLine();
                            }while(o < 0 || o > 3);
                            switch(o) {
                                case 0:
                                    System.out.println("Finalizando operação...");
                                    break;
                                case 1:
                                    conta.criarDespesa();
                                    break;
                                case 2:
                                    System.out.println("Digite o nome da despesa: ");
                                    String nome1 = sc.nextLine();
                                    for(Despesa s : conta.getListaDespesas()) {
                                        if(s.getTitulo().equals(nome1)) {
                                            s.editReceita();
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Digite o nome da despesa: ");
                                    String nome2 = sc.nextLine();
                                    conta.removeDespesa(nome2);
                            }
                            break;

                    }
                    break;
                case 2:
                    int opcode2 = 0;
                    do{
                        System.out.println("\n");
                        System.out.println("Deseja visualizar as receitas ou despesas?");
                        System.out.println("1 ---> Receita");
                        System.out.println("2 ---> Despesa");
                        opcode2 =  sc.nextInt();
                        sc.nextLine();
                    }while(opcode2 < 0 || opcode2 > 2);
                    switch (opcode2) {
                        case 0:
                            System.out.println("Finalizando operação...");;
                            break;
                        case 1:
                            conta.mostrarReceitas();
                            break;
                        case 2:
                            conta.mostrarDespesas();
                            break;

                    }
                    break;
                case 3:
                    int o2 = 0;
                    do {
                        System.out.println("Deseja criar, editar ou remover Categoria?");
                        System.out.println("1 ---> Criar");
                        System.out.println("2 ---> Editar");
                        System.out.println("3 ---> Remover");
                        o2 = sc.nextInt();
                        sc.nextLine();
                    }while(o2 < 0 || o2 > 3);
                    switch(o2) {
                        case 0:
                            System.out.println("Finalizando operação...");
                            break;
                        case 1:
                            conta.criarCategoria();
                            break;
                        case 2:
                            System.out.println("Digite o nome da Categoria: ");
                            String categoria = sc.nextLine();
                            for(Categoria cat : conta.getCategoriasP()) {
                                if(cat.getNome().equals(categoria)) {
                                    cat.editCategoria();
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Digite o nome da Categoria: ");
                            String cate = sc.nextLine();
                            conta.removeCategoria(cate);
                            break;
                    }
                    break;
                case 4:
                    conta.mostrarCategorias();
                    break;
                case 5:
                    conta.getRelatorio();
                    break;
                case 6:
                    conta.getAnalise();
                    break;
                case 7:
                    System.out.println("Digite a senha: ");
                    int senhaTeste = sc.nextInt();
                    sc.nextLine();
                    if(senhaTeste == usuarioAtual.getSenha()) {
                        System.out.println("Usuários disponíveis: \n");
                        conta.mostrarListaUsuarios();
                        System.out.println("Digite o nome do usuário: ");
                        String name = sc.nextLine();
                        for(Usuario u : conta.getUsuario()) {
                            if(u.getNome().equals(name)) {
                                usuarioAtual = u;
                                break;
                            }
                        }
                        System.out.println("Usuário não encontrado, cancelando operação...");
                    }
                    System.out.println("Senha incorreta, finalizando operação...");
                    break;
            }
        }while(ESTADO != 0 && operacao > 0 && operacao < 8);

        System.out.println("FINALIZANDO SISTEMA...");
        return;
    }
}
