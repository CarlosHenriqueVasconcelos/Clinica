package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidade;


public class EspecialidadeDAO {
	
	private Connection conn;
	
	public EspecialidadeDAO(Connection conn) { // conexao com banco

		this.conn = conn;
	}
	
	
	public void cadastrar(Especialidade especialidade) throws SQLException {

		PreparedStatement st = null;
		

		try {

			st = conn.prepareStatement(
					"INSERT INTO especialidade (codigo, nome) values (?, ?)");

		
			st.setInt(1, especialidade.getCodigo());
			st.setString(2, especialidade.getNome());
			

			st.executeUpdate();
					

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	
	
	public List<Especialidade> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from especialidade order by nome");

			rs = st.executeQuery();

			List<Especialidade> listaEspecialidades = new ArrayList<>();

			while (rs.next()) {

				Especialidade especialidade = new Especialidade();
				especialidade.setCodigo(rs.getInt("codigo"));
				especialidade.setNome(rs.getString("nome"));
			

				listaEspecialidades.add(especialidade);
			}

			return listaEspecialidades;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public void atualizarEspecialidade(Especialidade especialidade) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("UPDATE especialidade SET codigo = ?, nome = ?");

			st.setInt(1, especialidade.getCodigo());
			st.setString(2, especialidade.getNome());
		
			

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public boolean verificarExistenciaEspecialidade(int codigo, String nome) throws SQLException {
	    PreparedStatement st = null;
	    ResultSet rs = null;

	    try {
	        // Verifica se a especialidade com o mesmo código ou nome já existe
	        st = conn.prepareStatement("SELECT COUNT(*) AS count FROM especialidade WHERE codigo = ? OR nome = ?");
	        st.setInt(1, codigo);
	        st.setString(2, nome);

	        rs = st.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt("count");
	            return count > 0;
	        }

	        return false;
	    } finally {
	        BancoDados.finalizarStatement(st);
	        BancoDados.finalizarResultSet(rs);
	    }
	}
	
	
	public int excluirEspecialidade(int codigo) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("DELETE FROM especialidade WHERE codigo = ?");

			st.setInt(1, codigo);

			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

}
