package lab05.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lab05.model.Book;

@Component
@Transactional
public class BookDaoWrapper {

    @Autowired
    BookDao bookDao;

    public Book saveBook(Book book) {
        return bookDao.saveBook(book);
    }

    public void removeBook(long id) {
        bookDao.removeBook(id);
    }

    public void removeBook(Book book) {
        bookDao.removeBook(book);
    }

    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    public Book findBookById(long id) {
        return bookDao.findBookById(id);
    }

}
