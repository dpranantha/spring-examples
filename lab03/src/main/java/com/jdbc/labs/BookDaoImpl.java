package com.jdbc.labs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

@Transactional
@Component
public class BookDaoImpl implements BookDao {
	
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Autowired
	public void setSimpleJdbcTemplate(DataSource dataSource){
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public List<Book> listBooks() {
		String sql = "select id, title from Book";
		List<Book> lb = simpleJdbcTemplate.query(sql, new RowMapper<Book>(){

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setId(rs.getLong(1));
	            book.setTitle(rs.getString(2));
	            return book;
			}
			
		});
		return lb;
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBook(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBook(long id) {
		// TODO Auto-generated method stub

	}

	

}
