package com.cg.go.admin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.dao.ProductDao;
import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

@Service
public class GrowthServiceImpl implements GrowthService {

	@Autowired
	OrderDao orderdao;
	@Autowired
	ProductDao productdao;
	@Autowired
	Validate validate;

	@Override
	public Integer orderPlaced(String date) throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(date)) {
			try {
				return orderdao.orderPlaced(date);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public Integer orderPlaced(String from, String to) throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(from) && validate.isDateValid(to)) {
			try {
				return orderdao.orderPlaced(from, to);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public Integer orderCancelled(String date) throws UnknownException, InvalidFormatException {
		if (validate.isDateValid(date)) {
			try {
				return orderdao.orderCancelled(date);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public Integer orderCancelled(String from, String to) throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(from) && validate.isDateValid(to)) {
			try {
				return orderdao.orderCancelled(from, to);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public List<ResultSet> quantitySoldGroupByCategory(String from, String to)
			throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(from) && validate.isDateValid(to)) {
			try {
				return orderdao.quantitySoldGroupByCategory(from, to);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public List<ResultSet> quantitySoldGroupByCategory(String date)
			throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(date)) {
			try {
				return orderdao.quantitySoldGroupByCategory(date);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public List<ResultSet> quantityCancelledGroupByCategory(String from, String to)
			throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(from) && validate.isDateValid(to)) {
			try {
				return orderdao.quantityCancelledGroupByCategory(from, to);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

	@Override
	public List<ResultSet> quantityCancelledGroupByCategory(String date)
			throws InvalidFormatException, UnknownException {
		if (validate.isDateValid(date)) {
			try {
				return orderdao.quantityCancelledGroupByCategory(date);
			} catch (Exception e) {
				throw new UnknownException(e);
			}
		} else
			throw new InvalidFormatException("Invalid Date");
	}

}
