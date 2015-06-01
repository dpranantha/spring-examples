package webshop.dao;

import org.junit.*;

import webshop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

public class StandaloneJpaTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("standalone");
        em = emf.createEntityManager();
    }

    @Test
    public void testPersist() throws Exception {
        Book book = new Book();

        book.setId((long) 1);
        book.setTitle("The hitchhiker guide to the galaxy");

        Book book2 = new Book();

        book2.setId((long) 2);
        book2.setTitle("Harry potter and the prisoner of Azkaban");

        em.getTransaction().begin();

        em.persist(book);
        em.persist(book2);

        em.getTransaction().commit();

        assertNotNull(book.getId());
    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }

}
