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
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    @Test
    public void testPersist() throws Exception {
        Book book = new Book();

        em.getTransaction().begin();

        em.persist(book);

        em.getTransaction().commit();

        assertNotNull(book.getId());
    }

    @After
    public void closeEntityManager() {
        em.close();
        emf.close();
    }

}
