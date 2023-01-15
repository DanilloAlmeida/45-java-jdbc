import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro3 {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conn = factory.recuperarConexao()) {
			conn.setAutoCommit(false);
			try (PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
						Statement.RETURN_GENERATED_KEYS)){
				adicionarVariavel("Smart TV", "Smart TV 45 polegadas", stm);
				adicionarVariavel("Rádio", "Rádio a pilha", stm);
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				conn.rollback();
			}
		}
	}
	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

//		if (nome.contentEquals("Rádio")) {
//			throw new RuntimeException("Não foi possível adicionar o produlo!!!!");
//		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
//		rst.close();
	}

}
