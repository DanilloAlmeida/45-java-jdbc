import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection conn = criaConexao.recuperarConexao();

		Statement stm = conn.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

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