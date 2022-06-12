package cn.edu.xit.servlet;

import cn.edu.xit.domain.Book;
import cn.edu.xit.service.BookService;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 此处补充代码，实现接收处理addbook.jsp请求 ，成功插入数据转到ListBookServlet。
		Book book =new Book();
		book.setNum(Integer.parseInt(request.getParameter("num")));
		book.setName(request.getParameter("name"));
		book.setType(request.getParameter("type"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		BookService bookService = new BookService();
		try {
			int i = bookService.addBook(book);
			response.sendRedirect("ListBookServlet");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
