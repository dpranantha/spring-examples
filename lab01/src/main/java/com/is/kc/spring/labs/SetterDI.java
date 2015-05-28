package com.is.kc.spring.labs;

public class SetterDI {
	private PrinterService printer;

	public void setPrinter(PrinterService printer) {
		this.printer = printer;
	}
	
	public void sayHello(String message){
		printer.print(message);
	}
}
