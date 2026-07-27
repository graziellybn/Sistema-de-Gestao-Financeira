package financeiro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Receita extends Transacao{


    public Receita(String titulo, double valor, LocalDate data, String descricao){

        super(titulo, valor, data,  descricao);
    }

    public Receita(){

    }


    @Override
    public void setValor(double valor) {
        super.setValor(Math.abs(valor));
    }






    public boolean editReceita() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        boolean confirmado = false;

        // repete enquanto o usuário não confirmar a escolha
        while (!confirmado) {

            int tentativas = 0;
            boolean valido = false;

            // valida c limite de tentativas
            while (tentativas < 3 && !valido) {
                System.out.println("Escolha o que quer editar: ");
                System.out.println("0 ---> Alterar Título");
                System.out.println("1 ---> Alterar Valor");
                System.out.println("2 ---> Alterar Data");
                System.out.println("3 ---> Alterar Descricao");

                if (sc.hasNextInt()) {
                    opcao = sc.nextInt();
                    if (opcao >= 0 && opcao <= 3) {
                        valido = true;
                    } else {
                        System.out.println("Opção fora do intervalo (0 a 3).");
                        tentativas++;
                    }
                } else {
                    System.out.println("Entrada inválida, digite um número.");
                    sc.next();
                    tentativas++;
                }
            }

            // Excedeu as tentativas cancela geral
            if (!valido) {
                System.out.println("Número máximo de tentativas excedido. Cancelando edição.");
                return false;
            }

            System.out.println("Você escolheu a opção " + opcao + ". Confirma? (s/n)");
            String resposta = sc.next().trim().toLowerCase();

            if (resposta.equals("s")) {
                confirmado = true;
            } else if (resposta.equals("n")) {
                System.out.println("Ok, vamos escolher de novo.");
                // o while externo repete
            } else {
                System.out.println("Resposta inválida, considerando como 'não'.");
            }
        }

        // Aqui embaixo, opcao já foi validado e confirmado
        switch (opcao) {
            case 0:
                System.out.println("Título atual: " + getTitulo());
                System.out.println("Digite o novo título: ");
                String novoTitulo = sc.nextLine();
                setTitulo(novoTitulo);
                return true;
            case 1:
                System.out.println("Valor atual: " + getValor());
                System.out.println("Digite o novo valor: ");
                double novoValor = sc.nextDouble();
                while(novoValor <= 0 && sc.hasNextDouble()) {
                    System.out.println("Valor inválido, digite um novo valor");
                    novoValor = sc.nextDouble();
                }
                setValor(novoValor);
                return true;
            case 2:
                boolean valido = false;
                LocalDate novaData = null;
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                while (!valido) {
                    System.out.println("Digite a nova data (dd/MM/yyyy): ");
                    String texto = sc.next();

                    try {
                        novaData = LocalDate.parse(texto, formato);
                        valido = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
                    }
                }
                setData(novaData);
                return true;
            case 3:
                System.out.println("Descrição atual: " +  getDescricao());
                System.out.println("Digite a nova descrição: ");
                String novaDescricao = sc.nextLine();
                setDescricao(novaDescricao);
                return true;
        }

        return false;
    }
}
