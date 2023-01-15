import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro2 {

	public static void main(String[] args) throws SQLException {


		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.recuperarConexao();

		PreparedStatement stm = 
				conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("Smart TV", "Smart TV 45 polegadas", stm);
		adicionarVariavel("Rádio", "Rádio a pilha", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
//		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: "+ id);
		}
		rst.close();
	}

}
