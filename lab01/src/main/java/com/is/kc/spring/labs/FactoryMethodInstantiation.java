package com.is.kc.spring.labs;

public class FactoryMethodInstantiation {
	private PrinterService printer;
	private String value;
	
	private FactoryMethodInstantiation(){
	}
	
	public static FactoryMethodInstantiation createInstance(
								PrinterService printer, String value){
		FactoryMethodInstantiation instance = new FactoryMethodInstantiation();
		
		instance.printer = printer;
		instance.value = value;
		
		return instance;
	}
	
	public void printValue(){
		printer.print(value);
	}
}
