package com.cg.go.admin.service;

import java.util.Map;

import com.cg.go.admin.dto.Order;

public interface RevenueService {
	double TotalOrderAmountbyDate(String to, String from);
	Iterable<Order> findAll();
	
	double revenueGenerated(String from, String to);
	double revenueGenerated(String date);
	Map<String, Double> getCostOfOrderForStatus(String date, String status);
	Map<String, Double> getCostOfOrderForStatus(String from, String to, String status);
}
