package com.itsight.cuy.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Parseador {

	public static Date fromStringToDateSimple(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "ES"));
		Date parseDate = null;
		
		try {
			parseDate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return parseDate;
	}
	
	public static Date fromStringToFullDate(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm", new Locale("es", "ES"));
		Date parseDate = null;
		
		try {
			parseDate = sdf.parse(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		} 
		return parseDate;
	}
	
	public static BigDecimal fromDoubleToBigDecimal(double value, int scale) {
		return  BigDecimal.valueOf(value).setScale(scale);
	}
	
	public static int fromStringToInt(String cadena) {
		try {
			return Integer.parseInt(cadena);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public static double fromStringToDouble(String cadena) {
		try {
			return Double.parseDouble(cadena);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
}
