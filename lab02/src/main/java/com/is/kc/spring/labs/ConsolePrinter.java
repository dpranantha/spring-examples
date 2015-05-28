package com.is.kc.spring.labs;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements PrinterService {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

}
