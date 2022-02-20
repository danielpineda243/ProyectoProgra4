package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

	private final String url = "jdbc:mysql://localhost/cinestar";
	private Connection con = null;

	public Connection getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.url, "root", "");
			if (con != null) {
				System.out.println("conexion Establecida");
			}
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("error: " + ex);
		}
		return con;

	}
}
