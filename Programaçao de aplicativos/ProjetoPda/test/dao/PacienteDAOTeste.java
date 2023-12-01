package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entities.Paciente;


public class PacienteDAOTeste {

	public static void cadastrarPacienteTeste() throws SQLException, IOException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Paciente paciente = new Paciente();
		paciente.setNome("Victor Cocito");
		paciente.setNascimento(new java.sql.Date(sdf.parse("22/08/2001").getTime()));
		paciente.setSexo("Feminino");
		paciente.setEndereco("Av. Santos");
		paciente.setTelefone("42999599077");
		paciente.setPagamento("Calote");

		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).cadastrar(paciente);

		System.out.println("Cadastro efetuado com sucesso.");
	}

	public static void buscarTodosPacientesTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Paciente> listaPacientes = new PacienteDAO(conn).buscarTodos();

		for (Paciente paciente : listaPacientes) {
            System.out.println("ID: " + paciente.getId() +
                    " - Nome: " + paciente.getNome() +
                    " - Nascimento: " + paciente.getNascimento() +
                    " - Sexo: " + paciente.getSexo() +
                    " - Endereço: " + paciente.getEndereco() +
                    " - Telefone: " + paciente.getTelefone() +
                    " - Pagamento: " + paciente.getPagamento());
        }
	}

	public static void buscarPorNomeTeste() throws SQLException, IOException {
        String nome = "Victor Cocito";

        Connection conn = BancoDados.conectar();
        List<Paciente> pacientes = new PacienteDAO(conn).buscarPorNome(nome);

        if (!pacientes.isEmpty()) {
            for (Paciente paciente : pacientes) {
                System.out.println("Paciente encontrado: " +
                        "ID: " + paciente.getId() +
                        " - Nome: " + paciente.getNome() +
                        " - Nascimento: " + paciente.getNascimento() +
                        " - Sexo: " + paciente.getSexo() +
                        " - Endereço: " + paciente.getEndereco() +
                        " - Telefone: " + paciente.getTelefone() +
                        " - Pagamento: " + paciente.getPagamento());
            }
        } else {
            System.out.println("Nenhum paciente encontrado.");
        }
    }

	public static void atualizarPacienteTeste() throws SQLException, IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Paciente paciente = new Paciente();
        paciente.setId(1); // Substitua pelo ID do paciente que deseja atualizar
        paciente.setNome("Novo Nome");
        paciente.setNascimento(new java.sql.Date(sdf.parse("01/01/1990").getTime()));
        paciente.setSexo("Masculino");
        paciente.setEndereco("Novo Endereço");
        paciente.setTelefone("999999999");
        paciente.setPagamento("Dinheiro");

        Connection conn = BancoDados.conectar();
        new PacienteDAO(conn).atualizarPaciente(paciente);

        System.out.println("Paciente atualizado com sucesso.");
    }

	public static void excluirPacienteTeste() throws SQLException, IOException {
        int id = 1; 

        Connection conn = BancoDados.conectar();
        int linhasManipuladas = new PacienteDAO(conn).excluirPaciente(id);

        if (linhasManipuladas > 0) {
            System.out.println("Paciente excluído com sucesso.");
        } else {
            System.out.println("Nenhum registro foi encontrado.");
        }
    }

	public static void main(String[] args) throws ParseException {

		try {

			
			PacienteDAOTeste.excluirPacienteTeste();
			PacienteDAOTeste.buscarTodosPacientesTeste();
			//PacienteDAOTeste.cadastrarPacienteTeste();
			

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		} 
	}
	
}