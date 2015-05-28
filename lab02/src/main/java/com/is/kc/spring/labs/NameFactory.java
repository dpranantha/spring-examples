package com.is.kc.spring.labs;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameFactory {
    @Autowired
    public List<String> createNameList() {
        return Arrays.asList(new String[] { "Arnold", "Brandon", "Cecil" });
    }
}
