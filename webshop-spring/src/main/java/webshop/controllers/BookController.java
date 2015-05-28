package webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("books")
public class BookController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listBooks(){
		ModelAndView mav = new ModelAndView();
		
		//mav.addObject(attributeValue)
		return null;
	}
}
