package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import entities.Medico;
import entities.Especialidade;

public class MedicoDAOTeste {
	
	public static void cadastrarMedicoTeste() throws SQLException, IOException, ParseException {

	
	
		Medico medico = new Medico();
		medico.setCrm("CRM/SP-123456");
		medico.setNome("Plivio Vilas");
		medico.setEndereco("Av. Monteiro Lobato");
		medico.setTelefone("00000000");
		
		// Obtendo o código de especialidade
	    int codigoEspecialidade = EspecialidadeDAOTeste.obterCodigo("Cardiologia");

	    // Criando uma instância de Especialidade com o código obtido
	    Especialidade especialidade = new Especialidade();
	    especialidade.setCodigo(codigoEspecialidade);

	    // Atribuindo a especialidade ao médico
	    medico.setCodigo_especialidade(especialidade);
		
		Connection conn = BancoDados.conectar();
		new MedicoDAO(conn).cadastrar(medico);

		System.out.println("Cadastro efetuado com sucesso.");
	}
	
	public static void buscarTodosMedicosTeste() throws SQLException, IOException {
		
	    Connection conn = BancoDados.conectar();
	    
	    
	    List<Medico> listaMedicos = new MedicoDAO(conn).buscarTodos();

	    for (Medico medico : listaMedicos) {
	        System.out.println("CRM: " + medico.getCrm() +
	                " - Nome: " + medico.getNome() +
	                " - Endereço: " + medico.getEndereco() +
	                " - Telefone: " + medico.getTelefone() +
	                " - Código Especialidade: " + medico.getCodigo_especialidade().getCodigo());
	    }
	}
	
	
	
	public static void buscarPorNomeMedicoTeste() throws SQLException, IOException {
	    Connection conn = BancoDados.conectar();
	    List<Medico> listaMedicos = new MedicoDAO(conn).buscarPorNome("Plivio");

	    for (Medico medico : listaMedicos) {
	        System.out.println("CRM: " + medico.getCrm() +
	                " - Nome: " + medico.getNome() +
	                " - Endereço: " + medico.getEndereco() +
	                " - Telefone: " + medico.getTelefone() +
	                " - Código Especialidade: " + medico.getCodigo_especialidade().getCodigo());
	    }
	}
	
	
	public static void atualizarMedicoTeste() throws SQLException, IOException, ParseException {
	    try (Connection conn = BancoDados.conectar()) {
	        Medico medico = new Medico();
	        medico.setCrm("CRM/SP-123456");
	        medico.setNome("Luis ");
	        medico.setTelefone("(333333");
	        medico.setEndereco("Av.Monteiro");

	        Especialidade novaEspecialidade = new Especialidade();
	        novaEspecialidade.setCodigo(2);
	        medico.setCodigo_especialidade(novaEspecialidade);

	        new MedicoDAO(conn).atualizarMedico(medico);

	        System.out.println("Dados do médico atualizados com sucesso.");
	    } catch (SQLException e) {
	        System.out.println("Erro ao atualizar o médico: " + e.getMessage());
	    }
	}



	
	public static void excluirMedicoTeste() throws SQLException, IOException {
	    Connection conn = BancoDados.conectar();

	    String crmParaExcluir = "22222"; 
	    new MedicoDAO(conn).excluir(crmParaExcluir);
	    System.out.println("Médico excluído com sucesso.");


	    BancoDados.desconectar();
	}


	
	
	
	 public static void main(String[] args) throws ParseException {
	        try {
	            //cadastrarMedicoTeste();
	        	//buscarTodosMedicosTeste();
	        	//buscarPorNomeMedicoTeste();
	        	atualizarMedicoTeste();
	        	
	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	        }
	    }
	

}
