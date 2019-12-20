package com.intelliswift.store.service;

import java.util.List;

import com.intelliswift.store.model.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category addCategory(Category category);

	Category updateCategory(Category category);
}
