package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vo.Product;

public class ProductDAO extends BaseDAO implements IProductDAO{

	@Override
	public void addProduct(Product product) throws SQLException {
		
		Connection connection = null;		
		
		try{
			
			connection = getConnection();		

			String insertQuery = "insert into test.product(product_id,product_name,product_price,product_description) "
					+ "values(?,?,?,?)";
			                //1,2,3,4
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1,product.getId());
			preparedStatement.setString(2,product.getName());
			preparedStatement.setFloat(3,product.getPrice());
			preparedStatement.setString(4,product.getDescription());
			
			//step5 : Execute the query using statement object
			int i = preparedStatement.executeUpdate();
			
			if(i == 1){
				System.out.println("Record added successfully...");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			connection.close();
		}	

	}

	@Override
	public Product getProductById(int id) throws SQLException {	
		
		String selectQuery = "select * from test.product where product_id=?";
		
		Connection connection = null;
		
		Product product = null; 
		 
		try{
			
			connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			
			preparedStatement.setInt(1,id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				product = new Product();
				
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("product_price"));
				product.setDescription(resultSet.getString("product_description"));
				
				
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			connection.close();
		}
		
		return product;

	}

	@Override
	public List<Product> getProducts() throws SQLException {
		String selectQuery = "select * from test.product";
		
		ArrayList<Product> productsList = new ArrayList<Product>();
		
		Connection connection = null;
		try{
			
			connection = getConnection(); 
			
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()){
				
				Product product = new Product();
				
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("product_price"));
				product.setDescription(resultSet.getString("product_description"));
				
				productsList.add(product);
				
			}
		
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		
		return productsList;

	}

	@Override
	public void updateProduct(Product product) {
		
	}

	@Override
	public void deleteProduct(int id) {

		String deleteQuery = "delete from test.product where product_id=?";
		
		Connection connection = getConnection();
		try{
		
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			
			preparedStatement.setInt(1,id);
			
			int i = preparedStatement.executeUpdate();
			
			if(i == 1){
				System.out.println("Record is deleted successfully");
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
