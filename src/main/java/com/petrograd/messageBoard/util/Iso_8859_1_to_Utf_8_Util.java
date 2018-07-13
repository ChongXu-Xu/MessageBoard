package com.petrograd.messageBoard.util;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iso_8859_1_to_Utf_8_Util {
	
	public static String Iso_8859_1_to_Utf_8(String before) throws UnsupportedEncodingException {
		String after = null;
		try {
			after = new String(before.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
		return after;
	}
}
