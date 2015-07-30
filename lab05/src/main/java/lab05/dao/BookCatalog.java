package lab05.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lab05.model.Book;

@Component
@Transactional
public class BookCatalog implements BookDao {

    private SimpleJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert bookInserterTemplate;
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setSimpleJdbcTemplate(DataSource ds) {
        this.dataSource = ds;
        jdbcTemplate = new SimpleJdbcTemplate(ds);
        bookInserterTemplate = new SimpleJdbcInsert(ds).withTableName("Book").usingGeneratedKeyColumns("id");
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List<Book> listBooks() {
        RowMapper<Book> rm = new RowMapper<Book>() {

            @Override
            public Book mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Book book = new Book(rs.getLong("id"), rs.getString("title"));
                return book;
            }
        };
        String sql = "SELECT b.* FROM book b";
        List<Book> books = jdbcTemplate.query(sql, rm);
        return books;
    }

    @Override
    public Book saveBook(Book book) {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("title", book.getTitle());
        Number id = bookInserterTemplate.executeAndReturnKey(args);
        book.setId(id.longValue());
        return book;
    }

    @Override
    public Book findBookById(long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "SELECT id, title FROM Book WHERE id=:id";
        Book book = namedParameterJdbcTemplate.queryForObject(sql, params,
                BeanPropertyRowMapper.newInstance(Book.class));
        return book;

    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", title + "%");
        String sql = "SELECT id, title FROM Book WHERE title like :title";
        List<Book> books = namedParameterJdbcTemplate.query(sql, params, BeanPropertyRowMapper.newInstance(Book.class));
        return books;
    }

    @Override
    public void removeBook(long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);

        String sql = "DELETE FROM Book WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, paramMap);

    }

    @Override
    public void removeBook(Book book) {
        // TODO Auto-generated method stub
    }

    @Override
    public String updateBook(long id, String title) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("title", title);

        String sql = "UPDATE Book SET title=:title WHERE id=:id";
        namedParameterJdbcTemplate.update(sql, paramMap);
        return "redirect:/spring/books";
    }
}