package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	private static final String url="jdbc:mysql://localhost:3306/hotelreservationjdbc";
	private static final String username="root";
	private static final String password="root";

	
	public static Connection createConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return connection;
	}
	
}