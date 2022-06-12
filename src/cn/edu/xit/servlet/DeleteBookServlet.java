package cn.edu.xit.servlet;

import cn.edu.xit.service.BookService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 此处补充代码，实现按照图书编号删除图书的请求，成功删除数据转到ListBookServlet。
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		BookService bookService = new BookService();
		try {
			int i = bookService.deleteBookById(id);
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
