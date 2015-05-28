package com.is.kc.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Hitter {
    @Autowired
    private HitCounter counter;

    public void hit() {
        counter.increment();
    }

    public HitCounter getCounter() {
        return counter;
    }

    public void setCounter(HitCounter counter) {
        this.counter = counter;
    }

    public void print() {
        System.out.println("Your hit number is " + counter.getHits());
    }
}
