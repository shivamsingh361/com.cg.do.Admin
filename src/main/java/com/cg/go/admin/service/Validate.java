package com.cg.go.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Service;

@Service
public class Validate {
	SimpleDateFormat df;
	public Validate() {
		df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
	}
	public boolean isDateValid(String date) {
		try {
	        this.df.parse(date);
	        return true;
	    } catch (ParseException ex) {
	        return false;
	    }
	}

}
