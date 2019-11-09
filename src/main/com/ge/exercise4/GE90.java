package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 {
	private static final Logger logger = LogManager.getLogger(GE90.class);

	private static final String ENGINE_MODEL = GE90.class.getSimpleName();
	private final String serialNumber;

	public final int maxNumRebuilds = 3;
	public final double flightHoursBeforeRebuild = 25_000;
	public final double dryWeight = 14_502;
	public final double wetWeight = 15_100;
	public final double takeoffThrust = 81_070;

	private double flightHours;
	private int numRebuilds;

	private double currentFlightHours;

	public GE90(String serialNumber, double flightHours, int numRebuilds) {
		this.serialNumber = serialNumber;
		this.flightHours = flightHours;
		this.setNumRebuilds(numRebuilds);
		this.currentFlightHours = (flightHoursBeforeRebuild * numRebuilds) + flightHours;
	}

	public GE90(String serialNumber, double flightHours) {
		this(serialNumber, flightHours, 0);
	}

	public GE90(String serialNumber) {
		this(serialNumber, 0.0);
	}

	public double getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(double flightHours) {
		this.flightHours = flightHours;
	}

	public double thrustToWeightRatio() {
		return takeoffThrust / wetWeight;
	}

	public String toString() {
		return ENGINE_MODEL + " SN: " + serialNumber;
	}

	public int getNumRebuilds() {
		return numRebuilds;
	}

	public void setNumRebuilds(int numRebuilds) {
		this.numRebuilds = numRebuilds;
	}

	public double hoursLeftBeforeRebuild() {
		if (numRebuilds < maxNumRebuilds)
			return flightHoursBeforeRebuild - flightHours;
		else
			return 0;
	}

	public double serviceLifeLeft() {
		if (numRebuilds <= maxNumRebuilds)
			return (flightHoursBeforeRebuild * maxNumRebuilds) - currentFlightHours;
		else
			return 0;
	}

}
