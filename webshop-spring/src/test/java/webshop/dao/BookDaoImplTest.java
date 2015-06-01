package webshop.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import webshop.domain.Book;

@ContextConfiguration("classpath:dao-context.xml")
@Transactional
public class BookDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testListBook() throws SQLException {
        assertNotNull("Book DAO is null.", bookDao);

        List<Book> books = bookDao.listBooks();

        assertNotNull("Book list is null.", books);

        for (Book book : books) {
            System.out.println("id: " + book.getId() + ", title: " + book.getTitle());
        }
    }

}
