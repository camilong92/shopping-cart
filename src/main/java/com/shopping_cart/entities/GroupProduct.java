package com.shopping_cart.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group_products database table.
 * 
 */
@Entity
@Table(name="group_products")
@NamedQuery(name="GroupProduct.findAll", query="SELECT g FROM GroupProduct g")
public class GroupProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="groupProduct")
	private List<Product> products;

	public GroupProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setGroupProduct(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setGroupProduct(null);

		return product;
	}

}