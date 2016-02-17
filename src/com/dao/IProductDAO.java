package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.Product;

public interface IProductDAO {
	
	void addProduct(Product product) throws SQLException;
	Product getProductById(int id) throws SQLException;
	List<Product> getProducts() throws SQLException;
	void updateProduct(Product product) throws SQLException;
	void deleteProduct(int id) throws SQLException;
	

}
