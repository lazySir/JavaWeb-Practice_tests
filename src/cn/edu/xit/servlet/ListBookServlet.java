package cn.edu.xit.servlet;

import cn.edu.xit.domain.Book;
import cn.edu.xit.service.BookService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 此处补充代码，接收index.jsp请求，查找所有的图书信息并且转到listbook.jsp
		BookService bookService = new BookService();
		List<Book> book = null;
		try {
			book = bookService.findBook();
			if(book!=null){
				request.getSession().setAttribute("books",book);
				response.sendRedirect("listbook.jsp");
			}

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
