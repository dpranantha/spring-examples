package com.jdbc.labs;

import java.util.List;

public interface BookDao {
    List<Book> listBooks();
    Book saveBook(Book book);
    Book findBookById(long id);
    List<Book> findBooksByTitle(String title);
    void removeBook(Book book);
    void removeBook(long id);
}