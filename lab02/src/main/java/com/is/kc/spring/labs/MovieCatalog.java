package com.is.kc.spring.labs;

import java.util.List;
import java.util.Map;

public interface MovieCatalog {
    public List<String> getMovieCatalog();
    public Map<String, MovieCatalog> getAllMovieCatalog();
}
