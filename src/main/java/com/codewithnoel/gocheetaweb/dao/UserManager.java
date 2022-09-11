package com.codewithnoel.gocheetaweb.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.codewithnoel.gocheetaweb.model.Users;
 

public class UserManager {
	
	/*
	 * 1. Import the package
	 * 2. Load the driver
	 * 3. Establish the connection
	 * 4. Create the statement
	 * 5. Execute the query
	 * 6. Process the result
	 * 7. Close the connection and the statement  
	 */
		
	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DBConnector mysql = new MySqlDBConnector();
		return mysql.getConnection();
	}
	
public static boolean addUser(Users users) throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		//Statement st = connection.createStatement();
		//String query = "INSERT INTO ***** (****, ***) VALUES(" + **** + "," + ****** + ")";
		
		//int result = st.executeUpdate(query);
		//st.close();
		
		String query = "INSERT INTO tblusers (userName, userEmail, userPassword, userType, userNIC, userCNo) VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, users.getUserName());
		ps.setString(2, users.getUserEmail());
		ps.setString(3, users.getUserPassword());
		ps.setString(4, users.getUserType());
		ps.setString(5, users.getUserNIC());
		ps.setString(6, users.getUserCNo());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}
	
	/*
	 * public static Users searchUser(String userName,String userPassword) throws
	 * ClassNotFoundException, SQLException {
	 * 
	 * Connection connection = getconnection();
	 * 
	 * String query="call searchUserManager(?,?)";
	 * 
	 * PreparedStatement ps = connection.prepareStatement(query); ps.setString(1,
	 * userName); ps.setString(2, userPassword);
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * Users users = null;
	 * 
	 * if(rs.next()) {
	 * 
	 * users = new Users(); users.setUserName(rs.getString("userName"));;
	 * users.setUserPassword(rs.getString("userPassword"));
	 * users.setUserType(rs.getString("userType")); }
	 * 
	 * ps.close(); connection.close();
	 * 
	 * return users; }
	 */

	public boolean check(String uname,String pass) throws SQLException, ClassNotFoundException {
		
		Connection connection = getconnection();
		String query = "SELECT * from Users where userName = ?, userPassword = ?";
		 
		PreparedStatement ps = connection.prepareStatement(query);
		 
		 ps.setString(1, uname);
		 ps.setString(2, pass);
		 

		ResultSet rs = ps.executeQuery();
		  
		 if(rs.next()) {
			 return true;
		 }
		 
		 return false;
		 
	}
	
	public List<Users> getUsers() throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "SELECT * FROM tblusers";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<Users> usersList = new ArrayList();
		
		while(rs.next()) {
			Users users = new Users();
			users.setUserId(rs.getInt("userId"));
			users.setUserName(rs.getString("userName"));
			users.setUserEmail(rs.getString("userEmail"));
			users.setUserNIC(rs.getString("userNIC"));
			users.setUserType(rs.getString("userType"));
			users.setUserCNo(rs.getString("userCNo"));
			
			usersList.add(users);
		}
		
		st.close();
		connection.close();
		
		return usersList;
	}
	
}
