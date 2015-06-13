package com.jdbc.labs;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:dao-context.xml")
public class BookDaoWrapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Inject
    private BookDaoWrapper bookDao;
    
    //same as BookDaoTest, this should be commented if we use jdbc:initialize-db configuration 
    private SimpleJdbcTemplate simpleJdbcTemplate;
    

    @Inject
    public void setSimpleJdbcTemplate(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    
    @Before
    @Rollback(false)
    public void setUp() {
         try { 
            initDB();
            insertBooksAutoId(); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Transactional
    @Test
    public void testListBook() {

        List<Book> books = bookDao.listBooks();

        assertNotNull("Book list is null.", books);

        for (Book book : books) {
            System.out.println("id: " + book.getId() + ", title: " + book.getTitle());
        }
    }

    @After
    @Rollback(false)
    public void tearDown() {
        try { 
            deleteData();
            dropTable(); 
        }catch (Exception e) { e.printStackTrace(); }
        
    }

    // ////////manual create, insert, drop functions, without jdbc:initialize-database
    private void initDB() throws Exception {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/mysql/initDB.sql"));
            LineNumberReader fileReader = new LineNumberReader(in);
            String query = JdbcTestUtils.readScript(fileReader);
            simpleJdbcTemplate.getJdbcOperations().execute(query);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private void insertBooksAutoId() throws Exception {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/mysql/insertOne.sql"));
            LineNumberReader fileReader = new LineNumberReader(in);
            String query = JdbcTestUtils.readScript(fileReader);
            int n[] = simpleJdbcTemplate.getJdbcOperations().batchUpdate(query.split("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private void dropTable() throws Exception {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/mysql/populateDB.sql"));
            LineNumberReader fileReader = new LineNumberReader(in);
            String query = JdbcTestUtils.readScript(fileReader);
            simpleJdbcTemplate.getJdbcOperations().execute(query);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    
    private void deleteData() throws Exception {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/mysql/deleteData.sql"));
            LineNumberReader fileReader = new LineNumberReader(in);
            String query = JdbcTestUtils.readScript(fileReader);
            String[] queries = query.split("\n");
            int[] n = simpleJdbcTemplate.getJdbcOperations().batchUpdate(queries);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
