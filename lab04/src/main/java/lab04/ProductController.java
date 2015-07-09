package lab04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
   
    @RequestMapping(method=RequestMethod.GET, value="/product", headers="Accept=application/xml")
    public @ResponseBody Product getProduct() {
        Product p = new Product("The Martian",4L);
        return p;
    }

    @RequestMapping(method=RequestMethod.GET, value="/productJSON", headers="Accept=application/json")
    public @ResponseBody Product getProductJSON() {
        Product p = new Product("The Flying Martian",10L);
        return p;
    }
}
