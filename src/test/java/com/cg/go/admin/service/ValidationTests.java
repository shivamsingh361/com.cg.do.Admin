package com.cg.go.admin.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ValidationTests {
	private static Validate service;
	
	@BeforeAll
	public static void init() {
		service = new Validate();
	}
	@Test
	public void testIsValidDateforValid() {
		String date = "2020-02-02";
		boolean result = service.isDateValid(date);
		assertTrue(result);
	}
	@Test
	public void testIsValidDateForInvalidYear() {
		String date = "20200-13-02";
		boolean result = service.isDateValid(date);
		assertFalse(result);
	}
	@Test
	public void testIsValidDateForInvalidMonth() {
		String date = "2020-13-02";
		boolean result = service.isDateValid(date);
		assertFalse(result);
	}
	@Test
	public void testIsValidDateForInvalidDay() {
		String date = "2020-12-00";
		boolean result = service.isDateValid(date);
		assertFalse(result);
	}
	@Test
	public void testIsValidDateForInvalidFormat() {
		String date = "13-02-2020";
		boolean result = service.isDateValid(date);
		assertFalse(result);
	}
	public void testIsValidDateForInvalidFormat1() {
		String date = "2020/10/10";
		boolean result = service.isDateValid(date);
		assertFalse(result);
	}
}
