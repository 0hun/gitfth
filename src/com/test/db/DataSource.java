package com.test.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	private static String driverName="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static String user="jsp";
	private static String pwd="jsp";
	
	public static Connection getConnection() throws Exception{
		Connection conn=null;
		
		Class.forName(driverName);
		conn=DriverManager.getConnection(url,user,pwd);
		
		return conn;		
	}
	
	
}
