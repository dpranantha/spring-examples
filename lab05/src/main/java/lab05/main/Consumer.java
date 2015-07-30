package lab05.main;

import lab05.model.Book;

import org.springframework.web.client.RestTemplate;

public class Consumer {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/rest-api/book/books.xml", String.class);
        System.out.println("before: "+ result);
        Book addedBook = restTemplate.postForObject("http://localhost:8080/rest-api/book", new Book("The martian"), Book.class);
        System.out.println("add: " + addedBook.toString());
        result = restTemplate.getForObject("http://localhost:8080/rest-api/book/books.xml", String.class);
        System.out.println("after:" + result);
    }

}
