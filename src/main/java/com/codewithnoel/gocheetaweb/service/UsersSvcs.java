package com.codewithnoel.gocheetaweb.service;

import java.sql.SQLException;
import java.util.List;
 
import com.codewithnoel.gocheetaweb.dao.UserManager;
import com.codewithnoel.gocheetaweb.model.Users; 

public class UsersSvcs {

	//private static UsersSvcs service = new UsersSvcs(); 
	private static UsersSvcs usersSvcsObj;
	public UsersSvcs() {
		
	}	
	
	/*
	 * public static UsersSvcs getInstanceUserManage() { return service; }
	 */
	
	public static synchronized UsersSvcs getInstanceUserManage() {
		
		if(usersSvcsObj == null) {
			usersSvcsObj = new UsersSvcs();
		}
		
		return usersSvcsObj;
	}	
	
	/*
	 * public static synchronized UsersSvcs getProductServiceInstance() {
	 * 
	 * if(UsersSvcsObj == null) { UsersSvcsObj = new UsersSvcs(); }
	 * 
	 * return UsersSvcsObj; }
	 */
	
	
	//----------services
		public List<Users> getUsers() throws ClassNotFoundException, SQLException {
			UserManager uManager = new UserManager(); 
			
			return uManager.getUsers();
		}
		
		public List<Users> getDrivers() throws ClassNotFoundException, SQLException {
			UserManager uManager = new UserManager(); 
			
			return uManager.getDrivers();
		}
		
		public boolean addUser(Users users) throws ClassNotFoundException, SQLException {		
			//check result and do further processing if you want
			return UserManager.addUser(users);
		}

//		  public Users check(String userName,String userPassword) throws ClassNotFoundException, SQLException {
//			  UserManager uManager = new UserManager(); 
//			  return uManager.check(userName, userPassword);
//		  }
		public Users searchUser(String userName,String userPassword) throws ClassNotFoundException, SQLException {
			
			return UserManager.searchUser(userName, userPassword);
		  }
		
		 
}
