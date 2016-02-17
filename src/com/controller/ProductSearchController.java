package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.dao.ProductDAO;
import com.vo.Product;

/**
 * Servlet implementation class ProductSearchController
 */
@WebServlet("/productSearch")
public class ProductSearchController extends GenericServlet  {
	
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("productId"));
		
		ProductDAO productDAO = new ProductDAO();
		
		PrintWriter out = response.getWriter();
		
		try{
		
			Product product = productDAO.getProductById(id);
			
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h2 align='center'>Product Record</h2>");
			out.println("<table border=2 align=center>");
			out.println("<tr><th>ProductId</th><th>ProductName</th><th>ProductPrice</th><th>ProductDescription</th></tr>");
			if(product != null){
				out.println("<tr>");
					out.println("<td>"+product.getId()+"</td>");
					out.println("<td>"+product.getName()+"</td>");
					out.println("<td>"+product.getPrice()+"</td>");
					out.println("<td>"+product.getDescription()+"</td>");
				out.println("</tr>");
			}else{
				out.println("<tr>");
					out.println("<td colspan=4>Product record not found</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			
		}catch(Exception e){
			out.println("Sorry we are unable process your request at this time");
			e.printStackTrace();
		}
		
		
	}

}
