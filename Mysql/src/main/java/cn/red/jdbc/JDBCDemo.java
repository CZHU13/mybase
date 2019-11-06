package cn.red.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author zc285
 * JDBC操作数据库步骤
 * 1.注册驱动
          告知JVM使用的是哪一个数据库驱动
 * 2.获取连接
    使用JDBC中类，完成对mysql数据库的连接
   3.获取语言执行平台
   获取连接对象获取对SQL语句的执行对象
   4.执行sql语句
   使用执行者对象，向数据库执行SQL语句
   5.处理结果
   6.释放资源 一堆close
 */
public class JDBCDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//1.注册驱动
	    //使用java.sql.DriverManager类静态方法registerDriver(Driver driver);
		//Driver又是一个接口，参数传递，MySQL驱动程序的实现类com.mysql.jdbc.Driver
		//DriverManager.registerDriver(new Driver());
		//驱动类源代码，注册2次驱动程序
		Class.forName("com.mysql.cj.jdbc.Driver");//多了  cj

		/*
		 * 2.获得数据库的连接
		 * DriverManager.getConnection(String url, String user, String password),获取
		 * 返回值是Connection接口的实现类，在mysql驱动程序中
		jdbc:mysql://ip地址:端口号/数据库名
	    @CallerSensitive
	    public static Connection getConnection(String url,
	        String user, String password) throws SQLException {
	        java.util.Properties info = new java.util.Properties();
	
	        if (user != null) {
	            info.put("user", user);
	        }
	        if (password != null) {
	            info.put("password", password);
	        }
	
	        return (getConnection(url, info, Reflection.getCallerClass()));
	    }
		 */
		String url = "jdbc:mysql://localhost:3306/mybase?serverTimezone=UTC";//多了?serverTimezone=UTC
		String username = "root";
		String password = "199307";
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println(conn);
		
		
		/*
		 * 3.获取语言执行平台.获取连接对象获取对SQL语句的执行对象
		 * conn对象调用Statement接口的实现类，在mysql驱动程序中
		 */
		Statement state = conn.createStatement();
		
		
		/*
		 * 4.执行sql语句
		 * 通过执行者对象调用SQL语句，获取数据库中SQL语句
		 * int executeUpdate(String sql) 执行数据库中的SQL语句，insert update delete
		 */
		//insert
		
		
		String deleteSql = "delete from sort where sname= '机箱'";
		int row = state.executeUpdate(deleteSql);
		if(row == 1) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		
		String insertSql = "INSERT INTO sort(sname,sprice,sdesc) VALUES ('机箱',1999,'ROG太阳神')";
		row = state.executeUpdate(insertSql);
		if(row == 1) {
			System.out.println("写入成功");
		}else {
			System.out.println("写入失败");
		}
		
		String updateSql = "update sort set sprice = 1999 where sid = 1";
		row = state.executeUpdate(updateSql);
		if(row == 1) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		/*
		 * 执行SQL语句获取结果集
		 * ResultSet executeQuery(String sql) 执行SQL语句中的select查询
		 * 返回值ResultSet接口的实现类对象，实现类在mysql驱动中
		 ResultSet 接口的方法boolean next() ,返回值为true，有结果集，返回值为false，没有结果集
		 */
		String selectSql = "select * from sort";
		ResultSet rs = state.executeQuery(selectSql);
		while(rs.next()) {
			System.out.println(rs.getInt("sid")+" "+rs.getString("sname")+" "+
		rs.getDouble("sprice")+" "+rs.getString("sdesc"));
		}
		
		//6.释放资源
		state.close();
		conn.close();
	}
}