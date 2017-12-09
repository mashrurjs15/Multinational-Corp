package main;

import java.io.Serializable;

public class BooleanCompare implements Metric, Serializable {

	/**
	 * This function compares between two boolean features f and f2 and returns true if they are the same, 
	 * false if they are not.
	 * 
	 * @param f
	 *            the first feature to be compared
	 * @param f2
	 *            the second feature to be compared
	 *            
	 * @return true - both boolean features are the same, false - boolean features are not the same.
	 */
	@Override
	public double getDistance(Feature f, Feature f2) {

		// compare names if they are equal return 0, else return 1

		if (f.GetValue().equals(f2.GetValue()))
			return 0;
		return 1;
	}

	/**
	 * This function returns the BooleanCompare Metric formated as a string
	 * 
	 * @return metric formated as a string
	 */
	public String getName() {
		return "BooleanCompare";
	}
}
