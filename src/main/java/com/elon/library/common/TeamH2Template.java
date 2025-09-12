package com.elon.library.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeamH2Template {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "TEAM02";
	private final String PASSWORD = "TEAM02";
	
	private static TeamH2Template instance;
	
	private TeamH2Template() {}
	
	public static TeamH2Template getInstance() {
		if(instance ==null) {
			instance = new TeamH2Template();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
