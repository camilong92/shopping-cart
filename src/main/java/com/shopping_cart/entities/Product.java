package com.shopping_cart.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String image;

	private String name;

	private double price;

	//bi-directional many-to-one association to GroupProduct
	@ManyToOne
	@JoinColumn(name="id_group_product")
	private GroupProduct groupProduct;

	//bi-directional many-to-one association to ShoppingCart
	@OneToMany(mappedBy="product")
	private List<ShoppingCart> shoppingCarts;

	public Product() {
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

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GroupProduct getGroupProduct() {
		return this.groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return this.shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
		getShoppingCarts().add(shoppingCart);
		shoppingCart.setProduct(this);

		return shoppingCart;
	}

	public ShoppingCart removeShoppingCart(ShoppingCart shoppingCart) {
		getShoppingCarts().remove(shoppingCart);
		shoppingCart.setProduct(null);

		return shoppingCart;
	}

}