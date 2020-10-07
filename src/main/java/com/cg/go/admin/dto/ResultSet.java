package com.cg.go.admin.dto;

// Projections: By making your DTO an interface with getters for columns returned by the query.
public interface ResultSet {
	String getCategory();
	Double getVal();
}
