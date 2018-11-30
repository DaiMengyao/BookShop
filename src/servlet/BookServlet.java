package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BookDao;
import entity.Book;
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String type = request.getParameter("type");
		
		BookDao bookDao=new BookDao();
		if(type.equals("delete")){
			String id = request.getParameter("id");
			bookDao.delete(id);
		}
		
		
		List<Book> books=null;
		
		 if(type.equals("search")){
			 //获取查询的内容
			 String sub_bookname = request.getParameter("sub_bookname");
			 books=bookDao.search(sub_bookname);
		 }else{
			  books = bookDao.queryAll_list();
		 }
		//每页显示十个
			int pagesize = 10;
//			//获取页面的页码
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
			if(books.size() % pagesize == 0){
				totalpage = books.size() / pagesize ;
			}else{
				totalpage = books.size() / pagesize +1;
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
		request.setAttribute("books", books);
		request.getRequestDispatcher("shangpin_fabu.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
