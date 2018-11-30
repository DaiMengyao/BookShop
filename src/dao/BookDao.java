package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import util.JdbcUtils;
import entity.Book;


public class BookDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Book> queryAll(String category){
		
		List<Book> list = new ArrayList<>();
		 Book  book = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from Book where category like '%"+category+"%'";
			//String sql = "select * from Book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("bookname"));
				book.setImageUrl(rs.getString("ImageUrl"));
				book.setPrice(rs.getDouble("price"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}
	
	public List<Book> queryBooks(String[] ids){
		
		List<Book> list = new ArrayList<>();
		 Book  book = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			int idInt = 0;
			for(String id:ids) {
				idInt = Integer.parseInt(id);
				//ps对象发送sql
				String sql = "select * from Book where id="+idInt;
				//String sql = "select * from Book";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			if(rs.next()){
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("bookname"));
				book.setImageUrl(rs.getString("ImageUrl"));
				book.setPrice(rs.getDouble("price"));
				list.add(book);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}
	public  Book queryBook(int id){
		
		 Book  book = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from Book where id = "+id;
			//String sql = "select * from Book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("bookname"));
				book.setImageUrl(rs.getString("ImageUrl"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				book.setDescriptionImage(rs.getString("DescriptionImage"));
				book.setCount(rs.getInt("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return book;
	}
	
	public List<Book> queryAll_list(){
		
		List<Book> list = new ArrayList<>();
		 Book  book = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from Book ";
			//String sql = "select * from Book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("bookname"));
				book.setPrice(rs.getDouble("price"));
				book.setCategory(rs.getString("category"));
				book.setAuthor(rs.getString("author"));
				book.setCount(rs.getInt("count"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}
	
public List<Book> search(String sub_bookname){
		
		List<Book> list = new ArrayList<>();
		 Book  book = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from Book where bookname like '%"+sub_bookname+"%'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("bookname"));
				book.setPrice(rs.getDouble("price"));
				book.setCategory(rs.getString("category"));
				book.setAuthor(rs.getString("author"));
				book.setCount(rs.getInt("count"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}

	public boolean delete(String id) {
		
		boolean res = false;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "delete from Book where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			int n = ps.executeUpdate();
			if(n>0) {
				res=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return res;
	}
	
	
	
	public boolean insert(Book book){
		boolean res = false;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "insert Book values(?,?,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,  0);
			ps.setString(2, book.getName());
			ps.setString(3, book.getCategory());
			ps.setString(4, book.getAuthor());
			ps.setDouble(5, book.getPrice());
			ps.setString(6, book.getImageUrl());
			ps.setInt(7, book.getCount());
			ps.setString(8, book.getDescriptionImage());
			int n = ps.executeUpdate();
			if(n>0) {
				res=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return res;
	}
	

	
	
}
	

