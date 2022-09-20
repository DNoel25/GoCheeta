package com.codewithnoel.gocheetaweb.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithnoel.gocheetaweb.model.Category;
 

public interface CategoryManager {

	public boolean addCategory(Category category) throws ClassNotFoundException, SQLException;
	public Category getCategory(int categoryId) throws ClassNotFoundException, SQLException;
	public List<Category> getCategories() throws ClassNotFoundException, SQLException;
	public boolean updateCategory(Category category) throws ClassNotFoundException, SQLException;
	public boolean deleteCategory(int CategoryId) throws ClassNotFoundException, SQLException;
	
}
