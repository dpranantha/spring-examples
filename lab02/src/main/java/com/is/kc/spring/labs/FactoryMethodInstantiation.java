package com.is.kc.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactoryMethodInstantiation {
    @Autowired
    private PrinterService printer;
    private String value = "MyTest";

    private FactoryMethodInstantiation() {
    }

    @Autowired
    public static FactoryMethodInstantiation createInstance(PrinterService printer, String value) {
        FactoryMethodInstantiation instance = new FactoryMethodInstantiation();

        instance.printer = printer;
        instance.value = value;

        return instance;
    }

    public void printValue() {
        printer.print(value);
    }
}
