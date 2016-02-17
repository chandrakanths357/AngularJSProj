package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.vo.User;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/accountServ")
public class AccountServlet extends GenericServlet implements Servlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("*************AccountServlet : service()**********");
		
		User user = (User)request.getAttribute("userdata");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		
		out.println("<h2 align=center>Home Page</h2>");
		out.println("<h4>User Details</h4>");
		
		out.println("FirstName : "+user.getFirstname());
		out.println("<br>");
		out.println("LastName : "+user.getLastname());
		out.println("<br>");
		out.println("City     : "+user.getCity());
		out.println("<br>");
		out.println("Email    : "+user.getEmail());
		
		out.println("</body></html>");
		
		
	}

}
