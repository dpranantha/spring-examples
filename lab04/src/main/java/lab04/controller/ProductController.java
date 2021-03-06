package lab04.controller;

import lab04.model.Identity;
import lab04.model.Product;
import lab04.model.ProductListInfo;
import lab04.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="product")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public @ResponseBody Product getAProduct(@PathVariable long id) {
        return repository.getProduct(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Product saveAProduct(@RequestBody Product product) {
        return new Identity(repository.saveProduct(product));
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody ProductListInfo getAllProduct() {
        return ProductListInfo.from("product", repository.getAllProduct());
    }

    @RequestMapping(method=RequestMethod.GET, value="/inxml", headers="Accept=application/xml")
    public @ResponseBody Product getProductXML() {
        Product p = new Product("The Martian XML",4L);
        return p;
    }

    @RequestMapping(method=RequestMethod.GET, value="/injson", headers="Accept=application/json")
    public @ResponseBody Product getProductJSON() {
        //implement a transformer
        Product p = new Product("The Flying Martian JSON",10L);
        return p;
    }

    @RequestMapping(method=RequestMethod.GET, value="/inhtml", headers="Accept=text/html")
    public @ResponseBody Product getProductHTML() {
        //by default becomes XML
        Product p = new Product("The Flying Martian HTML",10L);
        return p;
    }
}
