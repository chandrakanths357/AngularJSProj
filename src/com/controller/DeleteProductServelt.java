package com.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;

@WebServlet("/deleteProduct")
public class DeleteProductServelt extends HttpServlet {

	private ProductDAO productDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("product_id"));
		
		productDAO.deleteProduct(id);
		
		response.sendRedirect("allProducts");
		
	}

}
