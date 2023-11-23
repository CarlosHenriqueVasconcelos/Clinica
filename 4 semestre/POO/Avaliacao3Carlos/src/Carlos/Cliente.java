package Carlos;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String senha;
	
	public Cliente(String nome, String cpf, String senha) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		
	}

	

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	



	public void setNome(String nome) {
		this.nome = nome;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}
	
}
