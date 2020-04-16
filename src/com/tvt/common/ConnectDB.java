package com.tvt.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=gym";
	private static String userName = "sa";
	private static String password = "123";
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static Connection connection;

	public static Connection getConnect() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		return connection;
	}
}
