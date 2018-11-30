package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import dao.BookDao;
import dao.OrderDao;
import dao.UserDao;
import entity.Book;
import entity.Order;
import entity.UserInfo;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		
		List<Order> orders=null;
		
		OrderDao orderDao = new OrderDao();
		BookDao  bookDao = new BookDao();
		if(type.equals("modify")){
			String order_id = request.getParameter("order_id");
			orderDao.modify();
			
		}else if(type.equals("deliver")){
			
		}else if(type.equals("query_unconsign")){
			orders=orderDao.queryAll_unconsign();
			List<Book> books = null;
			
			
			for(Order order:orders){
			String [] ids = order.getBookid().split(",");
			books=bookDao.queryBooks(ids);
			
			String bookname="";
			for(Book book:books){
				bookname+=","+book.getName();
			}
			order.setBooks(bookname.substring(1));
			}
					
		}else{
			orders=orderDao.queryAll_consign();
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
		if(orders.size() % pagesize == 0){
			totalpage = orders.size() / pagesize ;
		}else{
			totalpage = orders.size() / pagesize +1;
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
		request.setAttribute("orders", orders);
		if(type.equals("query_unconsign")){
			request.getRequestDispatcher("dingdan_guanli.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("yifahuo.jsp").forward(request, response);
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
