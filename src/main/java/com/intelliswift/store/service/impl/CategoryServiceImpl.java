package com.intelliswift.store.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelliswift.store.dao.CategoryDao;
import com.intelliswift.store.model.Category;
import com.intelliswift.store.model.Product;
import com.intelliswift.store.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Override
	public List<Category> getAllCategories() {
		logger.debug("CategoryService - getAllCategories");
		return categoryDao.findAll();
	}
	
	@Override
	public Category addCategory(Category category) {
		logger.debug("CategoryService - addCategory "+category);
		return categoryDao.saveAndFlush(category);
	}

	@Override
	public Category updateCategory(Category categ) {
		logger.debug("CategoryService - updateCategory "+categ);
		Category category = categoryDao.getOne(categ.getId());
		if(category != null) {
			category.setCategoryName(categ.getCategoryName());
			category.setSalesTax(categ.getSalesTax());
			return categoryDao.save(category);
		}
		else {
			logger.debug("product with "+category.getId()+" is not available.");
		}
		return categ;
	}

}
