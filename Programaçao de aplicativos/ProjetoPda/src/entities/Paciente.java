package entities;

import java.sql.Date;

public class Paciente {
	
	private int id;
	private String nome;
	private Date nascimento;
	private String sexo;
	private String endereco;
	private String telefone;
	private String pagamento;
	
	
	public Paciente() {
		
	}
	
	public Paciente(String nome, Date nascimento, String sexo, String endereco, String pagamento, String telefone){
		
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.endereco = endereco;
		this.telefone = telefone;
		this.pagamento = pagamento;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getPagamento() {
		return pagamento;
	}


	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	
	


	@Override
	public String toString() {
		 return "Paciente [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", sexo=" + sexo
	                + ", endereco=" + endereco + ", telefone=" + telefone + ", pagamento=" + pagamento + "]";
	    }

	

	

}
