package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import util.JdbcUtils;

public class OrderDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Order> queryAll_consign( ){
		List<Order> list = new ArrayList<>();
		Order  order = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from `Order` where status= 1 ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOrder_id(rs.getString("order_id"));
				order.setBookid(rs.getString("bookid"));
				order.setPayTime(rs.getDate("payTime"));
				order.setUserid(rs.getInt("userid"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}
	
	
	public List<Order> queryAll_unconsign( ){
		List<Order> list = new ArrayList<>();
		Order  order = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from `Order` where status= 0 ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOrder_id(rs.getString("order_id"));
				order.setBookid(rs.getString("bookid"));
				order.setPayTime(rs.getDate("payTime"));
				order.setUserid(rs.getInt("userid"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}
	
	
	public void modify() {
		
		
	}
}
