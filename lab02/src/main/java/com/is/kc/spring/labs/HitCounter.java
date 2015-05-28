package com.is.kc.spring.labs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HitCounter {
    private int hits;

    public void increment() {
        hits++;
    }

    public int getHits() {
        return hits;
    }
}
