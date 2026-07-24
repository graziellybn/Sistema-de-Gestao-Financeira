package financeiro;

import java.util.Scanner;

public class Usuario{
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

    public void setConta(Conta conta) {
        if(this.conta == null) {
            this.conta = conta;
        }
    }

    public boolean mudarSenha() {
        Scanner sc = new Scanner(System.in);
        int senhaValidacao, senhaNova;

        System.out.println("Digite sua senha: ");
        senhaValidacao = sc.nextInt();
        sc.close();

        if(getSenha() == senhaValidacao) {
            setSenha(senhaValidacao);
            return true;
        }
        return false;
    }

    //FAZER VALIDAÇÃO PRA EMAIL E CPF TAMBÉM
}
