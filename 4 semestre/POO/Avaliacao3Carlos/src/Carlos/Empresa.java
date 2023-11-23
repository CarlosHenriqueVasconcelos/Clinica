package Carlos;

import java.util.List;
import java.util.ArrayList;

public class Empresa {
	
	
	private String nome;
	private String cnpj;
	private String inscricao;
	private String dominio;
	private List<Produto> produto1;
	private List<Cliente> cliente1;
	
	
	public Empresa(String nome, String cnpj, String inscricao, String dominio) {
	
		this.nome = nome;
		this.cnpj = cnpj;
		this.inscricao = inscricao;
		this.dominio = dominio;
		this.produto1 = new ArrayList<Produto>();
		this.cliente1 = new ArrayList<Cliente>();
	}
	
	
	public void CadastrarProduto(Integer codigo, String nome, Double preco, Integer quantidade ) {
		
		Produto prod = new Produto(nome, codigo, preco, quantidade);
		produto1.add(prod); 
		System.out.println("Cadastrado");
		
	}
	
	public void CadastrarCliente(String nome, String cpf, String senha ) {
		
		Cliente clie = new Cliente(nome,cpf,senha);
		cliente1.add(clie);
		System.out.println("Cadastrado");
		
	}
	public void Vender(String cpf, String senha, Integer cod, Integer quantidade) {
		for(int i=0; i < cliente1.size(); i++) {
			if(cpf == cliente1.getcpf(i) && senha == cliente1.getsenha(i));
		}
		
		
		
	}
	public void ImprimirI() {
		for(int i=0; i < produto1.size(); i++) {
			
			System.out.println(produto1.get(i));
			
		}
	}
	
	
	
}
