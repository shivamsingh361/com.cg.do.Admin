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
public class RevenueServiceTest {

	@MockBean 
	private OrderDao repo;
	@MockBean
	private Validate validate;
	@MockBean
	private ProductDao productDao;
	@InjectMocks
	private RevenueServiceImpl service;
	
	@Test
	public void testRevenueGenerated() throws InvalidFormatException, UnknownException {
		String from = "2020-08-21";
		String to = "2020-09-22";
		Mockito.when(validate.isDateValid(from)).thenReturn(true);
		Mockito.when(validate.isDateValid(to)).thenReturn(true);
		Mockito.when(repo.revenueGenerated(from, to)).thenReturn(80000.00);
		double result = service.revenueGenerated(from, to);
		assertEquals(80000.00, result);
	}
	
	@Test
	@ExceptionHandler(InvalidFormatException.class)
	public void testRevenueGeneratedOn() throws UnknownException, InvalidFormatException {
		String date = "2020/08/21";
		Mockito.when(validate.isDateValid(date)).thenReturn(true);
		Mockito.when(repo.revenueGenerated(date)).thenReturn(20000.0);
		double result = service.revenueGenerated(date);
		assertEquals(20000.0, result);
		
	}
	
	@Test
	@ExceptionHandler(InvalidFormatException.class)
	public void testgetCostOfOrderForStatusOn() throws UnknownException, InvalidFormatException {
		String date = "2020/09/31";
		String status = "Delivered";
		List<ResultSet> myList = new ArrayList<ResultSet>();
		myList.add(0, new ResultSetClass("Cricket", 3.0));
		myList.add(1, new ResultSetClass("Badminton", 10.0));
		myList.add(2, new ResultSetClass("Camping", 50.0));
		myList.add(3, new ResultSetClass("Basketball", 8.0));
		Mockito.when(validate.isDateValid(date)).thenReturn(true);
		Mockito.when(repo.getCostOfOrderForStatus(date, status)).thenReturn(myList);
		List<ResultSet> result = service.getCostOfOrderForStatus(date, status);
		assertEquals(4, result.size());
		assertEquals("Camping", result.get(2).getCategory());
		assertEquals(3, result.get(0).getQty());
		
	}
	
	@Test
	@ExceptionHandler(InvalidFormatException.class)
	public void testgetCostOfOrderForStatus() throws UnknownException, InvalidFormatException {
		String from = "2020/01/01";
		String to = "2020/09/31";
		String status = "Cancelled";
		List<ResultSet> myList = new ArrayList<ResultSet>();
		myList.add(0, new ResultSetClass("Swimming", 3.0));
		myList.add(1, new ResultSetClass("Football", 4.0));
		myList.add(2, new ResultSetClass("Golf", 6.0));
		myList.add(3, new ResultSetClass("Chess", 1.0));
		Mockito.when(validate.isDateValid(from)).thenReturn(true);
		Mockito.when(validate.isDateValid(to)).thenReturn(true);
		Mockito.when(repo.getCostOfOrderForStatus(from, to, status)).thenReturn(myList);
		List<ResultSet> result = service.getCostOfOrderForStatus(from, to, status);
		assertEquals(4, result.size());
		assertEquals("Golf", result.get(2).getCategory());
		assertEquals(3.0, result.get(0).getQty());
		
	}

}
