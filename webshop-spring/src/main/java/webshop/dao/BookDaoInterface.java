package webshop.dao;

import webshop.domain.Book;

import java.util.List;

public interface BookDaoInterface {
    List<Book> listBooks();
    Book saveBook(Book book);
    Book findBookById(long id);
    List<Book> findBooksByTitle(String title);
    void removeBook(Book book);
    void removeBook(long id);
}