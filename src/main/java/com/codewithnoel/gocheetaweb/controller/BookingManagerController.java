package com.codewithnoel.gocheetaweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.codewithnoel.gocheetaweb.model.Booking;
import com.codewithnoel.gocheetaweb.service.BookingSvcs;
 
 
public class BookingManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
	private BookingSvcs service;   
     
    public BookingManagerController() {
    	
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		var userName = request.getParameter("userName");
		if(userName != null) {
			launchSpecificProductInformation(request, response);
		}
		displayAllBooking(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 
		
	}
	
	private void displayAllBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Booking> bookingList;
    	clearMessage();
    	
		try {
			bookingList = service.getAllBooking();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			bookingList = new ArrayList<Booking>();
		}
		request.setAttribute("bookingList", bookingList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("AllBooking.jsp"); 	
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void launchSpecificProductInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		List<Booking> bookingList;
    	clearMessage();
    	
		try {
			bookingList = service.getCustomerBooking("customerName");
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			bookingList = new ArrayList<Booking>();
		}
		request.setAttribute("bookingList", bookingList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("AllBooking.jsp"); 	
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	private void clearMessage() {
		message = ""; 
	}
	
	
}
