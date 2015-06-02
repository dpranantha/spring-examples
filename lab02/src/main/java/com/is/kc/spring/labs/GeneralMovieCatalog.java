package com.is.kc.spring.labs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GeneralMovieCatalog implements MovieCatalog {

    @Override
    public List<String> getMovieCatalog() {
        return Arrays.asList(new String[] { "The Beautiful Mind", "The Avengers" });
    }

    @Override
    public Map<String, MovieCatalog> getAllMovieCatalog() {
        // TODO Auto-generated method stub
        return null;
    }

}
