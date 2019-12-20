package com.intelliswift.store.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelliswift.store.model.Bill;

public interface BillDao extends JpaRepository<Bill, Integer> {

	//List<Bill> fetchAllByDate(Date date);
}
