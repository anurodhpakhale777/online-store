package com.intelliswift.store.service;

import java.util.List;

import com.intelliswift.store.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product addProduct(Product product);

	Product updateProduct(Product product);
}
