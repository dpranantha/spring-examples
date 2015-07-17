package webshop.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webshop.dao.BookDao;
import webshop.domain.Book;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listBooks() {
        return new ModelAndView("books/index", "books", bookDao.listBooks());
    }

    @RequestMapping(value ="edit", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookDao.findBookById(id);
        ModelAndView model = new ModelAndView("books/edit");
        model.addObject("book", book);

        return model;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) {
        System.out.println(book.getTitle() + " "+ book.getId());
        return new ModelAndView(bookDao.updateBook(book.getId(), book.getTitle()));
    }
}
