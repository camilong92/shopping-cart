package com.shopping_cart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping_cart.entities.Product;
import com.shopping_cart.repository.ProductRepository;
import com.shopping_cart.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){	
		return (List<Product>) productRepository.findAll();
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
}
