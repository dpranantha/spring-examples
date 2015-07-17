package webshop.dao;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import webshop.domain.Book;

@ContextConfiguration(value = "classpath:dao-context.xml")
@TransactionConfiguration(defaultRollback=true)
public class TestJdbcTemplateBookDao extends AbstractTransactionalJUnit4SpringContextTests {

	
	
	@Inject
	ApplicationContext applicationContext;
	
	@Inject
	BookDao bookDao;
	
//	@Inject
//	BookDaoWrapper bookDao;
	
	
	@Test
	public void findAllBooksShouldFind4Books() {
		List<Book> books = bookDao.listBooks();
		assertThat(books.size(), is(4));
	}
	
	@Test
	public void saveBookInDBShouldReturnTotalCountOf5Books() throws Exception {
		Book book=new Book("JDBC Spring revisited");
		bookDao.saveBook(book);
		List<Book> books = bookDao.listBooks();
		assertThat(books.size(), is(5));
	}

	@Test
	public void saveBookWithWrapper() throws Exception {
		int totalBooksBeforeSave = countRowsInTable("Book");
		Book book=new Book("JDBC Spring revisited");
		bookDao.saveBook(book);
		book=new Book("JDBC Spring 4 revisited");
		bookDao.saveBook(book);
		int totalBooksAfterSave=countRowsInTable("Book");
		assertThat(totalBooksAfterSave,is(totalBooksBeforeSave+2) );
	}
	
	@Test
	public void findBookByIdShouldReturn1Book() throws Exception {
		Book book = bookDao.findBookById(1L);
		assertThat(book, is(notNullValue(Book.class)));
	}
	
	@Test
	public void removeBookById() throws Exception {
		int totalBooksBeforeRemove = countRowsInTable("Book");
		assertThat(totalBooksBeforeRemove, is(4));
		Book book = bookDao.findBookById(1L);
		bookDao.removeBook(book.getId());
		int currentNumberOfBooks = countRowsInTable("Book");
		assertThat(currentNumberOfBooks, is(totalBooksBeforeRemove-1));
	}
	
	@Test
	public void removeBookWithBook() throws Exception {
		int totalBooksBeforeRemove = countRowsInTable("Book");
		assertThat(totalBooksBeforeRemove, is(4));
		Book book = bookDao.findBookById(1L);
		bookDao.removeBook(book);
		int currentNumberOfBooks =countRowsInTable("Book");
		assertThat(currentNumberOfBooks, is(totalBooksBeforeRemove-1));
	}
}
