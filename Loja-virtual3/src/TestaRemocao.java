
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.recuperarConexao();
		
		Statement stm = conn.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		int linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificaddas: "+ linhasModificadas);
	}

}
