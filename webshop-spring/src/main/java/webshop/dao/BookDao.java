package webshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import webshop.domain.Book;

@Component
public class BookDao implements BookDaoInterface {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

    @Transactional
    public void persist(Book book) {
        em.persist(book);
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM BOOK b ORDER BY b.id", Book.class);
        return query.getResultList();
    }

    @Override
    public Book saveBook(Book book) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book findBookById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeBook(Book book) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeBook(long id) {
        // TODO Auto-generated method stub

    }

}
