package com.cg.go.admin.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.go.admin.dao.OrderDao;
import com.cg.go.admin.exceptions.InvalidFormatException;
import com.cg.go.admin.exceptions.UnknownException;
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class RevenueServiceTest {

	@MockBean 
	private OrderDao repo;
	@MockBean
	private Validate validate;
	@InjectMocks
	private RevenueServiceImpl service;
	
//	@Test
//	public void testTotalOrderAmountbyDate() throws InvalidFormatException, UnknownException {
//		String from = "2020-08-21";
//		String to = "2020-09-22";
//		
//		Mockito.when(repo.revenueGenerated(from, to)).thenReturn(80000.00);
//		double result = service.TotalOrderAmountbyDate(to, from);
//		assertThat(result);
//	}
//	@Test
//	public void testTotalOrderAmountbyDateDateValidateion() {
//		String from = "2020/08/21";
//		String to = "2020/09/22";
//		Throwable exception = assertThrows(InvalidFormatException.class, () -> service.TotalOrderAmountbyDate(to, from));
//	    assertEquals("Invalid Date", exception.getMessage());
//	}
//	@Test
//	public void testTotalOrderAmountbyDateDateValidateion2() {
//		String from = "2020-08-32";
//		String to = "2020-03-20";
//		Throwable exception = assertThrows(InvalidFormatException.class, () -> service.TotalOrderAmountbyDate(to, from));
//	    assertEquals("Invalid Date", exception.getMessage());
//	}

}
