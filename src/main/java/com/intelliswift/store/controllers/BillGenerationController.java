package com.intelliswift.store.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intelliswift.store.dto.BillResponseDto;
import com.intelliswift.store.service.BillService;

@RestController
@RequestMapping("billing")
public class BillGenerationController {

	@Autowired
	private BillService billService;
	
	private static Logger logger = Logger.getLogger(BillGenerationController.class);
	
	@PostMapping("bill")
	public ResponseEntity<BillResponseDto> generateBill(@RequestParam List<Integer> prodIds, @RequestParam List<Integer> quantities){//Map<Integer,Integer> productWithQuantity) {
		
		Map<Integer, Integer> productWithQuantity = new HashMap<>();
		if(prodIds.size() == quantities.size()) {
			for(int i=0; i<prodIds.size(); i++) {
				productWithQuantity.put(prodIds.get(i), quantities.get(i));
			}
			return new ResponseEntity<>(billService.generateBill(productWithQuantity), HttpStatus.OK);
		}
		else {
			logger.debug("product ids and quantites should have equal size");
			return new ResponseEntity<>(new BillResponseDto(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
