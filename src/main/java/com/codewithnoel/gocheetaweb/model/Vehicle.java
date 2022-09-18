package com.codewithnoel.gocheetaweb.model;

public class Vehicle {

	private int vehicleId;
	private String vehiclePlateNo;
	private String vehicleLicenseNo;
	private String vehicleDesc;
	private String vehicleCategory;
	private String vehicleBranchId;
	
	
	
	public Vehicle() {
		
	}



	public Vehicle(int vehicleId, String vehiclePlateNo, String vehicleLicenseNo, String vehicleDesc,
			String vehicleCategory, String vehicleBranchId) {
		
		this.vehicleId = vehicleId;
		this.vehiclePlateNo = vehiclePlateNo;
		this.vehicleLicenseNo = vehicleLicenseNo;
		this.vehicleDesc = vehicleDesc;
		this.vehicleCategory = vehicleCategory;
		this.vehicleBranchId = vehicleBranchId;
	}



	public int getVehicleId() {
		return vehicleId;
	}



	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}



	public String getVehiclePlateNo() {
		return vehiclePlateNo;
	}



	public void setVehiclePlateNo(String vehiclePlateNo) {
		this.vehiclePlateNo = vehiclePlateNo;
	}



	public String getVehicleLicenseNo() {
		return vehicleLicenseNo;
	}



	public void setVehicleLicenseNo(String vehicleLicenseNo) {
		this.vehicleLicenseNo = vehicleLicenseNo;
	}



	public String getVehicleDesc() {
		return vehicleDesc;
	}



	public void setVehicleDesc(String vehicleDesc) {
		this.vehicleDesc = vehicleDesc;
	}



	public String getVehicleCategory() {
		return vehicleCategory;
	}



	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}



	public String getVehicleBranchId() {
		return vehicleBranchId;
	}



	public void setVehicleBranchId(String vehicleBranchId) {
		this.vehicleBranchId = vehicleBranchId;
	}
	
	
	
	
	
}
