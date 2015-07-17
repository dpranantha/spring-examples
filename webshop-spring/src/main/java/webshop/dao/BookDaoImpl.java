package webshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import webshop.domain.Book;

public class BookDaoImpl implements BookDao {
    @PersistenceContext(name="default")
    EntityManager entityManager;

    @Transactional
    public void persist(Book book) {
        entityManager.persist(book);
    }

    public void setEM(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        Query query = entityManager.createQuery("select b from Book b order by id");
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

    @Override
    public String updateBook(long id, String title) {
        // TODO Auto-generated method stub
        return null;
    }

}
