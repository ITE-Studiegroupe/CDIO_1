package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.Terning;

public class TerningTest2 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test2() {
		int ens = 0;
		Terning terningfordeling = new Terning();
		Terning terningfordeling1 = new Terning();

		for(int count = 0; count<100; count++) {
		terningfordeling.Kast();
		int kast = terningfordeling.getVærdi();
		terningfordeling1.Kast();
		int kast2 = terningfordeling1.getVærdi();
		if(kast == kast2) {
			ens++;
		}
		}
		//int expected = 17;
		int actual = ens;
		//assertEquals(expected, actual);
		assertTrue(actual>=15 && actual<=19);
	}

}
