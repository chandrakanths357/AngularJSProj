package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sampleServ")
public class SampleServlet extends HttpServlet {

	
	                   // http request              // http response
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("****SampleServlet : doPost()****");
		
		response.sendRedirect("register.html");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
//		
//		dispatcher.forward(request, response);
		
		
		
//		Enumeration<String> headers = request.getHeaderNames();
//		
//		PrintWriter out = response.getWriter();
//		
//		response.setContentType("application/msword");
//		
//		while (headers.hasMoreElements()) {
//		
//			String headerName = headers.nextElement();
//			out.println(headerName+" : "+request.getHeader(headerName));
//			out.println("<br>");
//		}
	}

}
