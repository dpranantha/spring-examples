package webshop.dao;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.*;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import webshop.domain.Book;

@ContextConfiguration(value = "classpath:dao-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public class TestInitDBWithSpring {

    @Inject
    BookDao bookDao;

    @Test
    public void findAllBooksShouldFind4Books() {
        List<Book> books = bookDao.listBooks();
        assertThat(books.size(), is(4));
    }

    @Test
    public void saveBookInDBShouldReturnTotalCountOf5Books() throws Exception {
        Book book = new Book("JDBC Spring revisited");
        bookDao.saveBook(book);
        List<Book> books = bookDao.listBooks();
        assertThat(books.size(), is(5));
    }

    @Test
    public void findBookByIdShouldReturn1Book() throws Exception {
        Book book = bookDao.findBookById(1L);
        assertThat(book, is(notNullValue(Book.class)));
    }

    @Test
    public void removeBookById() throws Exception {
        int totalBooksBeforeRemove = bookDao.listBooks().size();
        assertThat(totalBooksBeforeRemove, is(4));
        Book book = bookDao.findBookById(1L);
        bookDao.removeBook(book.getId());
        int currentNumberOfBooks = bookDao.listBooks().size();
        assertThat(currentNumberOfBooks, is(totalBooksBeforeRemove - 1));
    }

    @Test
    public void removeBookWithBook() throws Exception {
        int totalBooksBeforeRemove = bookDao.listBooks().size();
        assertThat(totalBooksBeforeRemove, is(4));
        Book book = bookDao.findBookById(1L);
        bookDao.removeBook(book);
        int currentNumberOfBooks = bookDao.listBooks().size();
        assertThat(currentNumberOfBooks, is(totalBooksBeforeRemove - 1));
    }
}
