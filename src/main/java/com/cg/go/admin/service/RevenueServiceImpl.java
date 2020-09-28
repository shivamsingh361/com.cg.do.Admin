package com.cg.go.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.dto.Order;
import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

@Service
public class RevenueServiceImpl implements RevenueService {
	@Autowired
	OrderDao orderdao;
	@Autowired
	Validate validate;

	@Override
	public Iterable<Order> findAll() {
		return orderdao.findAll();
	}

	@Override
	public double revenueGenerated(String from, String to) throws UnknownException, InvalidFormatException {
		if (validate.isDateValid(from) && validate.isDateValid(to)) {
			try {
				return orderdao.revenueGenerated(from, to);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public double revenueGenerated(String date) throws UnknownException, InvalidFormatException {
		if (validate.isDateValid(date)) {
			try {
				return orderdao.revenueGenerated(date);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public List<ResultSet> getCostOfOrderForStatus(String date, String status)
			throws UnknownException, InvalidFormatException {
		if (validate.isDateValid(date)) {
			try {
				if (!(status.equals("Delivered") || status.equals("Cancelled") || status.equals("Returned")))
					throw new InvalidFormatException("Invalid order status");
				
				return orderdao.getCostOfOrderForStatus(date,status);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public List<ResultSet> getCostOfOrderForStatus(String from, String to, String status)
			throws UnknownException, InvalidFormatException {
		if (validate.isDateValid(from) && validate.isDateValid(to)) {
			try {
				if (!(status.equals("Delivered") || status.equals("Cancelled") || status.equals("Returned")))
					throw new InvalidFormatException("Invalid order status");
				return orderdao.getCostOfOrderForStatus(from, to, status);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}
}
