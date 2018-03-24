package com.shopping_cart.services;

import java.util.List;

import com.shopping_cart.entities.Product;

public interface ProductService {
		List<Product> findAll();
		Product save(Product product);
}