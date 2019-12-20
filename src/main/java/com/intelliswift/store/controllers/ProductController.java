package com.intelliswift.store.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intelliswift.store.model.Product;
import com.intelliswift.store.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	private static Logger logger = Logger.getLogger(ProductController.class);
	
	@GetMapping("productList")
	public ResponseEntity<List<Product>> getAllProducts(){
		logger.debug("ProductController: getAllProducts call");
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK); 
	}
	
	@PostMapping("save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		logger.debug("ProductController: addProduct call");
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
	}
	
	@PutMapping("update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		logger.debug("ProductController: updateProduct call");
		return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
	}
}
