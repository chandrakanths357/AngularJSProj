package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vo.User;

@WebServlet(value="/loginProcess",initParams={@WebInitParam(name="driver",value="org.gjt.mm.mysql.Driver"),@WebInitParam(name="url",value="jdbc:mysql://localhost:3306/test")})
public class LoginServlet extends GenericServlet implements Servlet {
	
	
	Connection connection = null;	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		
      try{		
    	
    	String driverClass = config.getInitParameter("driver");
    	
    	ServletContext context = config.getServletContext();
    	  
    	String username = context.getInitParameter("username");
    	String password = context.getInitParameter("password");
    	
		Class.forName(driverClass);
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",username,password);
      }catch(Exception e){
    	  e.printStackTrace();
      }

	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("*************LoginServlet : service()**********");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String query = "select * from test.registereduser where username = ?";
		
		try{
		
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,username);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				String dbPassword = resultSet.getString("password");
				
				if(password.equals(dbPassword)){
					
					User user = new User();
					user.setFirstname(resultSet.getString("first_name"));
					user.setLastname(resultSet.getString("last_name"));
					user.setCity(resultSet.getString("city"));
					user.setEmail(resultSet.getString("email"));
					user.setGender(resultSet.getString("gender"));
					
					//request.setAttribute("userdata",user);
//					
//					ServletContext servletContext = request.getServletContext();
//					
//					servletContext.setAttribute("userdata", user);
//					
//					RequestDispatcher requestDispatcher = request.getRequestDispatcher("accountServ");
//					
//					requestDispatcher.forward(request, response);
//					
				}else{
					System.err.println("Invalid password");
				}
			}else{
				System.err.println("Invalid username");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
				
				
	}

}
