package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.sun.glass.ui.CommonDialogs.Type;

import dao.UserDao;
import entity.UserInfo;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

//		String user = request.getParameter("user");
//		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
//		
		List<UserInfo> users = null;
//		
		UserDao dao = new UserDao();
//		UserInfo userInfo = dao.login(user, password);
//		if(userInfo == null){
//			printWriter.write("登陆失败");
//		}else{
//			//printWriter.write("登陆成功");
//			response.sendRedirect("index.html");
//		}
		
		/**
		 * 根据会员id查询用户信息search
		 */
		if(type.equals("search")){
			 //获取查询的内容
			 String userid = request.getParameter("userid");
			 users=dao.search(userid);
		 }else{
			  users = dao.queryAll_list();
		}
		//每页显示十个
		int pagesize = 10;
//		//获取页面的页码
		int currentpage = 1;
	    String pageno = request.getParameter("currentpage");
		if (pageno ==null) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(pageno);
		}
		//查询出对应页码的内容，总数据量
		
		//总页数
		int totalpage = 0;
		if(users.size() % pagesize == 0){
			totalpage = users.size() / pagesize ;
		}else{
			totalpage = users.size() / pagesize +1;
		}
		
		//首页和尾页处理
		if (currentpage <= 0) {
			currentpage = 1;
		} else if(currentpage>totalpage){
			currentpage=totalpage;
		}
		
		//显示每页的内容，传给页面需要的内容
		//总页数
		request.setAttribute("totalpage", totalpage);
		//当前页
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("type", type);
		request.setAttribute("users", users);
		request.getRequestDispatcher("huiyuan.jsp").forward(request, response);
	
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
