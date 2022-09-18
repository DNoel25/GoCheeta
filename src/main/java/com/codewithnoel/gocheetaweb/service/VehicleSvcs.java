package com.codewithnoel.gocheetaweb.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithnoel.gocheetaweb.dao.VehicleManager;
import com.codewithnoel.gocheetaweb.model.Vehicle;

public class VehicleSvcs {

	private static VehicleSvcs VehicleServiceObj;
	
	private VehicleSvcs() {
		
	}
	
	public static synchronized VehicleSvcs getVehicleServiceInstance() {
		
		if(VehicleServiceObj == null) {
			VehicleServiceObj = new VehicleSvcs();
		}
		
		return VehicleServiceObj;
	
	}
	
	//-----------------------------services	
	public boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
		 
		
		return VehicleManager.addVehicle(vehicle);
	}
	
	
	public List<Vehicle> getVehicles() throws ClassNotFoundException, SQLException { 
		
		return VehicleManager.getAllVehicle();
	}
	
//	public boolean updateVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
//		
//		return VehicleManager;
//	}
//	
//	public boolean deleteCategory(int vehicleId) throws ClassNotFoundException, SQLException {
//		 
//		
//		return VehicleManager;
//	} 
//public Product getCategory(int categoryId) throws ClassNotFoundException, SQLException {
//	
//	CategoryManager categoryManager = CategoryFactory.getCategoryManagerInstance();
//	return categoryManager.getCategory(categoryId);
//}
	
	
	
}

