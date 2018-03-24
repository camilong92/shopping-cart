package com.shopping_cart.repository;

import org.springframework.data.repository.CrudRepository;
import com.shopping_cart.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
