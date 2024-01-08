package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbconnection {
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:database/carlist.db");
			System.out.println("Connection success");
		} catch (ClassNotFoundException  | SQLException e) {
			System.out.println(e);
		}
		
		return con;
	}
}
