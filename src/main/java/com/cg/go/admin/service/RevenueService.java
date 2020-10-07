package com.cg.go.admin.service;

import java.util.List;

import com.cg.go.admin.dto.Order;
import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

public interface RevenueService {
	Iterable<Order> findAll();

	Double revenueGenerated(String from, String to) throws InvalidFormatException, UnknownException;

	Double revenueGenerated(String date) throws InvalidFormatException, UnknownException;

	List<ResultSet> getCostOfOrderForStatus(String date, String status)
			throws InvalidFormatException, UnknownException;

	List<ResultSet> getCostOfOrderForStatus(String from, String to, String status)
			throws InvalidFormatException, UnknownException;
}
