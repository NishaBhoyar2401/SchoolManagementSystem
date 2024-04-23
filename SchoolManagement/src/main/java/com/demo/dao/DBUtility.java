package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
public static Connection getconnection() {
	Connection conn=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","cscorner");
	}catch(ClassNotFoundException e) {
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return conn;
}
}
