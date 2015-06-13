package com.jdbc.labs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Transactional
//@Transactional(propagation=Propagation.SUPPORTS)
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BookDaoWrapper {
    @Inject
    BookDao bookDao;

    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Autowired
    public void setSimpleJdbcTemplate(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Transactional
    public List<Book> listBooks() {
//        Book book1 = new Book();
//        book1.setId(5L);
//        book1.setTitle("fake hitchhiker");
//        Book book2 = new Book();
//        book2.setId(6L);
//        book2.setTitle("fake harry potter");
//        List<Book> lb = new ArrayList<Book>();
//        lb.add(book1);
//        lb.add(book2);
        String sql = "select id, title from Book";
        List<Book> lb = simpleJdbcTemplate.query(sql, new RowMapper<Book>() {

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
}
