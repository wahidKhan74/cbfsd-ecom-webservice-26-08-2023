package com.simplilearn.ecomorg.util;

public class StringUtil {

	public static boolean isNotNullOrEmpty(String str) {
	    return str != null && !str.trim().isEmpty();
	}
	
	public static boolean isNotNull(Object obj) {
	    return obj != null ;
	}
	
}
