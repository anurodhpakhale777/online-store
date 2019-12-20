package com.intelliswift.store.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.intelliswift.store.dto.BillResponseDto;
import com.intelliswift.store.model.Bill;

public interface BillService {

	Bill saveBill(Bill bill);
	//List<Bill> getBillsByDate(Date date);
	BillResponseDto generateBill(Map<Integer, Integer> productWithQuantity);
}
