package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Especialidade;

public class EspecialidadeDAOTeste {
	
	
	public static void cadastrarEspecialidadeTeste() throws SQLException, IOException {
	    Especialidade especialidade = new Especialidade();
	    especialidade.setCodigo(1);
	    especialidade.setNome("Cardiologia");

	    Connection conn = BancoDados.conectar();
	    EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);

	    try {
	        if (!especialidadeDAO.verificarExistenciaEspecialidade(especialidade.getCodigo(), especialidade.getNome())) {
	            especialidadeDAO.cadastrar(especialidade);
	            System.out.println("Cadastro de especialidade efetuado com sucesso.");
	        } else {
	            System.out.println("Especialidade já existe ou código já utilizado.");
	        }
	    } finally {
	        BancoDados.desconectar();
	    }
	}
    
    
    

    public static void buscarTodasEspecialidadesTeste() throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        List<Especialidade> listaEspecialidades = new EspecialidadeDAO(conn).buscarTodos();

        if (!listaEspecialidades.isEmpty()) {
            for (Especialidade especialidade : listaEspecialidades) {
                System.out.println("Especialidade encontrada: " +
                        "Código: " + especialidade.getCodigo() +
                        " - Nome: " + especialidade.getNome());
            }
        } else {
            System.out.println("Nenhuma especialidade encontrada.");
        }
    }
    
    

    public static void atualizarEspecialidadeTeste() throws SQLException, IOException {
        Especialidade especialidade = new Especialidade();
        especialidade.setCodigo(1);
        especialidade.setNome("Ortopedia");

        Connection conn = BancoDados.conectar();
        new EspecialidadeDAO(conn).atualizarEspecialidade(especialidade);

        System.out.println("Especialidade atualizada com sucesso.");
    }
    
    

    public static void excluirEspecialidadeTeste() throws SQLException, IOException {
        int codigoEspecialidade = 1;

        Connection conn = BancoDados.conectar();
        int linhasManipuladas = new EspecialidadeDAO(conn).excluirEspecialidade(codigoEspecialidade);

        if (linhasManipuladas > 0) {
            System.out.println("Especialidade excluída com sucesso.");
        } else {
            System.out.println("Nenhuma especialidade foi encontrada para exclusão.");
        }
    }
    
    
    
    public static void main(String[] args) {
        try {
            cadastrarEspecialidadeTeste();
            buscarTodasEspecialidadesTeste();
            atualizarEspecialidadeTeste();
            excluirEspecialidadeTeste();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
