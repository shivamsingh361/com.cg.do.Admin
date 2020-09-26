package com.cg.go.admin.service;

import java.util.Map;

public interface GrowthService {
	Integer orderPlaced(String date);
	Integer orderPlaced(String from, String to);
	Integer orderCancelled(String date);
	Integer orderCancelled(String from, String to);
	Map<String, Integer> quantitySoldGroupByCategory(String from, String to);
	Map<String, Integer> quantitySoldGroupByCategory(String date);
	Map<String, Integer> quantityCancelledGroupByCategory(String from, String to);
	Map<String, Integer> quantityCancelledGroupByCategory(String date);
}
