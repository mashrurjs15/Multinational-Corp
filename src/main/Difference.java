package main;

import java.io.Serializable;

public class Difference implements Metric, Serializable{

	@Override
	public double getDistance(Feature f, Feature f2) {
		
		return ((Double)f.GetValue() - (Double)f2.GetValue());
	}
	
	public String getName() {
		return "Difference";
	}
}
