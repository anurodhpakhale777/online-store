package com.intelliswift.store.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intelliswift.store.controllers.ProductController;
import com.intelliswift.store.dao.CategoryDao;
import com.intelliswift.store.dao.ProductDao;
import com.intelliswift.store.exception.ProductException;
import com.intelliswift.store.model.Product;
import com.intelliswift.store.service.ProductService;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Override
	public List<Product> getAllProducts() {
		logger.debug("ProductService - getAllProducts");
		return productDao.findAll();
		
	}

	@Override
	public Product addProduct(Product product) {
		logger.debug("ProductService - addProduct "+product);
		//ResponseEntity<Product>
		int id = product.getCategoryId();
		if(categoryDao.existsById(id)) {
			return productDao.saveAndFlush(product);
		}
		else {
			logger.debug("Category id is not exist "+id);
			return null;
		}
	}

	@ExceptionHandler({ProductException.class})
	@Override
	public Product updateProduct(Product prod) {
		logger.debug("ProductService - updateProduct "+prod.getId());
		Product product = productDao.getOne(prod.getId());
		if(product != null) {
			product.setPrice(prod.getPrice());
			product.setProdName(prod.getProdName());
			product.setQuantity(prod.getQuantity());
			product.setCategoryId(prod.getCategoryId());
			return productDao.save(product);
		}
		else {
			logger.debug("product with "+prod.getId()+" is not available.");
			return prod;
		}
	}

	
}
