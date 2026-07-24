package financeiro;

import java.util.Scanner;

public class Usuario {
	private String nome;
	private String email;
	private int senha;
	private String cpf;
    private Conta conta;
	
	public Usuario(String nome, String email, int senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

    public Usuario(String nome, String email, int senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public int getSenha() {
		return this.senha;
	}
	
	private void setSenha(int senha) {
		this.senha = senha;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
        if(this.conta == null) {
            this.conta = conta;
        }
    }







	public void mostrarInformacoesUsuario(){

		Scanner sc = new Scanner(System.in);

		System.out.println("--> Dados da sua Conta:");
		System.out.println("[Nome do Usuário]: " + getNome());
		System.out.println("[Email do Usuário]" + getEmail());
		System.out.println("Deseja ver o cpf? \nNão --> Aperte 0\nSim -- Aperte 1");

		int conf = sc.nextInt();

		while (conf != 1 && conf != 0){
			System.out.println("!Operação inválida! Deseja ver o cpf? \nNão --> Aperte 0\nSim -- Aperte 1");
			conf = sc.nextInt();
		}

		if (conf == 1){
			int senhaValidação;
			System.out.println("Digite sua Senha para ter acesso ao cpf:");
			senhaValidação = sc.nextInt();

			if(getSenha() == senhaValidação) {
				System.out.println("[CPF do Usuário]: " + getCpf());
			}
			else {
				System.out.println("Senha incorreta, processo finalizado!");
			}
		}




	}








    public boolean mudarSenha() {

        Scanner sc = new Scanner(System.in);
        int senhaValidacao, senhaNova;

        System.out.println("Digite sua senha: ");
        senhaValidacao = sc.nextInt();

        if(getSenha() == senhaValidacao) {
            System.out.println("Digite sua nova senha:");
			senhaNova = sc.nextInt();
			setSenha(senhaNova);
            return true;
        }
		else {
			System.out.println("Senha incorreta! Processo cancelado!");
			return false;
		}
    }


	public boolean mudarEmail() {

		Scanner sc = new Scanner(System.in);
		int senhaValidacao;
		String emailNovo;

		System.out.println("Digite sua senha: ");
		senhaValidacao = sc.nextInt();
		sc.nextLine();

		if (getSenha() == senhaValidacao) {
			System.out.println("Digite seu Email novo:");
			emailNovo = sc.nextLine();
			setEmail(emailNovo);
			return true;

		} else {
			System.out.println("Senha incorreta! Processo cancelado!");
			return false;

		}
	}


	public boolean mudarcpf(){

		Scanner sc = new Scanner(System.in);
		int senhaValidacao;
		String cpfNovo;

		System.out.println("Digite sua senha: ");
		senhaValidacao = sc.nextInt();
		sc.nextLine();

		if (getSenha() == senhaValidacao) {
			System.out.println("Digite seu CPF novo:");
			cpfNovo = sc.nextLine();
			setCpf(cpfNovo);
			return true;

		} else {
			System.out.println("Senha incorreta! Processo cancelado!");
			return false;

		}

	}

}
