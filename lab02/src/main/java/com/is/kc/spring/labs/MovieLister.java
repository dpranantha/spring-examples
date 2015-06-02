package com.is.kc.spring.labs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieLister {
    @Autowired
    @Action
    private MovieCatalog movieCatalog;

    @Autowired
    private Map<String, MovieCatalog> allCatalogs;

    public void listMovies() {
        System.out.println(movieCatalog.getMovieCatalog());
    }

    public void allListMovies() {
        for (String key : allCatalogs.keySet()) {
            System.out.println(key);
            for (String title : allCatalogs.get(key).getMovieCatalog()) {
                System.out.println("-" + title);
            }
        }
    }
}
