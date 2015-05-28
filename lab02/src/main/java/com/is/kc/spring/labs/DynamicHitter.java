package com.is.kc.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class DynamicHitter {
    public void hit() {
        getHitCounter().increment();
    }

    public int getHits() {
        return getHitCounter().getHits();
    }

    @Autowired
    public abstract HitCounter getHitCounter();
}
