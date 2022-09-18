package com.codewithnoel.gocheetaweb.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithnoel.gocheetaweb.dao.CategoryFactory;
import com.codewithnoel.gocheetaweb.dao.CategoryManager;
import com.codewithnoel.gocheetaweb.model.Category;

public class CategorySvcs {

	private static CategorySvcs CategoryServiceObj;
	
	private CategorySvcs() {
		 
	}

	public static CategorySvcs getCategoryServiceInstance() {
		
		if(CategoryServiceObj == null) {
			CategoryServiceObj = new CategorySvcs();
		}
		
		return CategoryServiceObj;
	
	}

	//-----------------------------services	
			public boolean addCategory(Category category) throws ClassNotFoundException, SQLException {
				
				CategoryManager categoryManager = CategoryFactory.getCategoryManagerInstance();
				
				return categoryManager.addCategory(category);
			}
			
			
			public List<Category> getCategories() throws ClassNotFoundException, SQLException {
				
				CategoryManager categoryManager = CategoryFactory.getCategoryManagerInstance();
				
				return categoryManager.getCategories();
			}
			
			public boolean updateCategory(Category category) throws ClassNotFoundException, SQLException {
				
				CategoryManager categoryManager = CategoryFactory.getCategoryManagerInstance();
				
				return categoryManager.updateCategory(category);
			}
			
			public boolean deleteCategory(int CategoryId) throws ClassNotFoundException, SQLException {
				
				CategoryManager categoryManager = CategoryFactory.getCategoryManagerInstance();
				
				return categoryManager.deleteCategory(CategoryId);
			}
		
//		public Product getCategory(int categoryId) throws ClassNotFoundException, SQLException {
//			
//			CategoryManager categoryManager = CategoryFactory.getCategoryManagerInstance();
//			return categoryManager.getCategory(categoryId);
//		}
		
		
	
}
