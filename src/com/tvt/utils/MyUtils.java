/**
 * 
 */
package com.tvt.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Quoc
 *
 */
public class MyUtils {
	public boolean checkValid(String input, String partten) {
		Pattern pattern = Pattern.compile(partten);
		Matcher matcher = pattern.matcher(input);
		return (matcher.matches());
	}
}
