package com.is.kc.spring.labs;

public class ConsolePrinter implements PrinterService {

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
