package main;

import java.io.Serializable;

/**
 * the metric interface contains the getDistance and getName functions required by all metrics.
 */

public interface Metric {

	/**
	 * This function calculates the distance between two features f and f2 and returns the double result.
	 * 
	 * @param f
	 *            the first feature to be compared
	 * @param f2
	 *            the second feature to be compared
	 *            
	 * @return the calculated distance between the two features f and f2
	 */
	public double getDistance(Feature f, Feature f2);

	/**
	 * This function returns the Metric formated as a string
	 * 
	 * @return metric formated as a string
	 */
	public String getName();
}
