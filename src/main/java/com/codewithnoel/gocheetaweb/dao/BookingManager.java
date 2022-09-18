package com.codewithnoel.gocheetaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.codewithnoel.gocheetaweb.model.Booking; 
 

public class BookingManager {
	
	private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DBConnector mysql = new MySqlDBConnector();
		return mysql.getConnection();
	}
	
	public static boolean addBooking(Booking record) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
	
		String query ="insert into tblbooking(bookingId,vehicleCategory,streetAddress,city,"
				+ "bookingCost,bookingStatus,driverName,driverCNo,customerName,customerCNo) values (?,?,?,?,?,?,?,?,?,?)";   //using stored procedure 
			
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, record.getBookingId());
		ps.setString(2, record.getVehicleCategory());
		ps.setString(3, record.getStreetAddress());
		ps.setDouble(4, record.getCost());;
		ps.setString(5, record.getBookingStatus());
		ps.setString(6, record.getDriverName());
		ps.setString(7, record.getDriverCNo());
		ps.setString(8, record.getCustomerName());
		ps.setString(9, record.getCustomerCNo());
		ps.setString(10, record.getDriverName());
		

		boolean result = ps.executeUpdate() >0;  //executeUpdate used because inserting (insert,delete,update)
												 //execute and process info
		ps.close();		
		connection.close(); //connection close
		
		return result;
	}
	
	public static List<Booking> getAllBooking() throws ClassNotFoundException, SQLException{
		
		Connection connection = getconnection();
		
		String query="select * from tblbooking";//using stored procedure 
		
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Booking> records = new ArrayList();
		while(rs.next()) {
			Booking record = new Booking();
			
			record.setBookingId(Integer.parseInt(rs.getString("bookingId")));
			record.setVehicleCategory(rs.getString("vehicleCategory"));
			record.setVehicleCategory(rs.getString("streetAddress"));
			record.setVehicleCategory(rs.getString("city"));
			record.setCost(Double.parseDouble(rs.getString("bookingCost")));
			record.setBookingStatus(rs.getString("bookingStatus"));
			record.setDriverName(rs.getString("driverName"));
			record.setDriverCNo(rs.getString("driverCNo"));
			record.setCustomerName(rs.getString("customerName"));
			record.setCustomerCNo(rs.getString("customerCNo"));
			
			records.add(record);
		}
		
		st.close();
		connection.close();
		
		return records;
	}
	
	public static List<Booking> getCustomerBooking(String customerName) throws ClassNotFoundException, SQLException{
		
		Connection connection = getconnection();
		

		String query = "SELECT * FROM tblbooking WHERE customerName = ?";//using stored procedure 
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customerName);
		
		
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		List<Booking> records = new ArrayList();
		while(rs.next()) {
			Booking record = new Booking();
			
			record.setBookingId(Integer.parseInt(rs.getString("bookingId")));
			record.setVehicleCategory(rs.getString("vehicleCategory"));
			record.setVehicleCategory(rs.getString("streetAddress"));
			record.setVehicleCategory(rs.getString("city"));
			record.setCost(Double.parseDouble(rs.getString("cost")));
			record.setBookingStatus(rs.getString("bookingStatus"));
			record.setDriverName(rs.getString("driverName"));
			record.setDriverCNo(rs.getString("driverCNo"));
			record.setCustomerName(rs.getString("customerName"));
			record.setCustomerCNo(rs.getString("customerCNo"));
			 
			
			records.add(record);
		}
		
		st.close();
		connection.close();
		
		return records;
	}
	
	 
	
}
