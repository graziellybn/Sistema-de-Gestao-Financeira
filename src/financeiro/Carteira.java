package financeiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Carteira {

    Scanner sc = new Scanner(System.in);

    private Registro registro;
    private double saldo;
    private HashSet<Categoria> categoriasP;

    public Carteira(double saldo, Registro registro){

        this.saldo = saldo;
        this.registro = registro;
        this.categoriasP = new HashSet<>();

    }

    public double getSaldo(){
        return this.saldo;
    }





    public void addTransação(String cpf){

        System.out.println("Despesa -> aperte 0 \nReceita -> aperte 1");

        int tipo = sc.nextInt();

        if (tipo == 0){
            System.out.println("Qual a categoria dessa despesa?");
        }

        else {
            System.out.println("Qual a categoria dessa receita?");
        }

        boolean tem = false;

        String cat = sc.nextLine();

        Categoria c1 = new Categoria();

        for (Categoria c : categoriasP){
            if (c.getNome() == cat){
                tem = true;
                c1 = c;
            }
        }

        if (tem == false){
            System.out.println("Tal categoria não existe. Gostaria de criar uma nova?");
            System.out.println("Não -> aperte 0 \nSim -> aperte 1");
            int resposta = sc.nextInt();

            while (resposta != 0 && resposta != 1){
                System.out.println("Reposta inválida! Gostaria de criar uma categoria nova?");
                resposta = sc.nextInt();
            }

            if (resposta == 0){
                return;
            }
            if (resposta == 1){
                System.out.println("Tal categoria é essencial?\nNão -> aperte 0 \nSim -> aperte 1");
            }
        }


        String titulo = sc.nextLine();
        double valor = sc.nextDouble();
        String data = sc.nextLine();

        Transacao novatransação = new Transacao(titulo, valor, c1, data, tipo);

        registro.adicionarTransacao(cpf, novatransação);

    }

}
