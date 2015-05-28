package com.is.kc.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoWireDI {
    @Autowired
    private PrinterService printer;

    public void setPrinter(PrinterService printer) {
        this.printer = printer;
    }

    public void sayHello(String message) {
        printer.print(message);
    }
}
