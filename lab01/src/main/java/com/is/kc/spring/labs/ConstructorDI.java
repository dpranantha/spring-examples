package com.is.kc.spring.labs;

public class ConstructorDI {
	private PrinterService printer;

	public ConstructorDI(PrinterService printer) {
		this.printer = printer;
	}
	
	public void speakOut(String message){
		printer.print(message);
	}
}
