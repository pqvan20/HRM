package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	private static String db_url = "jdbc:mysql://localhost:3306/employeeManagement?characterEncoding=UTF-8";
	private static String db_user = "root";
	private static String db_pass = "admin";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {

		try {
			Connection con = (Connection) DriverManager.getConnection(db_url, db_user, db_pass);
			Statement stm = (Statement) con.createStatement();
			String query = "SELECT * FROM employee";
			ResultSet rs = stm.executeQuery(query);

			System.out.println("___________EMPLOYEE___________ ");
			// display data to console
			while (rs.next()) {
				System.out.println("newspaper ID: " + rs.getInt(1));
				System.out.println("newspaper title:  " + rs.getString(2));
				System.out.println("newspaper content: " + rs.getString(3));
				System.out.println("__________________________");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
