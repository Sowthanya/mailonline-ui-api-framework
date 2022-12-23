package com.mailonline.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GenericUtils {

	public static String getDateInRequiredFormat(Calendar currentCalDate) {
		String dayNumberSuffix = getDayNumberSuffix(currentCalDate.get(Calendar.DAY_OF_MONTH));
		DateFormat dateFormat = new SimpleDateFormat("EEEE, MMM d'" + dayNumberSuffix + "' yyyy ha",Locale.ENGLISH);
		return dateFormat.format(currentCalDate.getTime());
	}

	public static String getDayNumberSuffix(int day) {
		if (day >= 11 && day <= 13) {
			return "th";
		}
		switch (day % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}
}
