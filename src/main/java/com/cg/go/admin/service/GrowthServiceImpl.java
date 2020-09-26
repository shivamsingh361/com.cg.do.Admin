package com.cg.go.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.go.admin.dao.OrderDao;

public class GrowthServiceImpl implements GrowthService {

	@Autowired
	OrderDao orderdao;
	
	@Override
	public Integer orderPlaced(String date) {
		return orderdao.orderPlaced(date);
	}

	@Override
	public Integer orderPlaced(String from, String to) {
		return orderdao.orderPlaced(from, to);
	}

	@Override
	public Integer orderCancelled(String date) {
		return orderdao.orderCancelled(date);
	}

	@Override
	public Integer orderCancelled(String from, String to) {
		return orderdao.orderCancelled(from, to);
	}

	@Override
	public Map<String, Integer> quantitySoldGroupByCategory(String from, String to) {
		return orderdao.quantitySoldGroupByCategory(from, to);
	}

	@Override
	public Map<String, Integer> quantitySoldGroupByCategory(String date) {
		return orderdao.quantitySoldGroupByCategory(date);
	}

	@Override
	public Map<String, Integer> quantityCancelledGroupByCategory(String from, String to) {
		return orderdao.quantityCancelledGroupByCategory(from, to);
	}

	@Override
	public Map<String, Integer> quantityCancelledGroupByCategory(String date) {
		return orderdao.quantityCancelledGroupByCategory(date);
	}

}
