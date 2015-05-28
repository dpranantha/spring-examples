package com.is.kc.spring.labs;

import java.util.Arrays;
import java.util.List;

public class NameFactory {
	public List<String> createNameList(){
		return Arrays.asList(new String[]{"Arnold","Brandon","Cecil"});
	}
}
