package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Euclidian implements Metric, Serializable {

	/**
	 * This function calculates the euclidian difference between two cartesian
	 *  features f and f2 and returns the double result.
	 * 
	 * @param f
	 *            the first feature to be compared
	 * @param f2
	 *            the second feature to be compared
	 *            
	 * @return the calculated euclidian difference between the two cartesian features f and f2
	 */
	@Override
	public double getDistance(Feature f, Feature f2) {

		double runningSum = 0;

		ArrayList<Number> fValues = (ArrayList<Number>) f.GetValue();
		ArrayList<Number> f2Values = (ArrayList<Number>) f2.GetValue();

		for (int i = 0; i < fValues.size(); i++) {
			runningSum += (Math.pow((f2Values.get(i).GetValue() - fValues.get(i).GetValue()), 2));
		}
		return Math.sqrt(runningSum);


	}

	/**
	 * This function returns the Euclidian Metric formated as a string
	 * 
	 * @return metric formated as a string
	 */
	public String getName() {
		return "Euclidian";
	}

}
