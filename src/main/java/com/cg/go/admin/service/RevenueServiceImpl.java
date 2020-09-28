package com.cg.go.admin.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.dto.Order;
import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

@Service
public class RevenueServiceImpl implements RevenueService {
	private static Logger logger = LogManager.getLogger(RevenueServiceImpl.class);

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
		if (!(validate.isDateValid(from) && validate.isDateValid(to)))
			throw new InvalidFormatException("Invalid Date in Method: revenueGenerated");
		try {
			return orderdao.revenueGenerated(from, to);
		} catch (Exception e) {
			logger.warn("Exception catched in revenueGenerated.", e);
			throw new UnknownException(e);
		}

	}

	@Override
	public double revenueGenerated(String date) throws UnknownException, InvalidFormatException {
		if (!validate.isDateValid(date))
			throw new InvalidFormatException("Invalid Date in method: revenueGenerated");
		try {
			return orderdao.revenueGenerated(date);
		} catch (Exception e) {
			logger.warn("Exception catched in revenueGenerated.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public List<ResultSet> getCostOfOrderForStatus(String date, String status)
			throws UnknownException, InvalidFormatException {
		if (!validate.isDateValid(date))
			throw new InvalidFormatException("Invalid Date in Method: getCostOfOrderForStatus");
		try {
			if (!(status.equals("Delivered") || status.equals("Cancelled") || status.equals("Returned")))
				throw new InvalidFormatException("Invalid order status");

			return orderdao.getCostOfOrderForStatus(date, status);
		} catch (Exception e) {
			logger.warn("Exception catched in getCostOfOrderForStatus.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public List<ResultSet> getCostOfOrderForStatus(String from, String to, String status)
			throws UnknownException, InvalidFormatException {
		if (!(validate.isDateValid(from) && validate.isDateValid(to)))
			throw new InvalidFormatException("Invalid Date in Method: getCostOfOrderForStatus");
		try {
			if (!(status.equals("Delivered") || status.equals("Cancelled") || status.equals("Returned")))
				throw new InvalidFormatException("Invalid order status");
			return orderdao.getCostOfOrderForStatus(from, to, status);
		} catch (Exception e) {
			logger.warn("Exception catched in getCostOfOrderForStatus.", e);
			throw new UnknownException(e);
		}
	}
}
