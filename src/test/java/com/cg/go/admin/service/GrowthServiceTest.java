package com.cg.go.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.dao.ProductDao;
import com.cg.go.admin.dto.ResultSet;
import com.cg.go.admin.dto.ResultSetClass;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class GrowthServiceTest {
	@MockBean 
	private OrderDao repo;
	@MockBean
	private Validate validate;
	@MockBean
	private ProductDao productDao;
	@InjectMocks
	private GrowthServiceImpl service;
	
	@Test
	@ExceptionHandler
	public void testOrderPlacedOn() throws InvalidFormatException, UnknownException {
		String date = "2020-02-02";
		Mockito.when(validate.isDateValid(date)).thenReturn(true);
		Mockito.when(repo.orderPlaced(date)).thenReturn(20);
		int result = service.orderPlaced(date);
		assertEquals(20, result);
	}
	
	@Test
	@ExceptionHandler
	public void testOrderPlaced() throws InvalidFormatException, UnknownException {
		String from = "2020-02-01";
		String to = "2020-02-24";
		Mockito.when(validate.isDateValid(from)).thenReturn(true);
		Mockito.when(validate.isDateValid(to)).thenReturn(true);
		Mockito.when(repo.orderPlaced(from, to)).thenReturn(30);
		int result = service.orderPlaced(from, to);
		assertEquals(30, result);
	}
	
	@Test
	@ExceptionHandler
	public void testOrderCancelledOn() throws InvalidFormatException, UnknownException {
		String date = "2020-02-02";
		Mockito.when(validate.isDateValid(date)).thenReturn(true);
		Mockito.when(repo.orderCancelled(date)).thenReturn(20);
		int result = service.orderCancelled(date);
		assertEquals(20, result);
	}
	
	@Test
	@ExceptionHandler
	public void testOrderCancelled() throws InvalidFormatException, UnknownException {
		String from = "2020-02-01";
		String to = "2020-02-23";
		Mockito.when(validate.isDateValid(from)).thenReturn(true);
		Mockito.when(validate.isDateValid(to)).thenReturn(true);
		Mockito.when(repo.orderCancelled(from, to)).thenReturn(30);
		int result = service.orderCancelled(from, to);
		assertEquals(30, result);
	}	
	
	@Test
	@ExceptionHandler
	public void testQuantitySoldGroupByCategory() throws InvalidFormatException, UnknownException {
		String from = "2020-02-01";
		String to = "2020-02-23";
		List<ResultSet> myList = new ArrayList<ResultSet>();
		myList.add(new ResultSetClass("Baseball", 909.0));
		myList.add(new ResultSetClass("Gym", 230.0));
		myList.add(new ResultSetClass("Treaking", 344.0));
		myList.add(new ResultSetClass("Yoga", 2000.0));
		Mockito.when(validate.isDateValid(from)).thenReturn(true);
		Mockito.when(validate.isDateValid(to)).thenReturn(true);
		Mockito.when(repo.quantitySoldGroupByCategory(from, to)).thenReturn(myList);
		List<ResultSet> result = service.quantitySoldGroupByCategory(from, to);
		assertEquals(4, result.size());
		assertEquals("Baseball", result.get(0).getCategory());
		assertEquals(344, result.get(2).getQty());
	} 
	@Test
	@ExceptionHandler
	public void testQuantitySoldGroupByCategoryOn() throws InvalidFormatException, UnknownException {
		String date = "2020-02-01";
		List<ResultSet> myList = new ArrayList<ResultSet>();
		myList.add(new ResultSetClass("Running", 989.0));
		myList.add(new ResultSetClass("Rafting", 45.0));
		myList.add(new ResultSetClass("Sprint", 34.0));
		myList.add(new ResultSetClass("Yoga", 200.0));
		Mockito.when(validate.isDateValid(date)).thenReturn(true);
		Mockito.when(repo.quantitySoldGroupByCategory(date)).thenReturn(myList);
		List<ResultSet> result = service.quantitySoldGroupByCategory(date);
		assertEquals(4, result.size());
		assertEquals("Running", result.get(0).getCategory());
		assertEquals(34, result.get(2).getQty());
	} 

	@Test
	@ExceptionHandler
	public void testQuantityCancelledGroupByCategory() throws InvalidFormatException, UnknownException {
		String from = "2020-02-01";
		String to = "2020-02-23";
		List<ResultSet> myList = new ArrayList<ResultSet>();
		myList.add(new ResultSetClass("Baseball", 9.0));
		myList.add(new ResultSetClass("Gym", 20.0));
		myList.add(new ResultSetClass("Treaking", 4.0));
		myList.add(new ResultSetClass("Yoga", 20.0));
		Mockito.when(validate.isDateValid(from)).thenReturn(true);
		Mockito.when(validate.isDateValid(to)).thenReturn(true);
		Mockito.when(repo.quantityCancelledGroupByCategory(from, to)).thenReturn(myList);
		List<ResultSet> result = service.quantityCancelledGroupByCategory(from, to);
		assertEquals(4, result.size());
		assertEquals("Baseball", result.get(0).getCategory());
		assertEquals(4, result.get(2).getQty());
	} 
	@Test
	@ExceptionHandler
	public void testQuantityCancelledGroupByCategoryOn() throws InvalidFormatException, UnknownException {
		String date = "2020-02-01";
		List<ResultSet> myList = new ArrayList<ResultSet>();
		myList.add(new ResultSetClass("Running", 9.0));
		myList.add(new ResultSetClass("Rafting", 5.0));
		myList.add(new ResultSetClass("Sprint", 3.0));
		myList.add(new ResultSetClass("Yoga", 2.0));
		Mockito.when(validate.isDateValid(date)).thenReturn(true);
		Mockito.when(repo.quantityCancelledGroupByCategory(date)).thenReturn(myList);
		List<ResultSet> result = service.quantityCancelledGroupByCategory(date);
		assertEquals(4, result.size());
		assertEquals("Running", result.get(0).getCategory());
		assertEquals(3, result.get(2).getQty());
	}
}
