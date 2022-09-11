package com.codewithnoel.gocheetaweb.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithnoel.gocheetaweb.model.Users;
import com.codewithnoel.gocheetaweb.service.UsersSvcs;

public class UserManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserManagerController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("useradd")) {
			addUser(request, response);
		}
		if (action.equals("userlog")) {
			loginUser(request, response);
		}

	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) {

		UsersSvcs service = new UsersSvcs();

		Users user = new Users();

		user.setUserName(request.getParameter("userName"));
		user.setUserEmail(request.getParameter("userEmail"));
		;
		user.setUserPassword(request.getParameter("userPassword"));
		user.setUserType(request.getParameter("userType"));
		user.setUserNIC(request.getParameter("userNIC"));
		user.setUserCNo(request.getParameter("userCNo"));

		String message = "";

		try {
			if (user.getUserEmail().isEmpty() || user.getUserEmail().isEmpty() || user.getUserPassword().isEmpty()
					|| user.getUserType().isEmpty() || user.getUserNIC().isEmpty() || user.getUserCNo().isEmpty()) {

				message = "Enter Required Fields";
			}

			else {

				boolean result = service.addUser(user);
				if (result) {
					message = "User = " + user.getUserName() + "; Added Succesfully";
				} else {
					message = "User = " + user.getUserName() + "; Adding Failed";
				}
			}

		} catch (ClassNotFoundException | SQLException e) {

			message = e.getMessage();
		}

		RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
		request.setAttribute("useraddMessage", message);

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException ex) {

			message = ex.getMessage();
		}
	}

	private void loginUser(HttpServletRequest request,HttpServletResponse response) {
	
		UsersSvcs service = UsersSvcs.getInstanceUserManage();
		Users user = new Users();
	
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
	
		String message ="";
		
		try {
			if(service.check(userName, userPassword))
			{
				
				HttpSession session=request.getSession();
				session.setAttribute("username",userName);
				response.sendRedirect("welcome.jsp");
				
			}else {
				
				response.sendRedirect("login.jsp");
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { user = service.searchUser(username, password); HttpSession session =
		 * request.getSession();
		 */
		
		/*if(user != null) { 
			
			session.setAttribute("sessionusername", username);
			session.setAttribute("type", user.getUserType());
			
			 session.setMaxInactiveInterval(30*60);
			  
			 Cookie userName = new Cookie("sessionusername", username);
			 userName.setMaxAge(30*60); response.addCookie(userName);
			 
			 Cookie type = new Cookie("sessiontype", user.getUserType());
			 type.setMaxAge(30*60); response.addCookie(type);
			
			try 
			{
				response.sendRedirect("index.jsp");
			} 
			catch (IOException e) 
			{
				message = e.getMessage();
			}
			
			
			 * try { response.sendRedirect("index.jsp?sessionuname="+uname+"");
			 * //response.sendRedirect("doctorAddRecord.jsp?sessionuname="+uname+""); }
			 * catch (IOException ex) {
			 * 
			 * message = ex.getMessage(); }
			 
		}
		else 
		{
			try 
			{
				response.sendRedirect("Login.jsp");
				message = "No User Found!";	
			} catch (IOException es) {
				
				message = es.getMessage();
			}	*/
		/*}
		
		session.setAttribute("loginMessage", message);
		
	}catch(ClassNotFoundException|

	SQLException e)
	{

		message = e.getMessage();
	}*/

}}
