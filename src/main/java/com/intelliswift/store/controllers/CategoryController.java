package com.intelliswift.store.controllers;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intelliswift.store.model.Category;
import com.intelliswift.store.service.CategoryService;
import com.intelliswift.store.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@GetMapping("categoryList")
	public List<Category> getAllCategory(){
		logger.debug("CategoryController - getAllCategory");
		return categoryService.getAllCategories();
	}
	
	@PostMapping("save")
	@ResponseBody
	public Category addCategory(@RequestBody Category category){
		logger.debug("CategoryController - addCategory "+category);
		return categoryService.addCategory(category);
	}
}
