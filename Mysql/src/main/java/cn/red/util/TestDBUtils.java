package cn.red.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDBUtils {
	@Test
	public void testConn() throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select username from users");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("username"));
		}
		
		DBUtils.close(conn, ps, rs);
		
	}
	
	@Test
	public void testConn1() throws SQLException {
		Connection conn = DBUtils.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from sort");
		
		ResultSet rs = ps.executeQuery();
		
		//创建集合对象
		List<Sort> list = new ArrayList<Sort>();
		
		while(rs.next()) {
			Sort s =new Sort();
			s.setSid(rs.getInt("sid"));
			s.setSdesc(rs.getString("sdesc"));
			s.setSname(rs.getString("sname"));
			s.setSprice(rs.getDouble("sprice"));
			list.add(s);
		}
		
		for(Sort sort:list) {
			System.out.println(sort);
		}
		DBUtils.close(conn, ps, rs);
		
	}
}
