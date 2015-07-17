package webshop.dao;

import webshop.domain.Book;

import java.util.List;

public interface BookDao {
    List<Book> listBooks();
    String updateBook(long id, String title);
    Book saveBook(Book book);
    Book findBookById(long id);
    List<Book> findBooksByTitle(String title);
    void removeBook(Book book);
    void removeBook(long id);
}
