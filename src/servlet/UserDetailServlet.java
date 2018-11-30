package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.UserInfo;


@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		String userid=request.getParameter("userid");
		
		UserDao userDao = new UserDao();
		//根据会员号查询会员信息
		UserInfo  user = userDao.query_user_details(userid);
		

		request.setAttribute("user", user);
		request.getRequestDispatcher("huiyuan_detail.jsp").forward(request, response);
		printWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
