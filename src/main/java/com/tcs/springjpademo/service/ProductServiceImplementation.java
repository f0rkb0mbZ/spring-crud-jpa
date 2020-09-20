package com.tcs.springjpademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springjpademo.model.Product;
import com.tcs.springjpademo.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	
	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}

	@Override
	public void createProduct(Product product) {
		repository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		repository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		repository.deleteById(id);
	}

}
