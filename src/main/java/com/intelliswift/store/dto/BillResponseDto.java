package com.intelliswift.store.dto;

import java.io.Serializable;
import java.util.List;

public class BillResponseDto implements Serializable{

	private int billId;
	private List<String> prodNames;
	private List<Integer> quantities;
	private List<Double> costs;
	private List<Float> taxes;
	private int totProducts;
	private int totalItems;
	private double totalCost;
	private Float totaltax;
	
	public BillResponseDto() {
		super();
	}
	public BillResponseDto(int billId, List<String> prodNames, List<Integer> quantities, List<Double> costs,
			List<Float> taxes, int totProducts, int totalItems, double totalCost, Float totaltax) {
		super();
		this.billId = billId;
		this.prodNames = prodNames;
		this.quantities = quantities;
		this.costs = costs;
		this.taxes = taxes;
		this.totProducts = totProducts;
		this.totalItems = totalItems;
		this.totalCost = totalCost;
		this.totaltax = totaltax;
	}
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public List<String> getProdNames() {
		return prodNames;
	}
	public void setProdNames(List<String> prodNames) {
		this.prodNames = prodNames;
	}
	public List<Integer> getQuantities() {
		return quantities;
	}
	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}
	public List<Double> getCosts() {
		return costs;
	}
	public void setCosts(List<Double> costs) {
		this.costs = costs;
	}
	public List<Float> getTaxes() {
		return taxes;
	}
	public void setTaxes(List<Float> taxes) {
		this.taxes = taxes;
	}
	public int getTotProducts() {
		return totProducts;
	}
	public void setTotProducts(int totProducts) {
		this.totProducts = totProducts;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Float getTotaltax() {
		return totaltax;
	}
	public void setTotaltax(Float totaltax) {
		this.totaltax = totaltax;
	}
}
