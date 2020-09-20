package com.tcs.springjpademo.service;

import java.util.List;

import com.tcs.springjpademo.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductById(Integer id);
	
	public void createProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Integer id);
	
}