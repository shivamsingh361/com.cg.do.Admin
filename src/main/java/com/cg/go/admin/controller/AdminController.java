package com.cg.go.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(
			value = "orderPlacedOn/{date}",
			produces = "application/json")
	public @ResponseBody Integer orderPlacedOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException{
		return growthService.orderPlaced(date);
	}
	@GetMapping(
			value = "orderPlaced/{from}/{to}",
			produces = "application/json")
	public @ResponseBody Integer orderPlaced(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException{
		return growthService.orderPlaced(from, to);
	}
	
	@GetMapping(
			value = "orderCancelledOn/{date}",
			produces = "application/json")
	public @ResponseBody Integer orderCancelledOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException{
		return growthService.orderCancelled(date);
	}
	@GetMapping(
			value = "orderCancelled/{from}/{to}",
			produces = "application/json")
	public @ResponseBody Integer orderCancelled(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException{
		return growthService.orderCancelled(from, to);
	}
	
	@GetMapping(
			  value = "orderSoldByCategoryOn/{date}", 
			  produces = "application/json")
	public @ResponseBody List<ResultSet> orderSoldByCategoryOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException, JsonProcessingException{
		return growthService.quantitySoldGroupByCategory(date);
	}
	
	@GetMapping(
			  value = "orderSoldByCategory/{from}/{to}", 
			  produces = "application/json")
	public @ResponseBody List<ResultSet> orderSoldByCategory(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException, JsonProcessingException{
		return growthService.quantitySoldGroupByCategory(from, to);
	}
	
	@GetMapping(
			  value = "orderCancelledByCategoryOn/{date}", 
			  produces = "application/json")
	public @ResponseBody List<ResultSet> orderCancelledByCategoryOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException, JsonProcessingException{
		return growthService.quantityCancelledGroupByCategory(date);
	}
	
	@GetMapping(
			  value = "orderCancelledByCategory/{from}/{to}", 
			  produces = "application/json")
	public @ResponseBody List<ResultSet> orderCancelledByCategory(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException, JsonProcessingException{
		return growthService.quantityCancelledGroupByCategory(from, to);
	}
	
	@GetMapping(
			value = "revenueGenerated/{from}/{to}",
			produces = "application/json")
	public @ResponseBody Double revenueGenerated(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException {
		return revenueService.revenueGenerated(from, to);
	}
	@GetMapping(
			value = "revenueGeneratedOn/{date}",
			produces = "application/json")
	public @ResponseBody Double revenueGeneratedOn(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException {
		return revenueService.revenueGenerated(from, to);
	}
	
	@GetMapping(
			  value = "getCostOfOrderForStatusOn/{date}/{status}", 
			  produces = "application/json")
	public @ResponseBody List<ResultSet> getCostOfOrderForStatusOn(@PathVariable("date") String date, @PathVariable("status") String status) throws InvalidFormatException, UnknownException, JsonProcessingException{
		return revenueService.getCostOfOrderForStatus(date, status);
		
	}
	@GetMapping(
			  value = "getCostOfOrderForStatus/{from}/{to}/{status}", 
			  produces = "application/json")
	public @ResponseBody List<ResultSet> getCostOfOrderForStatus(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("status") String status) throws InvalidFormatException, UnknownException, JsonProcessingException{
		return revenueService.getCostOfOrderForStatus(from, to, status);
	}
}
