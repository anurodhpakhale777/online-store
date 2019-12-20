package com.intelliswift.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelliswift.store.model.Category;
import com.intelliswift.store.model.Product;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	
}
