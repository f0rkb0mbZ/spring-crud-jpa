package com.tcs.springjpademo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springjpademo.model.Product;
import com.tcs.springjpademo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Integer id) {
		try {
			System.out.println("Product found with id: " + id);
			return productService.getProductById(id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("There is no record with id: " + id);
			return null;
		}
	}

	@PostMapping("/products")
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		System.out.println("Product created!");
	}

	@PutMapping("/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable Integer id) {
		Product prd = productService.getProductById(id);
		if (prd != null) {
			product.setId(id);
			productService.updateProduct(product);
		} else {
			System.out.println("There is no record with id: " + id);
		}
		System.out.println("Product updated!");
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		try {
			productService.deleteProduct(id);
			System.out.println("Product deleted");
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			System.out.println("There is no record with id: " + id);
		}
		
	}
}
