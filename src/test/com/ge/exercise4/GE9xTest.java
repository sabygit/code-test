package com.ge.exercise4;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class GE9xTest {

    GE9x ge9xEngine4;
    GE9x ge9xEngine1;
    GE9x ge9xEngine2;
    GE9x ge9xEngine3;

    @Before
    public void setUp() {
    	ge9xEngine1 = new GE9x("0001");
    	ge9xEngine2 = new GE9x("0002",23000,2);
    	ge9xEngine3 = new GE9x("0003",0,5);
    	ge9xEngine4 = new GE9x("0004",12000,0);
        
    }

    @Test
    public void toStringTest() {
        assertEquals("GE9x SN: 0001", ge9xEngine1.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(ge9xEngine1.takeoffThrust / ge9xEngine1.wetWeight, ge9xEngine1.thrustToWeightRatio(), 0.01);
    }
	@Test
	public void hoursLeftBeforeRebuildTest() {
		
		assertEquals(ge9xEngine2.hoursLeftBeforeRebuild(), 7000, 0.01);
	}

	@Test
	public void serviceLifeLeftTest() {
		
		assertEquals(ge9xEngine2.serviceLifeLeft(), 67000, 0.01);
	}
	
	@Test
	public void hoursLeftBeforeRebuildWhenNoService() {
		
		assertEquals(ge9xEngine3.hoursLeftBeforeRebuild(), 0, 0.01);
	}

	@Test
	public void serviceLifeLeftTestWhenNoService() {
		assertEquals(ge9xEngine3.serviceLifeLeft(), 0 , 0.01);
	}
	
	@Test
	public void hoursLeftBeforeRebuildWithZeroRebuildTest() {
		
		assertEquals(ge9xEngine4.hoursLeftBeforeRebuild(), 18000, 0.01);
	}

	@Test
	public void serviceLifeLeftTestWhenNoRebuildTest() {
		assertEquals(ge9xEngine4.serviceLifeLeft(), 138000, 0.01);
	}

}
