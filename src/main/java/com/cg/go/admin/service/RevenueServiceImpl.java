package com.cg.go.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.dto.Order;

@Service
public class RevenueServiceImpl implements RevenueService {
	@Autowired
	OrderDao orderdao;
	@Override
	public Iterable<Order> findAll() {
		return orderdao.findAll();
	}

	@Override
	public double TotalOrderAmountbyDate(String to, String from) {
		return orderdao.revenueGenerated(to, from);
	}

	@Override
	public double revenueGenerated(String from, String to) {
		return orderdao.revenueGenerated(from, to);
	}

	@Override
	public double revenueGenerated(String date) {
		return orderdao.revenueGenerated(date);
	}

	@Override
	public Map<String, Double> getCostOfOrderForStatus(String date, String status) {
		return orderdao.getCostOfOrderForStatus(date,status);
	}

	@Override
	public Map<String, Double> getCostOfOrderForStatus(String from, String to, String status) {
		return orderdao.getCostOfOrderForStatus(from, to, status);
	}
	
}
