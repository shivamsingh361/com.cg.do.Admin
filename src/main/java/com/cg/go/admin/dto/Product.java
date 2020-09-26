package com.cg.go.admin.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
public class Product {
	@Id
	private String product_id;
	private String product_name;
	private String category;
	private String description;
	private double price;
	private String manufacturer;
	public Product() {
		super();
	}
	public Product(String product_id, String product_name, String category, String description, double price,
			String manufacturer) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.manufacturer = manufacturer;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", category=" + category
				+ ", description=" + description + ", price=" + price + ", manufacturer=" + manufacturer + "]";
	}
	
}
