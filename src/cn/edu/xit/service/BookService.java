package cn.edu.xit.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.xit.dao.BookDao;
import cn.edu.xit.domain.Book;

public class BookService {
	private BookDao bookDao=new BookDao();
	public List<Book>  findBook() throws SQLException {
		return bookDao.findBook();
	}
	public List<Book>  findBookByName(String name) throws SQLException {
		
		return bookDao.findBookByName(name);
		
	}
	public int  addBook(Book book) throws SQLException {
		return bookDao.addBook(book);
	}
	public int  deleteBookById(int id) throws SQLException {
		return bookDao.deleteBookById(id);
	}
	public Book  findBookById(int id) throws SQLException {
		return bookDao.findBookById(id);
	}
	public int  updateBook(Book book) throws SQLException {
		return bookDao.updateBook(book);
	}

}
