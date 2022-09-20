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
 
import com.codewithnoel.gocheetaweb.model.Vehicle; 
import com.codewithnoel.gocheetaweb.service.VehicleSvcs;


public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VehicleSvcs service;
	private String message;
	private String deleteMessage;
	
    public VehicleController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var vehiclId = request.getParameter("vehiclId");
    	if(vehiclId == null) {    		
    		launchAllVehicles(request, response);
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var type= request.getParameter("type");
		if(type != null) {
			if(type.equals("update")) {
				updateCategory(request, response);
			} else if(type.equals("delete")) {
				deleteVehicle(request, response);
			} else {
				insertVehicle(request, response);
			}
		}
	}
	
private void launchAllVehicles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	List<Vehicle> vehicleList;
    	clearMessage();
    	
		try {
			vehicleList = service.getVehicles();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			vehicleList = new ArrayList<Vehicle>();
		}
		request.setAttribute("vehicleList", vehicleList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin_vehicle.jsp");		
		rd.forward(request, response);
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		String vehicleLicenseNo = request.getParameter("vehicleLicenseNo"); 
		String vehicleDesc = request.getParameter("vehicleDesc"); 
		String vehicleCategory = request.getParameter("VehicleCategory");   
		String vehicleBranchId = request.getParameter("vehicleBranchId");  
		String vehiclePlateNo = request.getParameter("vehiclePlateNo");  
		
		Vehicle vehicle = new Vehicle(vehicleId, vehiclePlateNo,vehicleLicenseNo, vehicleDesc ,vehicleCategory,vehicleBranchId );
		clearMessage(); 
		
		try {
			
			boolean result = service.updateVehicle(vehicle);
			if(result) {
				message = "Category has been successfully updated! Category Code: " + vehicleId;
			}
			else {
				message = "Failed to update the Category! Category Code: " + vehicleId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		
		request.setAttribute("vehicle", vehicle);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin_manage_vehicle.jsp");
		rd.forward(request, response);
	}
	
	private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		clearMessage();
		try {
			boolean result = service.deletevehicle(vehicleId);
			if(result) {
				deleteMessage = "The category: " + vehicleId + " has been successfully deleted!";
			} else {
				deleteMessage = "Failed to delete the category! category Code: " + vehicleId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			deleteMessage = e.getMessage();
		}
		request.setAttribute("deleteMessage", deleteMessage);
		launchAllVehicles(request, response);
	}
	
	private void insertVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clearMessage(); 
		String vehicleLicenseNo = request.getParameter("vehicleLicenseNo"); 
		String vehicleDesc = request.getParameter("vehicleDesc"); 
		String vehicleCategory = request.getParameter("VehicleCategory");   
		String vehicleBranchId = request.getParameter("vehicleBranchId");  
		String vehiclePlateNo = request.getParameter("vehiclePlateNo"); 
		 
		
		Vehicle vehicle= new Vehicle();
		 	
		try {
			boolean result = service.addVehicle(vehicle);
			if(result) {
				message = "vehicle has been successfully added! vehicle Name: " + vehicleLicenseNo;
			}else {
				message = "Failed to add vehicle! vehicle Name: " + vehicleLicenseNo;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin_add_vehicle.jsp");
		rd.forward(request, response);
	}
	
	private void clearMessage() {
		message = "";
		deleteMessage = "";
	}

}
