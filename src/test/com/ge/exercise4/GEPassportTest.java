package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GEPassportTest {

    GEPassport gePassPortTestEngine1;
    GEPassport gePassPortTestEngine2;
    GEPassport gePassPortTestEngine3;
    GEPassport gePassPortTestEngine4;

    @Before
    public void setUp() {
    	gePassPortTestEngine1 = new GEPassport("0001");
    	gePassPortTestEngine2 = new GEPassport("0002",14000,0);

    }

    @Test
    public void toStringTest() {
        assertEquals("GEPassport SN: 0001", gePassPortTestEngine1.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(gePassPortTestEngine1.takeoffThrust / gePassPortTestEngine1.wetWeight, gePassPortTestEngine1.thrustToWeightRatio(), 0.01);
    }
	@Test
	public void hoursLeftBeforeRebuildTest() {
		
		assertEquals(gePassPortTestEngine2.hoursLeftBeforeRebuild(), 0, 0.01);
		
	}

	@Test
	public void serviceLifeLeftTest() {
		assertEquals(gePassPortTestEngine2.serviceLifeLeft(), 0, 0.01);
	}
	

}