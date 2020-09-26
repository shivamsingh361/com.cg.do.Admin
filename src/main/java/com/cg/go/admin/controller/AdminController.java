package com.cg.go.admin.controller;

import java.util.ArrayList;
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
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping("orderSoldByCategoryOn/{date}")
	public @ResponseBody String orderSoldByCategoryOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		String json = "";
		myMap = growthService.quantitySoldGroupByCategory(date);
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(myMap);
		return json;
	}
	@GetMapping("orderSoldByCategory/{from}/{to}")
	public @ResponseBody String orderSoldByCategory(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		String json = "";
		myMap = growthService.quantitySoldGroupByCategory(from, to);
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(myMap);
		return json;
	}
	
	@GetMapping("orderCancelledByCategoryOn/{date}")
	public @ResponseBody String orderCancelledByCategoryOn(@PathVariable("date") String date) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		String json = "";
		myMap = growthService.quantityCancelledGroupByCategory(date);
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(myMap);
		return json;
	}
	@GetMapping("orderCancelledByCategory/{from}/{to}")
	public @ResponseBody String orderCancelledByCategory(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		String json = "";
		myMap = growthService.quantityCancelledGroupByCategory(from, to);
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(myMap);
		return json;
	}
	
	@GetMapping("revenueGenerated/{from}/{to}")
	public @ResponseBody Double revenueGenerated(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException {
		return revenueService.revenueGenerated(from, to);
	}
	@GetMapping("revenueGeneratedOn/{date}")
	public @ResponseBody Double revenueGeneratedOn(@PathVariable("from") String from, @PathVariable("to") String to) throws InvalidFormatException, UnknownException {
		return revenueService.revenueGenerated(from, to);
	}
	
	
	@GetMapping("getCostOfOrderForStatusOn/{date}/{status}")
	public @ResponseBody String getCostOfOrderForStatusOn(@PathVariable("date") String date, @PathVariable("status") String status) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		String json = "";
		myMap = revenueService.getCostOfOrderForStatus(date, status);
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(myMap);
		return json;
	}
	@GetMapping("getCostOfOrderForStatusOn/{from}/{to}/{status}")
	public @ResponseBody String getCostOfOrderForStatus(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("status") String status) throws InvalidFormatException, UnknownException, JsonProcessingException{
		List<ResultSet> myMap = new ArrayList<ResultSet>();
		String json = "";
		myMap = revenueService.getCostOfOrderForStatus(from, to, status);
		ObjectMapper mapper = new ObjectMapper();
		json = mapper.writeValueAsString(myMap);
		return json;
	}
}
