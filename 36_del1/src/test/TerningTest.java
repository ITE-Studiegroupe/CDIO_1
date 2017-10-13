package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.Terning;

public class TerningTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Terning terningfordeling = new Terning();
		Terning terningfordeling1 = new Terning();
		//int side1 = 0;
		int side2 = 0;
		int side3 = 0;
		int side4 = 0;
		int side5 = 0;
		int side6 = 0;
		int side7 = 0;
		int side8 = 0;
		int side9 = 0;
		int side10 = 0;
		int side11 = 0;
		int side12 = 0;
		
		for (int i = 0; i < 1000; i ++) {
		terningfordeling.Kast();
		int kast = terningfordeling.getVærdi();
		terningfordeling1.Kast();
		kast = kast + terningfordeling1.getVærdi();
		//if (1 == kast) side1++;
		if (2 == kast) side2++;
		else if (3 == kast) side3++;
		else if (4 == kast) side4++;
		else if (5 == kast) side5++;
		else if(6 == kast) side6++;
		else if(7== kast) side7++;
		else if (8 == kast) side8++;
		else if (9 == kast) side9++;
		else if (10 == kast) side10++;
		else if(11 == kast) side11++;
		else if(12== kast) side12++;
		}
		 
		System.out.println(" resultat "+"  " +side2 + " " + side3 + " "+ side4 + " " +side5+ " " +side6+ " " +side7 + " " +side8+ " " +side9+ " " +side10+ " " +side11+ " " +side12); 

		assertTrue("Antal syvere" + side7,side7 >= 159 && side7 <= 173);
	}

}
