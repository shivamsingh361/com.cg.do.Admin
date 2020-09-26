package com.cg.go.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.admin.service.RevenueService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	RevenueService revService;
	
	@GetMapping("/all")
	public @ResponseBody String Check() {
		System.out.println("/all is hit");
		revService.findAll().forEach(s -> System.out.println(s.toString()));
		return "OK";
	}
	@GetMapping("/amt")
	public @ResponseBody Integer customQueryCheck() {
		System.out.println("Custom Query Check Hitt!");
		return (int)revService.TotalOrderAmountbyDate("2020-08-26", "2020-08-22");
	}

}
