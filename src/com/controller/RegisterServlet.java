package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vo.User;

@WebServlet(value="/registerProcess",initParams={@WebInitParam(name="driver",value="org.gjt.mm.mysql.Driver"),@WebInitParam(name="url",value="jdbc:mysql://localhost:3306/test")})
public class RegisterServlet extends GenericServlet {

	Connection connection = null;	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		
      try{		
    	
    	String driverClass = config.getInitParameter("driver");
    	
    	ServletContext context = config.getServletContext();
    	  
    	String username = context.getInitParameter("username");
    	String password = context.getInitParameter("password");
    	
		Class.forName(driverClass);
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
      }catch(Exception e){
    	  e.printStackTrace();
      }

	}
       
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext servletContext = request.getServletContext();
		
		System.out.println("************RegisterServlet : service()***********");
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmail(request.getParameter("email"));
		user.setGender(request.getParameter("gender"));
		user.setCity(request.getParameter("city"));
				
		PrintWriter out = response.getWriter();
		
		try{
			
			
			String insertQuery = "insert into test.registereduser(username,password,first_name,last_name,email,gender,city) "
					+ "values(?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setString(3,user.getFirstname());
			preparedStatement.setString(4,user.getLastname());
			preparedStatement.setString(5,user.getEmail());
			preparedStatement.setString(6,user.getGender());
			preparedStatement.setString(7,user.getCity());
			
			int i = preparedStatement.executeUpdate();
			
			if(i == 1){
				System.out.println("record is added successfully");
			}
			
		}catch(Exception e){
			out.println("Registration failed");
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		out.println("U R successfully registered ");
		
		
		
	}
	
	@Override
	public void destroy() {
		
		try{
			
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

}
