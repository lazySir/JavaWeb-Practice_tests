package cn.edu.xit.servlet;

import cn.edu.xit.domain.Book;
import cn.edu.xit.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = new Book();
        book.setPrice(Double.parseDouble(req.getParameter("price")));
        book.setType(req.getParameter("type"));
        book.setName(req.getParameter("name"));
        book.setId(Integer.parseInt(req.getParameter("id")));
        book.setNum(Integer.parseInt(req.getParameter("num")));
        System.out.println(book);
        BookService bookService = new BookService();
        try {
            int i = bookService.updateBook(book);
            resp.sendRedirect("ListBookServlet");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
