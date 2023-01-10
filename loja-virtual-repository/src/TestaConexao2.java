import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao2 {

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "0843");

		conn.close();
	}

}
