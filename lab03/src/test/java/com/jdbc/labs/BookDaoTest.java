package com.jdbc.labs;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:dao-context.xml")
public class BookDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private BookDao bookDao;
	
	@Before
	public void setUp(){
	}
	
	@Transactional
	@Test
	public void testListBook(){

        List<Book> books = bookDao.listBooks();

        assertNotNull("Book list is null.", books);

        for (Book book : books) {
            System.out.println("id: " + book.getId() + ", title: " + book.getTitle());
        }
	}
	
	@After
	public void tearDown(){
		
	}
}
