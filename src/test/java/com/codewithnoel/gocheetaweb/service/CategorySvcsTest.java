package com.codewithnoel.gocheetaweb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
 
import com.codewithnoel.gocheetaweb.model.Category;
  

class CategorySvcsTest {

	CategorySvcs service;
	Category category;
	
	@BeforeEach
	void beforeEach() {
		service = CategorySvcs.getCategoryServiceInstance();
		category = new Category();
	}
	
	@Test
	@DisplayName("Test Add category")
	@Order(1)
	void testAddCategory() throws ClassNotFoundException, SQLException {
//		CategorySvcs addCategory = CategorySvcs.getCategoryServiceInstance();
//		Category category = new Category();
		
		category.setCategoryName("Luxury111");  
		 
			
		boolean expected = true;
		boolean actual = service.addCategory(category); 
		
		assertEquals(expected, actual ,"this must add category to the system");
	}

	@Test
	@DisplayName("Test Update category")
	@Order(2)
	void testUpdateCategory() {
//		CategorySvcs service = CategorySvcs.getCategoryServiceInstance();
//		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("Luxury1111"); 
		
		Boolean actual = null;
		
		Boolean expexted = true;
		try {
			actual = service.updateCategory(category); 
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
		
		if(expexted != actual) {
			System.out.println("Category Update method is not working");
			
		}
		else {
			System.out.println("Category Update method is  working");
		}
	}

	@Test
	@DisplayName("Test Delete category")
	@Order(3)
	void testDeleteCategory() {
//		CategorySvcs service = CategorySvcs.getCategoryServiceInstance();
//		Category category = new Category();
		category.setCategoryId(3);;
		
		
		Boolean actual = null;
		
		Boolean expexted = true;
		try {
			actual=service.deleteCategory(4);
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
		
		if(expexted != actual) {
			System.out.println("Product delete method is not working");
			
		}
		else {
			System.out.println("Product delete method is  working");
		}
	}
	
	

}
