package com.shopping_cart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping_cart.entities.GroupProduct;
import com.shopping_cart.repository.GroupProductRepository;
import com.shopping_cart.services.GroupProductService;

@Service
public class GroupProductServiceImpl implements GroupProductService{
	
	@Autowired
	private GroupProductRepository groupProductRepository;
	
	public List<GroupProduct> findAll(){
		return (List<GroupProduct>) groupProductRepository.findAll();
	}
}
