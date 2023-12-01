package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Paciente;


public class PacienteDAO {
	
	private Connection conn;

	public PacienteDAO(Connection conn) { // conexao com banco

		this.conn = conn;
	}

	public void cadastrar(Paciente paciente) throws SQLException {

		PreparedStatement st = null;
		ResultSet generatedKeys = null;

		try {

			st = conn.prepareStatement(
					"INSERT INTO paciente (nome, nascimento, sexo, endereco, telefone, pagamento) values (?, ?, ?, ?, ?, ?)");

		
			st.setString(1, paciente.getNome());
			st.setDate(2, paciente.getNascimento());
			st.setString(3, paciente.getSexo());
			st.setString(4, paciente.getEndereco());
			st.setString(5, paciente.getTelefone());
			st.setString(6, paciente.getPagamento());

			st.executeUpdate();
			
			generatedKeys = st.getGeneratedKeys();
		    if (generatedKeys.next()) {
		        int id = generatedKeys.getInt(1);
		        paciente.setId(id);
		    }

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Paciente> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from paciente order by nome");

			rs = st.executeQuery();

			List<Paciente> listaPacientes = new ArrayList<>();

			while (rs.next()) {

				Paciente paciente = new Paciente();
				paciente.setId(rs.getInt("ID"));
				paciente.setNome(rs.getString("nome"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setEndereco(rs.getString("endereco"));
				paciente.setNascimento(rs.getDate("nascimento"));
				paciente.setTelefone(rs.getString("telefone"));
				paciente.setPagamento(rs.getString("pagamento"));

				listaPacientes.add(paciente);
			}

			return listaPacientes;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public List<Paciente> buscarPorNome(String nome) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM paciente WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            List<Paciente> pacientes = new ArrayList<>();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("ID"));
                paciente.setNome(rs.getString("nome"));
                paciente.setNascimento(rs.getDate("nascimento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setPagamento(rs.getString("pagamento"));
                pacientes.add(paciente);
            }

            return pacientes;
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
        }
    }
	public void atualizarPaciente(Paciente paciente) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("update paciente set nome = ?, nascimento = ?, sexo = ?, endereco = ?, telefone = ?, pagamento = ? where ID = ?");

			st.setString(1, paciente.getNome());
			st.setDate(2, paciente.getNascimento());
			st.setString(3, paciente.getSexo());
			st.setString(4, paciente.getEndereco());
			st.setString(5, paciente.getTelefone());
			st.setString(6, paciente.getPagamento());
			

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public int excluirPaciente(int id) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("delete from paciente where ID = ?");

			st.setInt(1, id);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	

}
