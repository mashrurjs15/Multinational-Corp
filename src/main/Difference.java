package main;

import java.io.Serializable;

public class Difference implements Metric, Serializable {

	/**
	 * This function calculates the difference between features f and f2 and returns the double result.
	 * 
	 * @param f
	 *            the first feature to be compared
	 * @param f2
	 *            the second feature to be compared
	 *            
	 * @return the double result of the difference between feature f and f2.
	 */
	@Override
	public double getDistance(Feature f, Feature f2) {

		return ((Double) f.GetValue() - (Double) f2.GetValue());
	}

	/**
	 * This function returns the Difference Metric formated as a string
	 * 
	 * @return metric formated as a string
	 */
	public String getName() {
		return "Difference";
	}
}
