package webshop.dao;

import webshop.domain.Book;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface BookDao {
    List<Book> listBooks();
    Book saveBook(Book book);
    Book findBookById(long id);
    List<Book> findBooksByTitle(String title);
    void removeBook(Book book);
    void removeBook(long id);
}
