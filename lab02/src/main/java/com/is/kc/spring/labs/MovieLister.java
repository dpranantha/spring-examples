package com.is.kc.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieLister {
    @Autowired
    private MovieCatalog movieCatalog;

    public void listMovies() {
        System.out.println(movieCatalog.getMovieCatalog());
    }
}
