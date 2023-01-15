import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem2 {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection conn = criaConexao.recuperarConexao();

		PreparedStatement stm = conn.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			int id = rst.getInt("ID");
			System.out.print(id);

			String nome = rst.getString("NOME");
			System.out.print(" " + nome);

			String descricao = rst.getString("DESCRICAO");
			System.out.print("\t " + descricao);

			System.out.println("");

		}
		conn.close();
	}

}