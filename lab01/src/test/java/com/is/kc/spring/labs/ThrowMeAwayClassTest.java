package com.is.kc.spring.labs;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThrowMeAwayClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public  void dummyTest() {
		System.out.println("Dummy class to handle the Mercurial \"feature\" to skip empty directories");
		System.err.println("Throw this class away!");
	}
	@After
	public void tearDown() throws Exception {
	}

}
