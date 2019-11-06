package cn.red.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

/*
 * Statement接口实现类，作用执行SQL语句，返回结果集
    *    有一个子接口PreparedStatement(SQL预编译，多次高效的执行SQL)
 */
public class DefendSQLInjection {
	@Test
	public void testSqlInject() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";
		String username = "root";
		String password = "199307";
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		
		
		
		//Sql注入
		Scanner scan = new Scanner(System.in);
		String user = scan.nextLine();// a
		String pass = scan.nextLine();// 1' or '1' = '1
		String selectSql = "select * from users where username = ? and password = ?";
		PreparedStatement pstate = conn.prepareStatement(selectSql);
		
		pstate.setObject(1,user);
		pstate.setObject(2, pass);
		ResultSet rs = pstate.executeQuery();
		
		//没有结果集
		while(rs.next()) {
			System.out.println(rs.getString("username")+" "+rs.getString("password"));
		}
		
		//6.释放资源
		pstate.close();
		conn.close();
	}
	
}