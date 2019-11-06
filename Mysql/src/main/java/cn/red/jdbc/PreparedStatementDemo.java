package cn.red.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

/*
 * Statement�ӿ�ʵ���࣬����ִ��SQL��䣬���ؽ����
    *    ��һ���ӽӿ�PreparedStatement(SQLԤ���룬��θ�Ч��ִ��SQL)
 */
public class PreparedStatementDemo {
	@Test
	public void TestDML() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";
		String username = "root";
		String password = "199307";
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		
		
		
		String updateSql = "update sort set sname = ? ,sprice = ? where sid = ?";
		PreparedStatement pstate = conn.prepareStatement(updateSql);
		
		pstate.setObject(1,"��������");
		pstate.setObject(2, 5000.0);
		pstate.setObject(3, 1);
		//sql���insert update delete .executeUpdate()����DML���ɹ�������
		int rs = pstate.executeUpdate();
		
		System.out.println(rs);
		
		//6.�ͷ���Դ
		pstate.close();
		conn.close();
	}
	
	@Test
	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void TestQuery() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";
		String username = "root";
		String password = "199307";
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		
		String selectSql = "select * from users";
		PreparedStatement pstate = conn.prepareStatement(selectSql);
		
		ResultSet rs = pstate.executeQuery();
		
		//û�н����
		while(rs.next()) {
			System.out.println(rs.getString("username")+" "+rs.getString("password"));
		}
		
		//6.�ͷ���Դ
		pstate.close();
		conn.close();

	}
}