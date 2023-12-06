package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entities.Agendamento;
import entities.Especialidade;
import entities.Medico;
import entities.Paciente;


public class AgendamentoDAOTeste {
	
	public static void cadastrarAgendamentoTeste() throws SQLException, IOException, ParseException {
	    Agendamento agendamento = new Agendamento();
	    agendamento.setHora("09:00");
	    agendamento.setData(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-01").getTime()));

	    Connection conn = BancoDados.conectar();
	    AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conn);

	    Paciente paciente = agendamentoDAO.buscarPacientePorNome("Gabriel Santos");
	    if (paciente != null) {
	        agendamento.setNomePaciente(paciente.getNome());
	        agendamento.setID_paciente(paciente);  // Adicionei esta linha para definir o paciente
	    } else {
	        System.out.println("Paciente não encontrado. Não foi possível cadastrar o agendamento.");
	        return;  // Se o paciente não for encontrado, encerre a execução do método
	    }

	    Medico medico = agendamentoDAO.buscarMedico("Luis");
	    if (medico != null) {
	        agendamento.setNomeMedico(medico.getNome());  // Ajustei esta linha para usar getNome()
	        agendamento.setCRM(medico);  // Adicionei esta linha para definir o médico
	    } else {
	        System.out.println("Médico não encontrado. Não foi possível cadastrar o agendamento.");
	        return;  // Se o médico não for encontrado, encerre a execução do método
	    }

	    agendamentoDAO.cadastrarAgendamento(agendamento);
	    System.out.println("Cadastro efetuado com sucesso.");
	}

		

    

    public static void buscarTodosAgendamentosTeste() throws SQLException, IOException {
        try (Connection conn = BancoDados.conectar()) {
            List<Agendamento> listaAgendamentos = new AgendamentoDAO(conn).buscarTodos();

            for (Agendamento agendamento : listaAgendamentos) {
                System.out.println("Código do Agendamento: " + agendamento.getCod_agendamento() +
                        " - Nome do Paciente: " + agendamento.getNomePaciente().getNome() +
                        " - Data: " + agendamento.getData() +
                        " - Hora: " + agendamento.getHora() +
                        " - Nome do Médico: " + agendamento.getNomeMedico().getNome());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os agendamentos: " + e.getMessage());
        }
    }

    public static void buscarPorNomePacienteTeste() throws SQLException, IOException {
        try (Connection conn = BancoDados.conectar()) {
            List<Agendamento> listaAgendamentos = new AgendamentoDAO(conn).buscarPorNome("Nome do Paciente");

            for (Agendamento agendamento : listaAgendamentos) {
                System.out.println("Código do Agendamento: " + agendamento.getCod_agendamento() +
                        " - Nome do Paciente: " + agendamento.getNomePaciente().getNome() +
                        " - Data: " + agendamento.getData() +
                        " - Hora: " + agendamento.getHora() +
                        " - Nome do Médico: " + agendamento.getNomeMedico().getNome());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar agendamentos por nome do paciente: " + e.getMessage());
        }
    }

    public static void excluirAgendamentoTeste() throws SQLException, IOException {
        try (Connection conn = BancoDados.conectar()) {
            int codAgendamentoParaExcluir = 1; // Substitua pelo código do agendamento que deseja excluir
            new AgendamentoDAO(conn).excluirAgendamento(codAgendamentoParaExcluir);
            System.out.println("Agendamento excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o agendamento: " + e.getMessage());
        }
    }

    public static void atualizarAgendamentoTeste() throws SQLException, IOException, ParseException {
        try (Connection conn = BancoDados.conectar()) {
            Agendamento agendamento = new Agendamento();
            agendamento.setCod_agendamento(1); // Substitua pelo código do agendamento que deseja atualizar

            // Simulando uma atualização de data e hora
            agendamento.setData(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-15").getTime()));
            agendamento.setHora("14:30");

            new AgendamentoDAO(conn).atualizarAgendamento(agendamento);
            System.out.println("Agendamento atualizado com sucesso.");
        } catch (SQLException | ParseException e) {
            System.out.println("Erro ao atualizar o agendamento: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        try {
            cadastrarAgendamentoTeste();
            //buscarTodosAgendamentosTeste();
            //buscarPorNomePacienteTeste();
            //excluirAgendamentoTeste();
            //atualizarAgendamentoTeste();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
