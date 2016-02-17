package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDAO;
import com.vo.Product;

@WebServlet("/allProducts")
public class AllProductsServlet extends HttpServlet {

	private ProductDAO productDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 try{	
		
		 List<Product> productsList = productDAO.getProducts();
		 
		 request.setAttribute("products", productsList);
		 
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("productRecords.jsp");
		 
		 requestDispatcher.forward(request, response);
		 
		 
		 
//		 PrintWriter out = response.getWriter();
		 	
		 //Presentation logic
//		 out.println("<html><body>");
//		 out.println("<h2 align='center'>Product Record</h2>");
//		 out.println("<table border=2 align=center>");
//		 out.println("<tr><th>ProductId</th><th>ProductName</th><th>ProductPrice</th><th>ProductDescription</th></tr>");
//
//		 for (Product product : productsList) {
//			
//			 out.println("<tr>");
//			 	out.println("<td>"+product.getId()+"</td>");
//			 	out.println("<td>"+product.getName()+"</td>");
//			 	out.println("<td>"+product.getPrice()+"</td>");
//			 	out.println("<td>"+product.getDescription()+"</td>");
//			 	out.println("<td><a href='deleteProduct?product_id="+product.getId()+"'>delete</a></td>");
//			 	out.println("<td><a href=''>update</a></td>");
//			 out.println("</tr>");
//		 }	
//		 
//		 out.println("</body></html>");
		 
//		 out.close();
		 
		 
		 
	 }catch(Exception e){
		 e.printStackTrace();
	 }
		
		
		
	}

}
