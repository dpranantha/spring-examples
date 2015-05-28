package com.is.kc.spring.labs;

public class Hitter {
	private HitCounter counter;
	
	public void hit(){
		counter.increment();
	}
	
	public HitCounter getCounter(){
		return counter;
	}
	
	public void setCounter(HitCounter counter){
		this.counter = counter;
	}
	
	public void print(){
		System.out.println("Your hit number is " + counter.getHits());
	}
}
