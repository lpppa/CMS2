package com.mashen.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class myDate {
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
}
