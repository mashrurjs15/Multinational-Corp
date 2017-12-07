package main;

public class Difference implements Metric{

	@Override
	public double getDistance(Feature f, Feature f2) {
		
		return ((Double)f.GetValue() - (Double)f2.GetValue());
	}
	
	public String getName() {
		return "Difference";
	}
}
