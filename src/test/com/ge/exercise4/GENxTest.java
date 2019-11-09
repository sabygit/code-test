package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GENxTest {

	
	GENx genxTestEngine1;
	GENx genxTestEngine2;
	GENx genxTestEngine3;
	GENx genxTestEngine4;

	@Before
	public void setUp() {
		genxTestEngine1 = new GENx("0001");
		genxTestEngine2=new GENx("0002",5000,2);
		genxTestEngine3=new GENx("0003",0,4);
		genxTestEngine4 = new GENx("0004",15000,0);
	}

	@Test
	public void toStringTest() {
		assertEquals("GENx SN: 0001", genxTestEngine1.toString());
	}

	@Test
	public void thrustToWeightRatioTest() {
		assertEquals(genxTestEngine1.takeoffThrust / genxTestEngine1.wetWeight, genxTestEngine1.thrustToWeightRatio(), 0.01);
	}

	@Test
	public void hoursLeftBeforeRebuildTest() {
		
		assertEquals(genxTestEngine2.hoursLeftBeforeRebuild(), 15000, 0.01);
	}

	@Test
	public void serviceLifeLeftTest() {
		assertEquals(genxTestEngine2.serviceLifeLeft(), 35000, 0.01);
	}
	
	@Test
	public void hoursLeftBeforeRebuildWhenNoService() {
		
		assertEquals(genxTestEngine3.hoursLeftBeforeRebuild(), 0, 0.01);
	}

	@Test
	public void serviceLifeLeftTestWhenNoService() {
		assertEquals(genxTestEngine3.serviceLifeLeft(), 0 , 0.01);
	}
	
	@Test
	public void hoursLeftBeforeRebuildWithZeroRebuildTest() {
		
		assertEquals(genxTestEngine4.hoursLeftBeforeRebuild(), 5000, 0.01);
	}

	@Test
	public void serviceLifeLeftTestWhenNoRebuildTest() {
		assertEquals(genxTestEngine4.serviceLifeLeft(), 65000, 0.01);
	}


}