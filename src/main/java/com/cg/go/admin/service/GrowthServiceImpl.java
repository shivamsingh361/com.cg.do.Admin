package com.cg.go.admin.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

@Service
public class GrowthServiceImpl implements GrowthService {
	private static Logger logger = LogManager.getLogger(GrowthServiceImpl.class);

	@Autowired
	OrderDao orderdao;
	@Autowired
	Validate validate;

	@Override
	public Integer orderPlaced(String date) throws InvalidFormatException, UnknownException {
		if (!validate.isDateValid(date))
			throw new InvalidFormatException("Invalid Date in Method: orderPlaced");
		try {
			return orderdao.orderPlaced(date);
		} catch (Exception e) {
			logger.warn("Exception catched in orderPlaced.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public Integer orderPlaced(String from, String to) throws InvalidFormatException, UnknownException {
		if (!(validate.isDateValid(from) && validate.isDateValid(to)))
			throw new InvalidFormatException("Invalid Date in Method: orderPlaced");
		try {
			return orderdao.orderPlaced(from, to);
		} catch (Exception e) {
			logger.warn("Exception catched in orderPlaced.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public Integer orderCancelled(String date) throws UnknownException, InvalidFormatException {
		if (!validate.isDateValid(date))
			throw new InvalidFormatException("Invalid Date in Mehtod: orderCancelled");
		try {
			return orderdao.orderCancelled(date);
		} catch (Exception e) {
			logger.warn("Exception catched in orderCancelled.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public Integer orderCancelled(String from, String to) throws InvalidFormatException, UnknownException {
		if (!(validate.isDateValid(from) && validate.isDateValid(to)))
			throw new InvalidFormatException("Invalid Date in Method: orderCancelled");
		try {
			return orderdao.orderCancelled(from, to);
		} catch (Exception e) {
			logger.warn("Exception catched in orderCancelled.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public List<ResultSet> quantitySoldGroupByCategory(String from, String to)
			throws InvalidFormatException, UnknownException {
		if (!(validate.isDateValid(from) && validate.isDateValid(to)))
			throw new InvalidFormatException("Invalid Date in Method: quantitySoldGroupByCategory");
		try {
			return orderdao.quantitySoldGroupByCategory(from, to);
		} catch (Exception e) {
			logger.warn("Exception catched in quantitySoldGroupByCategory.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public List<ResultSet> quantitySoldGroupByCategory(String date) throws InvalidFormatException, UnknownException {
		if (!validate.isDateValid(date))
			throw new InvalidFormatException("Invalid Date in Method: quantitySoldGroupByCategory");
		try {
			return orderdao.quantitySoldGroupByCategory(date);
		} catch (Exception e) {
			logger.warn("Exception catched in quantitySoldGroupByCategory.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public List<ResultSet> quantityCancelledGroupByCategory(String from, String to)
			throws InvalidFormatException, UnknownException {
		if (!(validate.isDateValid(from) && validate.isDateValid(to)))
			throw new InvalidFormatException("Invalid Date in Method: quantityCancelledGroupByCategory");
		try {
			return orderdao.quantityCancelledGroupByCategory(from, to);
		} catch (Exception e) {
			logger.warn("Exception catched in Method: quantityCancelledGroupByCategory.", e);
			throw new UnknownException(e);
		}
	}

	@Override
	public List<ResultSet> quantityCancelledGroupByCategory(String date)
			throws InvalidFormatException, UnknownException {
		if (!validate.isDateValid(date))
			throw new InvalidFormatException("Invalid Date in Method: quantityCancelledGroupByCategory");
		try {
			return orderdao.quantityCancelledGroupByCategory(date);
		} catch (Exception e) {
			logger.warn("Exception catched in Method: quantityCancelledGroupByCategory.", e);
			throw new UnknownException(e);
		}
	}

}
