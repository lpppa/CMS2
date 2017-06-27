package com.mashen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConn {
	static{
		try {
			Class.forName(myProperties.getProperties("jdbc"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() throws SQLException{
		return DriverManager.getConnection(myProperties.getProperties("url"),myProperties.getProperties("user"),myProperties.getProperties("password"));
	}
}
