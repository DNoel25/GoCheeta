package com.codewithnoel.gocheetaweb.model;

public class Booking {

	private int bookingId;
	private String vehicleCategory;
	private String streetAddress;
	private String city;
	private double cost;
	private String bookingStatus;
	private String driverName;
	private String driverCNo;
	private String customerName;
	private String customerCNo;
	
	
	public Booking() {
		
	}

	

	public Booking(int bookingId, String vehicleCategory, String streetAddress, String city, double cost,
			String bookingStatus, String driverName, String driverCNo, String customerName, String customerCNo) {
		super();
		this.bookingId = bookingId;
		this.vehicleCategory = vehicleCategory;
		this.streetAddress = streetAddress;
		this.city = city;
		this.cost = cost;
		this.bookingStatus = bookingStatus;
		this.driverName = driverName;
		this.driverCNo = driverCNo;
		this.customerName = customerName;
		this.customerCNo = customerCNo;
	}



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}



	public String getDriverCNo() {
		return driverCNo;
	}



	public void setDriverCNo(String driverCNo) {
		this.driverCNo = driverCNo;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerCNo() {
		return customerCNo;
	}



	public void setCustomerCNo(String customerCNo) {
		this.customerCNo = customerCNo;
	}
	
	
	
	
	
	
	
}
