package webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webshop.dao.BookDaoImpl;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookDaoImpl bookDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listBooks() {
        return new ModelAndView("books/index", "books", bookDao.listBooks());
    }
}
