package com.cg.go.admin.dto;

public class ResultSetClass implements ResultSet{
	String category;
	Double val;
	
	public ResultSetClass(String category, Double qty) {
		super();
		this.category = category;
		this.val = qty;
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public Double getVal() {
		return this.val;
	}

}