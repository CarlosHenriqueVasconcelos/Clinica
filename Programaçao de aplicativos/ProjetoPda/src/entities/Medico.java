package entities;


public class Medico {
	
	private int crm;
	private String nome;
	private String endereco;
	private String telefone;
	private Especialidade codigo_especialidade;
	
	
	public Medico() {
		
		this.codigo_especialidade = new Especialidade();
	}
	
	
	public Medico(int crm, String nome, String endereco, String telefone, Especialidade codigo_especialidade) {
	
		this.crm = crm;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.codigo_especialidade = codigo_especialidade;
	}
	
	
	
	public int getCrm() {
		return crm;
	}
	
	
	public void setCrm(int crm) {
		this.crm = crm;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	public Especialidade getCodigo_especialidade() {
		return codigo_especialidade;
	}
	
	
	public void setCodigo_especialidade(Especialidade codigo_especialidade) {
		this.codigo_especialidade = codigo_especialidade;
	}
	
	
	
	@Override
	public String toString() {
		return this.getNome();
	}

}
