package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBUtil {
	
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		
		//DB 연결
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/ssafy_mobile_cafe?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8";
		conn = DriverManager.getConnection(url, "ssafy", "ssafy");
		
		return conn;
	}
	
	public static void close(AutoCloseable autoCloseable) {
		if(autoCloseable == null) {
			return;
		}
		
		try {
			autoCloseable.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
	

}
