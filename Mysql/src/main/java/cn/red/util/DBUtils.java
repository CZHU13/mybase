package cn.red.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static Connection conn;
	
	/*
	 * 工具类
	 */
	private DBUtils() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";
			String username = "root";
			String password = "199307";
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException("数据库连接失败");
		}
	}
	
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConnection() {
		return conn;
	}
	
	/**
	 * 关闭连接对象
	 * @param conn
	 * @param state
	 * @param rs
	 */
	public static void close(Connection conn,Statement state,ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(state!=null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
