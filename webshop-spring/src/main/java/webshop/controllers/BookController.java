package webshop.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public ModelAndView updateBook(@ModelAttribute Book book) {
        return new ModelAndView(bookDao.updateBook(book.getId(), book.getTitle()));
    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView model) {
        model.addObject(new Book());
        model.setViewName("books/add");
        return model;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView saveBook(@Valid Book book, BindingResult result) {
        String path;
        if (result.hasErrors()) {
            path = "books/add";
        } else {
            bookDao.saveBook(book);
            path = "redirect:/spring/books";
        }
        return new ModelAndView(path);
    }
}
