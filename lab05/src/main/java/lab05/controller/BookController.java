package lab05.controller;

import java.util.List;

import lab05.dao.BookDao;
import lab05.model.Book;
import lab05.model.BookList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="book")
public class BookController {
    @Autowired
    BookDao bookCatalog;

    @RequestMapping(method = RequestMethod.GET, value = "books.xml")
    public @ResponseBody BookList listBooksXml() {
        List<Book> books = bookCatalog.listBooks();
        return new BookList(books);
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Book saveABook(@RequestBody Book book) {
        return bookCatalog.saveBook(book);
    }
}
