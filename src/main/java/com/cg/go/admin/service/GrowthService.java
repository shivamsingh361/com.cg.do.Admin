package com.cg.go.admin.service;

import java.util.List;

import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

public interface GrowthService {
	Integer orderPlaced(String date) throws InvalidFormatException, UnknownException;
	Integer orderPlaced(String from, String to) throws InvalidFormatException, UnknownException;
	Integer orderCancelled(String date) throws InvalidFormatException, UnknownException;
	Integer orderCancelled(String from, String to) throws InvalidFormatException, UnknownException;
	List<ResultSet> quantitySoldGroupByCategory(String from, String to) throws InvalidFormatException, UnknownException;
	List<ResultSet> quantitySoldGroupByCategory(String date) throws InvalidFormatException, UnknownException;
	List<ResultSet> quantityCancelledGroupByCategory(String from, String to) throws InvalidFormatException, UnknownException;
	List<ResultSet> quantityCancelledGroupByCategory(String date) throws InvalidFormatException, UnknownException;
}
