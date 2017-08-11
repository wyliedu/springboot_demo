package com.wylie.springboot.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Date Util class
 * 
 * @author Kevin GUO
 *
 *         2016/5/13/
 */
public class DateUtil {
	/**
	 * Convert sql date to java util date
	 * 
	 * @param date
	 * @return
	 * @author Kevin GUO
	 */
	public static Date convertSqlDate(Date date) {
		if (date != null) {
			return new Date(date.getTime());
		}
		else {
			return null;
		}
	}

	/**
	 * Format date object to string
	 * 
	 * @param date
	 *           date that would like to be converted
	 * @param pattern
	 *           parse pattern
	 * @return formated date string
	 * @author Kevin GUO
	 */
	public static String formatDateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
		return sdf.format(date);
	}

	public static Date longToDate(long currentTime, String formatType) throws ParseException {
		Date dateOld = new Date(currentTime);
		String sDateTime = dateToString(dateOld, formatType);
		Date date = stringToDate(sDateTime, formatType);
		return date;
	}

	public static String dateToString(Date data, String formatType) {
		return new SimpleDateFormat(formatType).format(data);
	}

	public static String longToString(long currentTime, String formatType) {
		try {
			Date date = longToDate(currentTime, formatType);
			String strTime = dateToString(date, formatType);
			return strTime;
		}
		catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static Date stringToDate(String strTime, String formatType) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(strTime);
		return date;
	}

	public static long stringToLong(String strTime, String formatType) throws ParseException {
		Date date = stringToDate(strTime, formatType);
		if (date == null) {
			return 0;
		}
		else {
			long currentTime = dateToLong(date);
			return currentTime;
		}
	}

	public static long dateToLong(Date date) {
		return date.getTime();
	}

	public static long getPreDayEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTimeInMillis();
	}

	public static long getPreDayStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

}
