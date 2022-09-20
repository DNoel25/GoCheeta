package com.codewithnoel.gocheetaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.codewithnoel.gocheetaweb.model.Category;
 

public class CategoryManagerImpl implements CategoryManager {

	/*
	 * 1. Import the package
	 * 2. Load the driver
	 * 3. Establish the connection
	 * 4. Create the statement
	 * 5. Execute the query
	 * 6. Process the result
	 * 7. Close the connection and the statement  
	 */
		
	private Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DBConnector mysql = new MySqlDBConnector();
		return mysql.getConnection();
	}
	
	public boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
		
		Connection connection = getconnection();
		//Statement st = connection.createStatement();
		//String query = "INSERT INTO tblcategory (categoryName) VALUES(" + category.categoryName + ");
		
		//int result = st.executeUpdate(query);
		//st.close();
		
		String query = "INSERT INTO tblcategory (categoryName) VALUES(?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, category.getCategoryName()); 
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();		
		return result > 0;
	}


	
	public Category getCategory(int categoryId) throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		
		String query = "SELECT * FROM tblcategory WHERE categoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(0, categoryId); 
		
		ResultSet rs = ps.executeQuery();
		
		Category category = new Category();
		
		while(rs.next()) {
			category.setCategoryId(rs.getInt("categoryId"));
			category.setCategoryName(rs.getString("categoryName")); 
		}
		
		ps.close();
		connection.close();
		return category;
	}

	public List<Category> getCategories() throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "SELECT * FROM tblcategory";
		
		Statement st = connection.createStatement(); 
		ResultSet rs = st.executeQuery(query);
		
		List<Category> categoryList = new ArrayList();
		
		while(rs.next()) {
			Category category = new Category();
			category.setCategoryId(rs.getInt("categoryId"));
			category.setCategoryName(rs.getString("categoryName")); 
			
			categoryList.add(category);
		}
		
		st.close();
		connection.close();
		
		return categoryList;
	}

	public boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "UPDATE tblcategory SET categoryName WHERE categoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, category.getCategoryName()); 
		ps.setInt(2, category.getCategoryId());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}

	public boolean deleteCategory(int categoryId) throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "DELETE FROM tblcategory WHERE categoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, categoryId);
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
}
