package com.codewithnoel.gocheetaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnector implements DBConnector {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/gocheetadb";
		String user = "root";
		String passsword = "Welcome@123";
		Connection connection  = DriverManager.getConnection(url, user, passsword);
		return connection;
		 
	}

	
	
	
}
