package com.intelliswift.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelliswift.store.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	
}
