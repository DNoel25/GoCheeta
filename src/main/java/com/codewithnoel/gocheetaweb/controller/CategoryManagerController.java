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
import javax.servlet.http.HttpSession;
 
import com.codewithnoel.gocheetaweb.model.Category;
import com.codewithnoel.gocheetaweb.service.CategorySvcs;


public class CategoryManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private CategorySvcs service;
	private String message;
	private String deleteMessage;
    
    public CategoryManagerController() {
    	service = CategorySvcs.getCategoryServiceInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var categoryId = request.getParameter("categoryId");
		if(categoryId != null) {    		

			launchSpecificCategoryInformation(request, response);
    	}
    	else {  

    		launchAllCategories(request, response);
    	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var type= request.getParameter("type");
		if(type != null) {
			if(type.equals("update")) {
				updateCategory(request, response);
			} else if(type.equals("delete")) {
				deleteCategory(request, response);
			} else {
				insertCategory(request, response);
			}
		}
		
	}

	private void launchSpecificCategoryInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Category category;
		clearMessage();
		
		try { 
			category = service.getCategory(Integer.parseInt(request.getParameter("categoryId")));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			category = new Category();
		}
		
		HttpSession session = request.getSession();		
		session.setAttribute("message", message);
		session.setAttribute("category", category);
		System.out.println(category.getCategoryName());
		response.sendRedirect("admin_manage_category.jsp");
	}

		
	private void launchAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	List<Category> categoryList;
    	clearMessage();
    	
		try {
			categoryList = service.getCategories();
		} catch (ClassNotFoundException | SQLException e) {
			
			message = e.getMessage();
			categoryList = new ArrayList<Category>();
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin/admin_category.jsp");		
		rd.forward(request, response);
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName"); 
		
		Category category = new Category(categoryId, categoryName);
		clearMessage();
		
		try {
			
			boolean result = service.updateCategory(category);
			if(result) {
				message = "Category has been successfully updated! Category Code: " + categoryId;
			}
			else {
				message = "Failed to update the Category! Category Code: " + categoryId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("category", category);
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin/admin_manage_category.jsp");
		rd.forward(request, response);
	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		clearMessage();
		try {
			boolean result = service.deleteCategory(categoryId);
			if(result) {
				deleteMessage = "The category: " + categoryId + " has been successfully deleted!";
			} else {
				deleteMessage = "Failed to delete the category! category Code: " + categoryId;
			}
		} catch (ClassNotFoundException | SQLException e) {
			deleteMessage = e.getMessage();
		}
		request.setAttribute("deleteMessage", deleteMessage);
		launchAllCategories(request, response);
	}
	
	private void insertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		clearMessage();
		String categoryName = request.getParameter("categoryName"); 
		
		Category category = new Category(categoryName);
		 	
		try {
			boolean result = service.addCategory(category);
			if(result) {
				message = "category has been successfully added! Category Name: " + categoryName;
			}else {
				message = "Failed to add category! category Name: " + categoryName;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("admin/admin_add_category.jsp");
		rd.forward(request, response);
	}
	
	private void clearMessage() {
		message = "";
		deleteMessage = "";
	}
	
}
