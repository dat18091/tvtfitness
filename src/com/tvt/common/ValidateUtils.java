package com.tvt.common;

import java.time.LocalDate;

/* 
 * ValidateUtils
 *
 * Date: 26-04-2020
 *
 * Copyright
 *
 * Modification Logs:	
 * DATE				AUTHUR			DESCRIPTION
 *------------------------------------------
 * 26-04-2020		Phuong			Create
 */

public class ValidateUtils {

	public boolean checkDate(String dateStart, String dateEnd) {
		LocalDate begin = LocalDate.parse(dateStart);
		LocalDate end = LocalDate.parse(dateEnd);
		LocalDate dateNow = LocalDate.now();
		
		if (dateNow.isAfter(begin) || dateNow.isAfter(end)) {
			return true;
		}
		
		if (begin.isAfter(end)) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean checkDate(String d) {
		LocalDate dateNow = LocalDate.now();
		LocalDate date = LocalDate.parse(d);
		if (dateNow.isAfter(date)) {
			return true;
		}
		return false;
	}
}
