package main;

import java.io.Serializable;

public class AbsoluteDifference implements Metric, Serializable {

	@Override
	public double getDistance(Feature f, Feature f2) {
		
		return Math.abs((Double.parseDouble(f.GetValue().toString())) - (Double.parseDouble(f2.GetValue().toString())));
	}
	
	public String getName() {
		return "AbsoluteDifference";
	}
}
