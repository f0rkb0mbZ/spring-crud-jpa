package com.tcs.springjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.springjpademo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}