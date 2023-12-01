package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class BancoDados {
	
	private static Connection conn = null;
	
	public static Connection conectar() throws SQLException, IOException {
		
		if (conn == null) { // caso nao exista uma conexao ele faz agr
			
			Properties props = carregarPropriedades(); // carregando informações da configuração do banco
			String url = props.getProperty("dburl"); //  Pegando URL de conexao
			conn = DriverManager.getConnection(url, props); //  estabelecendo conexao atraves do metodo getConnection
		}
		
		return conn; // retorna conexao estabelecida 
	}
	
	
	
	public static void desconectar() throws SQLException {
		
		if (conn != null) {
			
			conn.close();
			conn = null;
		}
	}
	
	
	
	
	private static Properties carregarPropriedades() throws IOException {
		
		FileInputStream propriedadesBanco = null; // variavel de leitura de arquivo
		
		propriedadesBanco = new FileInputStream("database.properties"); // abre arquivo para leitura e referecia dele é armazenada na variavel

		Properties props = new Properties(); // instaciamento da variavel para armazenamento das propriedades do banco( armazenando as infoirmacoes de forma chave-valor
		props.load(propriedadesBanco); // carrega as poropriedades
		
		return props; // retorna as propriedades
		
	}
	
	
	
	public static void finalizarStatement(Statement st) throws SQLException { // finaliza objeto que executa instruçoes SQL no banco

		if (st != null) {

			st.close();
		}
	}
	
	

	public static void finalizarResultSet(ResultSet rs) throws SQLException { // Finaliza objeto que faz consultas e pega informaçoes do banco

		if (rs != null) {

			rs.close();
		}
	}

}

