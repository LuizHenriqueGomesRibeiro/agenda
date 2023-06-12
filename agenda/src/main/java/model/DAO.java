package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agenda?useTimezone=true&serverTimezone=UTC";
	private String user = "MySQL";
	private String passworld = "MySQL";

	private Connection conectar(){
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, passworld);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
