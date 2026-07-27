package financeiro;

import java.util.Scanner;

public class Categoria {
	private String nome;
	private double limiteOrcamento;
	private double orçamentoAtual;

	public Categoria(String nome, double limiteOrcamento){

		this.nome = nome;
		this.limiteOrcamento = limiteOrcamento;
		this.orçamentoAtual = 0;
	}

	public Categoria(String nome){
        this.nome = nome;
	}

    public Categoria(){};
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getOrçamentoAtual() {
		return orçamentoAtual;
	}

	public void setOrçamentoAtual(double orçamentoAtual) {
		this.orçamentoAtual = orçamentoAtual;
	}

	public double getLimiteOrcamento() {
		return limiteOrcamento;
	}

    private void setLimiteOrcamento(double LimiteOrcamento) {this.orçamentoAtual = LimiteOrcamento;}

	
	public boolean ehIgual(Categoria outraCategoria) {
		if(this.nome.equals(outraCategoria.getNome())) return true;
		else return false;
	}
	
	public void mostraInformaçoes() {
		System.out.println("Categoria: " + this.getNome());
		System.out.println("Valor atual de gastos: " + this.getOrçamentoAtual());
		System.out.println("limite de orçamento:" + this.getLimiteOrcamento());
	}

    public boolean editCategoria() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        boolean confirmado = false;


        while (!confirmado) {

            int tentativas = 0;
            boolean valido = false;

            while (tentativas < 3 && !valido) {
                System.out.println("Escolha o que quer editar: ");
                System.out.println("1 ---> Alterar Nome");
                System.out.println("2 ---> Alterar Limite");

                if (sc.hasNextInt()) {
                    opcao = sc.nextInt();
                    if (opcao >= 0 && opcao <= 2) {
                        valido = true;
                    } else {
                        System.out.println("Opção fora do intervalo (0 a 2).");
                        tentativas++;
                    }
                } else {
                    System.out.println("Entrada inválida, digite um número.");
                    sc.next();
                    tentativas++;
                }
            }


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

            switch (opcao) {
                case 0:
                    System.out.println("Finalizando operação...");
                    return false;
                case 1:
                    System.out.println("Nome atual: " + getNome());
                    System.out.println("Digite o novo nmoe: ");
                    String novoNome = sc.nextLine();
                    setNome(novoNome);
                    return true;
                case 2:
                    System.out.println("Limite atual: " + getLimiteOrcamento());
                    System.out.println("Digite o novo limite: ");
                    double novoValor = sc.nextDouble();
                    while (novoValor <= 0 && sc.hasNextDouble()) {
                        System.out.println("Valor inválido, digite um novo valor");
                        novoValor = sc.nextDouble();
                    }
                    setLimiteOrcamento(novoValor);
                    return true;
            }
        }
        return false;
    }
}


