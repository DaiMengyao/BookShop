package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.JdbcUtils;

public class CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Category> queryall() {
		List<Category> list = new ArrayList<>();
		Category  category = null;
		try {
			//获取连接
			conn = JdbcUtils.getConnection();
			//ps对象发送sql
			String sql = "select * from Category ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				category = new Category();
				category.setCategory_name(rs.getString("category_name"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return list;
	}

}
