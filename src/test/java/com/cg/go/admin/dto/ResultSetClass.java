package com.cg.go.admin.dto;

public class ResultSetClass implements ResultSet{
	String category;
	Double qty;
	
	public ResultSetClass(String category, Double qty) {
		super();
		this.category = category;
		this.qty = qty;
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public Double getQty() {
		return this.qty;
	}

}