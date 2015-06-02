package com.is.kc.spring.labs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
@Action
public class ActionMovieCatalog implements MovieCatalog {

    @Override
    public List<String> getMovieCatalog() {
        return Arrays.asList(new String[] { "The Grave of Fireflies", "My Neighbour Totoro" });
    }

    @Override
    public Map<String, MovieCatalog> getAllMovieCatalog() {
        HashMap<String, MovieCatalog> aMap = new HashMap<String, MovieCatalog>(); 
        //aMap.put("Action", Arrays.asList(new String[] { "The Grave of Fireflies", "My Neighbour Totoro" }));
        return null;
    }

}
