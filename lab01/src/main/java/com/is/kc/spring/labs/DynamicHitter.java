package com.is.kc.spring.labs;

public abstract class DynamicHitter {
	public void hit(){
		getHitCounter().increment();
	}
	
	public int getHits(){
		return getHitCounter().getHits();
	}
	
	public abstract HitCounter getHitCounter();
}
