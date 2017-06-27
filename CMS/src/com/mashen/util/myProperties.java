package com.mashen.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class myProperties {
	public static String getProperties(String key){
		Properties prop=new Properties();
		InputStream in=new myProperties().getClass().getResourceAsStream("/properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String)prop.get(key);
	}
	public static void main(String[] args) {
		System.out.println(getProperties("url"));
	}
}
