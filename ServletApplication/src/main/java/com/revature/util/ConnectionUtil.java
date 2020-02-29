package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() {
		
		String url = "jdbc:postgresql://localhost:5432/ERS_db";
		String user = "postgres";
		String password = "1234";
		// jdbc:postgresql://host:port/database_name
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
