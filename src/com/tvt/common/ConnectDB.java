package com.tvt.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection con;
	private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private ConnectDB() {}
	
	public static Connection getConnect() {
		try {
			Class.forName(SQLSERVER_DRIVER);
			System.out.println("Saving driver...");
			String urlSQLSERVER = String.format("jdbc:sqlserver://DESKTOP-SLU3ABU\\SQLEXPRESS:1433;"
					+ "databaseName=gym;user=sa;password=123;");
			con = DriverManager.getConnection(urlSQLSERVER);
			System.out.println("Connect database is successful!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
