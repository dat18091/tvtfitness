/*
 *
 * Date: Apr 16, 2020
 * Authur: Phuong
 *
 */

package com.tvt.common;

import java.sql.Date;

public class StringProcess {
	
	//Convert String to java.sql.Date
	public Date stringToDate (String s) {
		return Date.valueOf(s);
	}
}
