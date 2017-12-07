package main;
import java.io.Serializable;
import java.util.ArrayList;

public class Euclidian implements Metric, Serializable{

	@Override
	public double getDistance(Feature f, Feature f2) {
		
		double runningSum = 0;
		ArrayList<Double> fValues = (ArrayList<Double>)f.GetValue();
		ArrayList<Double> f2Values = (ArrayList<Double>)f2.GetValue();
		
		for (int  i = 0; i < fValues.size() ; i++) {
			runningSum += (Math.pow((f2Values.get(i) - fValues.get(i)), 2));
		}
		return Math.sqrt(runningSum);
		
		
		
	}
	
	public String getName() {
		return "Euclidian";
	}

}
