package financeiro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Receita extends Transacao{


    public Receita(String titulo, double valor, Categoria categoria, LocalDate data, String descricao){

        super(titulo, valor, categoria, data,  descricao);
    }


    @Override
    public void setValor(double valor) {
        super.setValor(Math.abs(valor));
    }


    public boolean editReceita() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        boolean confirmado = false;

        // Loop externo: repete enquanto o usuário não confirmar a escolha
        while (!confirmado) {

            int tentativas = 0;
            boolean valido = false;

            // Loop interno: valida a opção digitada, com limite de tentativas
            while (tentativas < 3 && !valido) {
                System.out.println("Escolha o que quer editar: ");
                System.out.println("0 ---> Título");
                System.out.println("1 ---> Valor");
                System.out.println("2 ---> Categoria");
                System.out.println("3 ---> Data");
                System.out.println("4 ---> Descricao");

                if (sc.hasNextInt()) {
                    opcao = sc.nextInt();
                    if (opcao >= 0 && opcao <= 4) {
                        valido = true;
                    } else {
                        System.out.println("Opção fora do intervalo (0 a 4).");
                        tentativas++;
                    }
                } else {
                    System.out.println("Entrada inválida, digite um número.");
                    sc.next(); // descarta o token inválido
                    tentativas++;
                }
            }

            // Excedeu as tentativas -> cancela tudo
            if (!valido) {
                System.out.println("Número máximo de tentativas excedido. Cancelando edição.");
                return false;
            }

            // Confirmação da escolha
            System.out.println("Você escolheu a opção " + opcao + ". Confirma? (s/n)");
            String resposta = sc.next().trim().toLowerCase();

            if (resposta.equals("s")) {
                confirmado = true; // sai do loop externo, segue com a edição
            } else if (resposta.equals("n")) {
                System.out.println("Ok, vamos escolher de novo.");
                // não faz nada especial: o while externo simplesmente repete
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
                // editar categoria
                break;
            case 3:
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

                break;
            case 4:
                System.out.println("Descrição atual: " +  getDescricao());
                System.out.println("Digite a nova descrição: ");
                String novaDescricao = sc.nextLine();
                setDescricao(novaDescricao);
                return true;
        }

        return false;
    }
}
