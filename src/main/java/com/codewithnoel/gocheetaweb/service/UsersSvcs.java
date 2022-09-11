package com.codewithnoel.gocheetaweb.service;

import java.sql.SQLException;
import java.util.List;
 
import com.codewithnoel.gocheetaweb.dao.UserManager;
import com.codewithnoel.gocheetaweb.model.Users;

public class UsersSvcs {

	private static UsersSvcs service = new UsersSvcs(); 
	
	public UsersSvcs() {
		
	}	
	
	public static UsersSvcs getInstanceUserManage() {
		return service;
	}
	
	/*
	 * public static synchronized UsersSvcs getProductServiceInstance() {
	 * 
	 * if(UsersSvcsObj == null) { UsersSvcsObj = new UsersSvcs(); }
	 * 
	 * return UsersSvcsObj; }
	 */
	
	
		
		public List<Users> getUsers() throws ClassNotFoundException, SQLException {
			UserManager uManager = new UserManager(); 
			
			return uManager.getUsers();
		}
		
		public boolean addUser(Users users) throws ClassNotFoundException, SQLException {		
			//check result and do further processing if you want
			return UserManager.addUser(users);
		}

		  public boolean check(String username,String password) throws ClassNotFoundException, SQLException {
			  UserManager uManager = new UserManager(); 
			  return uManager.check(username, password);
		  }
}
