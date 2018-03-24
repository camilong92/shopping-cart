package com.shopping_cart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping_cart.entities.Product;
import com.shopping_cart.services.ProductService;
import com.shopping_cart.entities.GroupProduct;
import com.shopping_cart.services.GroupProductService;


@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private GroupProductService groupProductService;
		
	@RequestMapping("/")
	public String index(Model model) {	
		List<GroupProduct> groupProductList = groupProductService.findAll();
		model.addAttribute("groupProductList", groupProductList);	
		return "index";
	}

	@RequestMapping("/products")
	public String productshefl(Model model) {
		
		List<GroupProduct> groupProductList = groupProductService.findAll();
		model.addAttribute("groupProductList", groupProductList);	 
		
		List<Product> productsList = productService.findAll();
		model.addAttribute("productsList", productsList);	
		
		return "products";		
	}

}


