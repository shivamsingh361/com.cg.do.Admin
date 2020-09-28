package com.cg.go.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;
import com.cg.go.admin.service.GrowthService;
import com.cg.go.admin.service.RevenueService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	RevenueService revenueService;
	@Autowired
	GrowthService growthService;
	
	@GetMapping("orderPlacedOn/{date}")
	public @ResponseBody Integer orderPlacedOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException{
		return growthService.orderPlaced(date);
	}
	@GetMapping("orderPlaced/{from}/{to}")
	public @ResponseBody Integer orderPlaced(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException{
		return growthService.orderPlaced(from, to);
	}
	
	@GetMapping("orderCancelledOn/{date}")
	public @ResponseBody Integer orderCancelledOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException{
		return growthService.orderCancelled(date);
	}
	@GetMapping("orderCancelled/{from}/{to}")
	public @ResponseBody Integer orderCancelled(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException{
		return growthService.orderCancelled(from, to);
	}
	
	@RequestMapping(
			  value = "orderSoldByCategoryOn/{date}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET})
	public @ResponseBody List<ResultSet> orderSoldByCategoryOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		myMap = growthService.quantitySoldGroupByCategory(date);
		return myMap;
	}
	
	@RequestMapping(
			  value = "orderSoldByCategory/{from}/{to}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET})
	public @ResponseBody List<ResultSet> orderSoldByCategory(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		myMap = growthService.quantitySoldGroupByCategory(from, to);
		return myMap;
	}
	
	@RequestMapping(
			  value = "orderCancelledByCategoryOn/{date}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET})
	public @ResponseBody List<ResultSet> orderCancelledByCategoryOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		myMap = growthService.quantityCancelledGroupByCategory(date);
		return myMap;
	}
	
	@RequestMapping(
			  value = "orderCancelledByCategory/{from}/{to}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET})
	public @ResponseBody List<ResultSet> orderCancelledByCategory(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		myMap = growthService.quantityCancelledGroupByCategory(from, to);
		return myMap;
	}
	
	@GetMapping("revenueGenerated/{from}/{to}")
	public @ResponseBody Double revenueGenerated(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException {
		return revenueService.revenueGenerated(from, to);
	}
	@GetMapping("revenueGeneratedOn/{date}")
	public @ResponseBody Double revenueGeneratedOn(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException {
		return revenueService.revenueGenerated(from, to);
	}
	
	@RequestMapping(
			  value = "getCostOfOrderForStatusOn/{date}/{status}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET})
	public @ResponseBody List<ResultSet> getCostOfOrderForStatusOn(@PathVariable("date") String date, @PathVariable("status") String status) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		myMap = revenueService.getCostOfOrderForStatus(date, status);
		return myMap;
	}
	@RequestMapping(
			  value = "getCostOfOrderForStatus/{from}/{to}/{status}", 
			  produces = "application/json", 
			  method = {RequestMethod.GET})
	public @ResponseBody List<ResultSet> getCostOfOrderForStatus(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("status") String status) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		myMap = revenueService.getCostOfOrderForStatus(from, to, status);
		return myMap;
	}
}
