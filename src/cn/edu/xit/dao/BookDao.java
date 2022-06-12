package cn.edu.xit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.xit.domain.Book;
import cn.edu.xit.utils.DataSourceUtils;

public class BookDao {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	    //此方法实现查找book_info表所有数据
		public List<Book>  findBook() throws SQLException {
		  // 补充代码
			String sql = "select  * from book_info ";
			List<Book> query = runner.query(sql, new BeanListHandler<Book>(Book.class));

			return query;
		}
		//此方法实现根据id查找book_info表数据
		public Book  findBookById(int id) throws SQLException {
		  // 补充代码	
				String sql ="select * from book_info where id=?";
			Book query = runner.query(sql, new BeanHandler<Book>(Book.class), id);

			return query;
		}
		//此方法实现按照书名模糊查找book_info表的数据
		public List<Book>  findBookByName(String name) throws SQLException {
			// 补充代码	
			String sql= "select * from book_info where name like?";
			List<Book> query = runner.query(sql, new BeanListHandler<Book>(Book.class), "%" + name + "%");


			return query;
		}
		//此方法实现向book_info表插入数据
		public int  addBook(Book book) throws SQLException {
			// 补充代码
			String sql="insert into book_info(name,price,num,type) values(?,?,?,?)";
			int update = runner.update(sql, book.getName(), book.getPrice(), book.getNum(), book.getType());

			return update;
		}
		//此方法实现按照id删除book_info表中数据
		public int  deleteBookById(int id) throws SQLException {
			// 补充代码
			String sql = "delete from book_info where id=?";
			int update = runner.update(sql, id);

			return update;
		}
	public int  updateBook(Book book) throws SQLException {
		// 补充代码
		String sql = "update book_info set name=?,type=?,num=?,price=? where id=?";
		int update = runner.update(sql, book.getName(), book.getType(), book.getNum(), book.getPrice(),book.getId());

		return update;
	}
		

}
