package com.is.kc.spring.labs;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
@Action
public class ActionMovieCatalog implements MovieCatalog {

    @Override
    public List<String> getMovieCatalog() {
        return Arrays.asList(new String[] { "The Grave of Fireflies", "My Neighbour Totoro" });
    }

}
