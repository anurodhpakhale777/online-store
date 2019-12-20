package com.intelliswift.store.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
public class Category {

	@Id
	private Integer id;
	private String categoryName;
	private float salesTax;
	
	public Category() {
		super();
	}
	public Category(Integer id, String categoryName, float salesTax) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.salesTax = salesTax;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public float getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(float salesTax) {
		this.salesTax = salesTax;
	}

}
