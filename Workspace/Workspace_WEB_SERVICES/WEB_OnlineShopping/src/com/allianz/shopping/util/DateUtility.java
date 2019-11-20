/**
 * 
 */
package com.allianz.shopping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Allianz3076
 *
 */
public class DateUtility {

	public static Date convertStringToDate(String stringDate) throws ParseException {
		return convertStringToDate(stringDate,"dd/MM/yyyy");
	}
	
	public static String convertDateToString(Date date) throws ParseException {
		return convertDateToString(date, "dd/MM/yyyy");
	}
	
	public static String convertDateToString(Date date, String format) throws ParseException {
		return new SimpleDateFormat(format).format(date);
	}

	public static Date convertStringToDate(String stringDate, String format) throws ParseException {
		return new SimpleDateFormat(format).parse(stringDate);
	}
	
	public static java.sql.Date convertUtilDateToSqlDate(Date date){
		return new java.sql.Date(date.getTime());
	}
	
	public static Date convertSqlDateToUtilDate(java.sql.Date date){
		return new Date(date.getTime());
	}
}
