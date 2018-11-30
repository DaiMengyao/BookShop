package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtils {
	static String url = null;
	static String user = null;
	static String password = null;
	static{
		try {    
			ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
			Class.forName(bundle.getString("driver"));
			url = bundle.getString("url");
			user = bundle.getString("user");
			password = bundle.getString("password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			throw new RuntimeException("获取连接失败！");
			
			
		}
		
	}
	
	
	public static void closeRes(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
		if(rs != null){
				rs.close();
		} 
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
