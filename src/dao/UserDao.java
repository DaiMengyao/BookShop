package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理与userinfo表之间数据交互
 * @author Administrator
 *
 */
import entity.*;
import util.JdbcUtils;
public class UserDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public UserInfo login(String user,String password){
		UserInfo info = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from userinfo where sname = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				info = new UserInfo();
//				info.setId("sid");
//			info.setSid(rs.getInt("sid"));
//				info.setSname(user);
//				info.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return info;
	}
	
	/**
	 * 根据userid查姓名
	 */
	public   UserInfo  query(int userid){
		UserInfo info = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select nickname from User_VIP where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();

			while(rs.next()){
				info = new UserInfo();
				info.setNickname(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return info;
	}


	public List<UserInfo> queryAll_list(){
		
		List<UserInfo> list = new ArrayList<>();
		UserInfo  user = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from User_VIP ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setNickname(rs.getString("nickname"));
				user.setVipType(rs.getInt("VipType"));
				user.setVipScore(rs.getInt("VipScore"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}
	
	/**
	 * 根据id搜索用户信息
	 * @param id
	 * @return
	 */
public List<UserInfo> search(String id){
		
		List<UserInfo> list = new ArrayList<>();
		UserInfo  user = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from User_VIP where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setVipType(rs.getInt("VipType"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}

	public UserInfo query_user_details(String userid) {
		UserInfo info = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from User_VIP where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();

			while(rs.next()){
				info = new UserInfo();
				info.setNickname(rs.getString("nickname"));
				info.setSex(rs.getInt("sex"));
				info.setCountry(rs.getString("country"));
				info.setProvince(rs.getString("province"));
				info.setCity(rs.getString("city"));
				info.setVipType(rs.getInt("VipType"));
				info.setVipScore(rs.getInt("VipScore"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return info;
	}

	
}
