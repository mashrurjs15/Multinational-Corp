package main;

import java.io.Serializable;

public class AbsoluteDifference implements Metric, Serializable {

	@Override
	public double getDistance(Feature f, Feature f2) {
		
		return Math.abs((Double)f.GetValue() - (Double)f2.GetValue());
	}
	
	public String getName() {
		return "AbsoluteDifference";
	}

}
