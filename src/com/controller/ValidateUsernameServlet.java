package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateUsernameServlet
 */
@WebServlet("/validateUsername")
public class ValidateUsernameServlet extends HttpServlet {

	private List<String> usernamesList = new ArrayList<String>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		usernamesList.add("hary");
		usernamesList.add("kumar");
		usernamesList.add("raj");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("******ValidateUsername : doGet()******");
		
		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		
		if(usernamesList.contains(username)){
			
			out.println("<font color=red>Username is taken</font>");
		}else{
			out.println("<font color=green>Username is available</font>");
		}
		
	}

}
