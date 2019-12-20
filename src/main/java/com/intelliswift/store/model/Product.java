package com.intelliswift.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
public class Product {

	@Id
	private Integer id;
	private String prodName;
	private int quantity;
	private double price;
	private int categoryId;
	
	public Product(Integer id, String prodName, int quantity, double price, int categoryId) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.quantity = quantity;
		this.price = price;
		this.categoryId = categoryId;
	}
	
	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
		
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", quantity=" + quantity + ", category=" 
				+ "]";
	}
	
	
}
