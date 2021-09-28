package com.namkyung.prac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private DBConnection() {}
	
	public static Connection getInstance() {
		String user = "web";
		String password = "web";
		//url
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn= null;
		try {
//			if(conn !=null && !conn.isClosed()) {
//				return conn;
//			}

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar 존재 여부 확인)");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url,user,password 확인");
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		getInstance();
	}
}
