package com.codewithnoel.gocheetaweb.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithnoel.gocheetaweb.dao.BookingManager;
import com.codewithnoel.gocheetaweb.model.Booking;

public class BookingSvcs {

	//private static BookingSvcs service = new BookingSvcs();
	private static BookingSvcs BookingSvcsObj;
	
	public BookingSvcs() { 
		
	}
	
	/*
	 * public static BookingSvcs getInstanceUserManage() { 
	 * return service;
	 * 
	 * }
	 */
	public static synchronized BookingSvcs getInstanceUserManage() {
		
		if(BookingSvcsObj == null) {
			BookingSvcsObj = new BookingSvcs();
		}
		
		return BookingSvcsObj;
	}
	
	//-------services
	public boolean addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		
		//check result and do further processing if you want
		return BookingManager.addBooking(booking); 
	}
	
	public List<Booking> getAllBooking() throws ClassNotFoundException, SQLException{
		return BookingManager.getAllBooking(); 
	}
	
	
	public List<Booking> getCustomerBooking(String userName) throws ClassNotFoundException, SQLException{
		
		return BookingManager.getCustomerBooking(userName);
	}
	
	
}
