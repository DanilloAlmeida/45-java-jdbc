import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexcao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "0843");
		
		connection.close();
		System.out.println("fechou conexção");

	}

}
