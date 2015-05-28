package com.is.kc.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorDI {
    @Autowired
    private PrinterService printer;

    @Autowired
    public ConstructorDI(PrinterService printer) {
        this.printer = printer;
    }

    public void speakOut(String message) {
        printer.print(message);
    }
}
