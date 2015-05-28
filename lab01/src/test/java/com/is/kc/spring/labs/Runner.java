package com.is.kc.spring.labs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        PrinterService printer = applicationContext.getBean(PrinterService.class);
        printer.print("Hallo!");

        SetterDI setterDI = applicationContext.getBean(SetterDI.class);
        setterDI.sayHello("Hallo World!");

        ConstructorDI constructorDI = applicationContext.getBean(ConstructorDI.class);
        constructorDI.speakOut("Hallo World 2!");

        AutoWireDI autowireDI = applicationContext.getBean(AutoWireDI.class);
        autowireDI.sayHello("Hallo World 3!");

        FactoryMethodInstantiation factoryMethodInstantiation = applicationContext
                .getBean(FactoryMethodInstantiation.class);
        factoryMethodInstantiation.printValue();

        NameFactory nameFactory = applicationContext.getBean(NameFactory.class);
        System.out.println(nameFactory.createNameList().toString());

        Hitter hitter1 = applicationContext.getBean("hitter1", Hitter.class);
        Hitter hitter2 = applicationContext.getBean("hitter2", Hitter.class);
        hitter1.hit();
        hitter1.hit();
        hitter2.hit();
        hitter2.hit();
        hitter1.print();

        DynamicHitter dynamicHitter = applicationContext.getBean(DynamicHitter.class);
        dynamicHitter.hit();
        dynamicHitter.hit();
        dynamicHitter.hit();
        System.out.println("Number of hits = " + dynamicHitter.getHits());
    }

}
