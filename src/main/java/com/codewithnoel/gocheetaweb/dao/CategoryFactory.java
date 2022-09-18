package com.codewithnoel.gocheetaweb.dao;
 

public class CategoryFactory {

public static CategoryManager getCategoryManagerInstance() {
		
		return new CategoryManagerImpl();
	}
	
}
