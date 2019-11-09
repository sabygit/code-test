package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GE90Test {

    GE90 gen90Engine4;
    GE90 gen90Engine1;
    GE90 gen90Engine2;
    GE90 gen90Engine3;

    @Before
    public void setUp() {
    	gen90Engine1 = new GE90("0001");
    	gen90Engine2 = new GE90("0002",8000,2);
    	gen90Engine3 = new GE90("0003",0,3);
    	gen90Engine4 = new GE90("0004",6000,0);
        
    }

    @Test
    public void toStringTest() {
        assertEquals("GE90 SN: 0001", gen90Engine1.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(gen90Engine1.takeoffThrust / gen90Engine1.wetWeight, gen90Engine1.thrustToWeightRatio(), 0.01);
    }
	@Test
	public void hoursLeftBeforeRebuildTest() {
		
		assertEquals(gen90Engine2.hoursLeftBeforeRebuild(), 17000, 0.01);
	}

	@Test
	public void serviceLifeLeftTest() {
		
		assertEquals(gen90Engine2.serviceLifeLeft(), 17000, 0.01);
	}
	
	@Test
	public void hoursLeftBeforeRebuildWhenNoService() {
		
		assertEquals(gen90Engine3.hoursLeftBeforeRebuild(), 0, 0.01);
	}

	@Test
	public void serviceLifeLeftTestWhenNoService() {
		assertEquals(gen90Engine3.serviceLifeLeft(), 0 , 0.01);
	}
	
	@Test
	public void hoursLeftBeforeRebuildWithZeroRebuildTest() {
		
		assertEquals(gen90Engine4.hoursLeftBeforeRebuild(), 19000, 0.01);
	}

	@Test
	public void serviceLifeLeftTestWhenNoRebuildTest() {
		assertEquals(gen90Engine4.serviceLifeLeft(), 69000, 0.01);
	}

}