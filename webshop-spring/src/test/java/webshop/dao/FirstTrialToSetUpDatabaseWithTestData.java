package webshop.dao;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import webshop.domain.Book;

@ContextConfiguration(value = "classpath:dao-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class FirstTrialToSetUpDatabaseWithTestData extends
		AbstractTransactionalJUnit4SpringContextTests {

	SimpleJdbcTemplate simpleJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		simpleJdbcTemplate = new SimpleJdbcTemplate(ds);
	}

	@Before
	public void setUp() {
		String sql = "CREATE TABLE `springbol`.`Book` ( "
				+ " `id` INT NOT NULL AUTO_INCREMENT, "
				+ " `title` VARCHAR(45) , " + "  PRIMARY KEY (`id`), "
				+ "  UNIQUE INDEX `title_UNIQUE` (`title` ASC));";
		Map<String, String> map = new HashMap<String, String>();
		simpleJdbcTemplate.update(sql, map);

		List<Book> books = Arrays.asList(new Book("Return of the King"),
				new Book("Return of Javascript"), new Book("Dutch skies"),
				new Book("Somewhere in between"));
		String sqlInsert = "INSERT INTO `springbol`.`Book` (`title`) VALUES (?);";
		for (Book book : books) {
			simpleJdbcTemplate.update(sqlInsert, book.getTitle());
		}

	}

	@Test
	public void queryTheBookTableToLookForBookWithIdIsOne() throws InterruptedException {
		String sql = "SELECT b.* FROM Book b WHERE b.id=?";
		RowMapper<Book> rowMapper = new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int arg1) throws SQLException {
				Book book = new Book(rs.getLong("id"), rs.getString("title"));
				return book;
			}
		};
		Book book = simpleJdbcTemplate.queryForObject(sql, rowMapper, 2L);
		assertThat(book.getId(), is(2L));

	}

	@After
	public void tearDown() {
		String sql = "DROP TABLE `springbol`.`Book`;";
		Map<String, ?> map = null;
		simpleJdbcTemplate.update(sql, map);
	}

}
