package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
	
	
	public Connection getConnection(){
		
		Connection connection = null;
		
		try{
			
			
			//Step1 : Loading JDBC Drivers
			Class.forName("org.gjt.mm.mysql.Driver");
		
			//Step2 : Establish the connection with Database server
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return connection;
	}

}
