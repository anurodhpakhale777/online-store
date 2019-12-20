package com.intelliswift.store.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelliswift.store.dao.BillDao;
import com.intelliswift.store.dao.CategoryDao;
import com.intelliswift.store.dao.ProductDao;
import com.intelliswift.store.dto.BillResponseDto;
import com.intelliswift.store.model.Bill;
import com.intelliswift.store.model.Category;
import com.intelliswift.store.model.Product;
import com.intelliswift.store.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	private static Logger logger = Logger.getLogger(BillServiceImpl.class);
	
	private BillResponseDto billResponseDto;
	
	@Override
	public Bill saveBill(Bill bill) {
		logger.debug("BillServiceImpl - saveBill "+bill);
		return billDao.saveAndFlush(bill);
	}
	

	@Override
	public BillResponseDto generateBill(Map<Integer, Integer> productWithQuantity) {
		logger.debug("BillServiceImpl - generateBill ");
		
		 billResponseDto = new BillResponseDto();
		 billResponseDto.setProdNames(new ArrayList<String>());
		 billResponseDto.setQuantities( new ArrayList<Integer>());
		 billResponseDto.setCosts( new ArrayList<Double>());
		 billResponseDto.setTaxes(new ArrayList<Float>());
		
		
		productWithQuantity.forEach((productId, quantity) -> {
			Optional<Product> productOpt = productDao.findById(productId);
			if(productOpt.isPresent()) {
				Product product = productOpt.get();
				
				if(product.getQuantity() >= quantity) {
					billResponseDto.getProdNames().add(product.getProdName());
					billResponseDto.getQuantities().add(quantity);
					
					double cost = product.getPrice() * quantity;
					
					int  categoryId = product.getCategoryId();
					Category category = categoryDao.getOne(categoryId);
					float tax = category.getSalesTax();
					double totalCostForProd = cost + cost * tax / 100;
					billResponseDto.getCosts().add(totalCostForProd);
					float totalTaxForProd = quantity * (float) (product.getPrice() * tax / 100) ;
					billResponseDto.getTaxes().add(totalTaxForProd);
					
					logger.debug("Total cost for product "+productId+" after applying tax is "+cost
							+"with their total tax "+totalCostForProd);
				}else {
					logger.debug("Product "+productId+" has less quantity, only "+product.getQuantity());
				}
			}else {
				logger.debug("Product with "+productId+" is not present");
			}
		});
		
		double totalCost = billResponseDto.getCosts().stream().reduce((cost1, cost2) -> cost1 + cost2 ).get();
		billResponseDto.setTotalCost(totalCost);
		
		float totalTax = billResponseDto.getTaxes().stream().reduce((tax1, tax2) -> tax1 + tax2 ).get();
		billResponseDto.setTotaltax(totalTax);
		
		int totalproducts = billResponseDto.getProdNames().size();
		billResponseDto.setTotProducts(totalproducts);
		
		int totalItems = billResponseDto.getQuantities().stream().reduce((q1, q2) -> q1 + q2).get();
		billResponseDto.setTotalItems(totalItems);
		logger.debug("totalCost");
		
		Bill bill = new Bill();
		bill.setAmount(totalCost);
		bill.setDate(new Date());
		bill = saveBill(bill);
		
		billResponseDto.setBillId(bill.getId());
		
		return billResponseDto;
	}

	
}
