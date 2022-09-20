package com.codewithnoel.gocheetaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithnoel.gocheetaweb.model.Vehicle;

public class VehicleManager {

private static Connection getconnection() throws ClassNotFoundException, SQLException {
		
		DBConnector mysql = new MySqlDBConnector();
		return mysql.getConnection();
	}
	
	public static boolean addVehicle(Vehicle record) throws ClassNotFoundException, SQLException {
		Connection connection = getconnection();
		
	
		String query ="insert into tblvehicle(vehicleId,vehiclePlateNo,vehicleLicenseNo,vehicleDesc,vehicleCategory,vehicleBranchId) values (?,?,?,?,?,?)";   //using stored procedure 
			
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, record.getVehicleId());
		ps.setString(2, record.getVehiclePlateNo());
		ps.setString(3, record.getVehicleLicenseNo());
		ps.setString(4, record.getVehicleDesc());
		ps.setString(5, record.getVehicleCategory());
		ps.setString(6, record.getVehicleBranchId()); 
		

		boolean result = ps.executeUpdate() >0;  //executeUpdate used because inserting (insert,delete,update)
												 //execute and process info
		ps.close();		
		connection.close(); //connection close
		
		return result;
	}
	
	public static List<Vehicle> getAllVehicle() throws ClassNotFoundException, SQLException{
		
		Connection connection = getconnection();
		
		String query="select * from tblvehicle";//using stored procedure 
		
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Vehicle> records = new ArrayList();
		while(rs.next()) {
			Vehicle record = new Vehicle(); 
			record.setVehicleId(Integer.parseInt(rs.getString("vehicleId")));
			record.setVehiclePlateNo(rs.getString("vehiclePlateNo"));
			record.setVehicleLicenseNo(rs.getString("vehicleLicenseNo"));
			record.setVehicleDesc(rs.getString("vehicleDesc"));
			record.setVehicleCategory(rs.getString("vehicleCategory"));
			record.setVehicleBranchId(rs.getString("vehicleBranchId")); 
			
			records.add(record);
		}
		
		st.close();
		connection.close();
		
		return records;
	}
	
	public static Vehicle getVehicle(int vehicleId) throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		
		String query = "SELECT * FROM tblvehicle WHERE vehicleId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, vehicleId);
		
		ResultSet rs = ps.executeQuery();
		
		Vehicle vehicle = new Vehicle();
		
		while(rs.next()) {
			
			vehicle.setVehicleId(Integer.parseInt(rs.getString("vehicleId")));
			vehicle.setVehiclePlateNo(rs.getString("vehiclePlateNo"));
			vehicle.setVehicleLicenseNo(rs.getString("vehicleLicenseNo"));
			vehicle.setVehicleDesc(rs.getString("vehicleDesc"));
			vehicle.setVehicleCategory(rs.getString("vehicleCategory"));
			vehicle.setVehicleBranchId(rs.getString("vehicleBranchId")); 
		}
		
		ps.close();
		connection.close();
		return vehicle;
	}
	
	public static boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "UPDATE tblvehicle SET vehiclePlateNo = ?, vehicleLicenseNo = ?, vehicleDesc = ?, vehicleCategory = ?, vehicleBranchId WHERE categoryId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, vehicle.getVehiclePlateNo());
		ps.setString(2, vehicle.getVehicleLicenseNo());
		ps.setString(3, vehicle.getVehicleDesc());
		ps.setString(4, vehicle.getVehicleCategory());
		ps.setString(5, vehicle.getVehicleBranchId());
		
		int result = ps.executeUpdate();
		
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
	public static boolean deleteVehicle(int vehicleId) throws ClassNotFoundException, SQLException {

		Connection connection = getconnection();
		String query = "DELETE FROM tblvehicle WHERE vehicleId = ?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, vehicleId);
		
		int result = ps.executeUpdate();
		ps.close();
		connection.close();
		
		return result > 0;
	}
	
}
