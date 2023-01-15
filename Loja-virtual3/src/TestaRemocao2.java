
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao2 {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection conn = factory.recuperarConexao();
		
		PreparedStatement stm = conn.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		int linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificaddas: "+ linhasModificadas);
	}

}
