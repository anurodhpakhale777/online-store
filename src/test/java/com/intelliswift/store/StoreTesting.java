package com.intelliswift.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelliswift.store.controllers.BillGenerationController;
import com.intelliswift.store.dto.BillResponseDto;
import com.intelliswift.store.model.Category;
import com.intelliswift.store.model.Product;
import com.intelliswift.store.service.BillService;
import com.intelliswift.store.service.CategoryService;
import com.intelliswift.store.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class StoreTesting {

	@InjectMocks
	private BillGenerationController billGenerationController;
	
	@Mock
	private ProductService productService;
	
	@Mock
	private CategoryService categoryService;
	
	@Mock
	private BillService billService;
	
	@Test
	public void billTesting() {
		
		
		Category category1 = new Category(1,"Fruits",10);
		Category category2 = new Category(2,"Clothes",20);
		Category category3 = new Category(3,"Gadgets",0);
		List<Category> categories = new ArrayList<>(Arrays.asList(category1,category2,category3));
		
		
		Product prod1 = new Product(1, "Mango", 10, 20, 1);
		Product prod2 = new Product(2, "Pant", 20, 200, 2);
		Product prod3 = new Product(3, "Shirt", 10, 100, 2);
		Product prod4 = new Product(4, "Mobile", 25, 2000, 3);
		Product prod5 = new Product(5, "Orange", 15, 60, 1);
		Product prod6 = new Product(6, "Speaker", 50, 200, 3);
		List<Product> products = new ArrayList<>(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6));
		
		//<prod-Id, their quantity>
		Map<Integer, Integer> productWithQuantity = new HashMap<>();
		productWithQuantity.put(2, 1);
		productWithQuantity.put(4, 2);
		productWithQuantity.put(5, 6);
		
		List<String> prodNames = new ArrayList<>(Arrays.asList("Pant","Mobile","Orange"));
		List<Integer> quantities = new ArrayList<>(Arrays.asList(1,2,6));
		List<Double> costs = new ArrayList<Double>(Arrays.asList(240d,400d,99d));
		List<Float> taxes = new ArrayList<>(Arrays.asList(40f,0f,9f));
		
		BillResponseDto expectedresponse = new BillResponseDto(1, prodNames, quantities, costs, taxes, 3, 9, 739d, 49f);
		when( billService.generateBill(productWithQuantity)).thenReturn(expectedresponse);
		
		BillResponseDto actualResponse = billService.generateBill(productWithQuantity);
		
		assertEquals(expectedresponse.getTotalCost(), actualResponse.getTotalCost());
		assertEquals(expectedresponse.getTotaltax(), actualResponse.getTotaltax());
	}
	
	@Test
	public void addCategoryTest() {
		Category category1 = new Category(1,"Fruits",10);
		Category category3 = new Category(3,"Gadgets",0);
		
		when(categoryService.addCategory(category1)).thenReturn(new Category(1,"Fruits",10));
		
		Category category = categoryService.addCategory(category1);
		
		assertEquals("Fruits", category.getCategoryName());
		assertEquals(10, category.getSalesTax());
	}
	
	@Test
	public void addProductTest() {
		Product prod1 = new Product(1, "Mango", 10, 20, 1);
		Product prod2 = new Product(2, "Pant", 20, 200, 2);
		
		when(productService.addProduct(prod1)).thenReturn(new Product(1, "Mango", 10, 20, 1));
		
		Product product = productService.addProduct(prod1);
		
		assertEquals("Mango", product.getProdName());
		assertEquals(10, product.getPrice());
	}
}
