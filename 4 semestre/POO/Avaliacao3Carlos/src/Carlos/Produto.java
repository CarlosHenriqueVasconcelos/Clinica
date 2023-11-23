package Carlos;

public class Produto {
	
	
	private String nome;
	private Integer cod;
	private Double preco;
	private Integer quantidade;
	
	public Produto(String nome, Integer cod, Double preco, Integer quantidade) {
		
		this.nome = nome;
		this.cod = cod;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	

	public String getNome() {
		return nome;
	}


	public Integer getCod() {
		return cod;
	}


	public Double getPreco() {
		return preco;
	}



	public Integer getQuantidade() {
		return quantidade;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", cod=" + cod + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}

}
