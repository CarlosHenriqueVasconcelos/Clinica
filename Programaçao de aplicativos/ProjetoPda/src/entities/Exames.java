package entities;


public class Exames {
	
	private int codigo;
	private String nome;
	
	
	
	
	public Exames(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Exames [codigo=" + codigo + ", nome=" + nome + "]";
	}




	
	
}
