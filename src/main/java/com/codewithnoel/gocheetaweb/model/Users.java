package com.codewithnoel.gocheetaweb.model;

public class Users {

	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userType;
	private String userNIC;
	private String userCNo;
	
	public Users() {
		
	}
	
	

	public Users(int userId, String userName, String userEmail, String userPassword, String userType, String userNIC,
			String userCNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userNIC = userNIC;
		this.userCNo = userCNo;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserNIC() {
		return userNIC;
	}

	public void setUserNIC(String userNIC) {
		this.userNIC = userNIC;
	}

	public String getUserCNo() {
		return userCNo;
	}

	public void setUserCNo(String userCNo) {
		this.userCNo = userCNo;
	}
	
	
	
}
