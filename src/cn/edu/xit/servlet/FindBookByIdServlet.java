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
 * Servlet implementation class FindBookByIdServlet
 */
@WebServlet("/FindBookById")
public class FindBookByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 此处补充代码，实现按照书号查找图书信息并且转到updatebook.jsp
		int id = Integer.parseInt(request.getParameter("id"));
		BookService bookService = new BookService();
		try {
			Book bookById = bookService.findBookById(id);
			request.getSession().setAttribute("book",bookById);
			response.sendRedirect("updatebook.jsp");
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
