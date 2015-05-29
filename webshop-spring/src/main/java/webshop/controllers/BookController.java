package webshop.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webshop.dao.BookDao;

@Controller
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ModelAndView listBooks(HttpServletRequest request) {
        System.out.println("Here!");
        return new ModelAndView("books.jsp", "bookDao", bookDao);
    }
}
