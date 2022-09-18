package com.codewithnoel.gocheetaweb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.codewithnoel.gocheetaweb.model.Users;
 

class UsersSvcsTest {

	

	
	@Test
	@DisplayName("Test Search UserLogin")
	@Order(0)
	void testSearchUser() throws ClassNotFoundException, SQLException {
	UsersSvcs userLogin = UsersSvcs.getInstanceUserManage();

			Assertions.assertNotNull(userLogin.searchUser("noel", "password"));
		}
	
	@Test
	@DisplayName("Test Register UserLogin")
	@Order(1)
	void testAddUser() throws ClassNotFoundException, SQLException {
		
		UsersSvcs userLogin = UsersSvcs.getInstanceUserManage();
		Users user = new Users();
		
		user.setUserName("test1");
		user.setUserEmail("u1@g.com");
		user.setUserPassword("password1");
		user.setUserType("Customer");
		 
			
		boolean expected = true;
		boolean actual = userLogin.addUser(user); 
		
		assertEquals(expected, actual ,"this must register a user to the system");
	}
}
