package main;

import java.io.Serializable;


public class AbsoluteDifference implements Metric, Serializable {

	/**
	 * This function calculates the Absolute Difference between two features f and f2 and returns the double result.
	 * 
	 * @param f
	 *            the first feature to be compared
	 * @param f2
	 *            the second feature to be compared
	 *            
	 * @return the calculated absolute difference between the two features f and f2
	 */
	@Override
	public double getDistance(Feature f, Feature f2) {

		return Math.abs((Double.parseDouble(f.GetValue().toString())) - (Double.parseDouble(f2.GetValue().toString())));
	}

	/**
	 * This function returns the Absolute Difference Metric formated as a string
	 * 
	 * @return metric formated as a string
	 */
	public String getName() {
		return "AbsoluteDifference";
	}
}
